package com.nsm.config.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class SorterRule {

	private static Map<String, Map<Integer, Object>> sorterRules = new HashMap<>();

	public static Map<String, Map<Integer, Object>> getSorterRules() {
		return sorterRules;
	}

	protected String configFilepath;

	protected File configFile;

	public SorterRule() throws IOException {
		super();
		prepareConfig();
	}

	public SorterRule(String configFilepath) {
		this.configFilepath = configFilepath;
	}

	public SorterRule(File configFile) {
		this.configFile = configFile;
	}

	protected String getConfigFilepath() {
		return configFilepath;
	}

	public void prepareConfig() throws IOException {
		JSONObject reqJsonObject = getScheduleJobRequestInputs();
		doProcessReqJsonObj(reqJsonObject);
	}

	private JSONObject getScheduleJobRequestInputs() throws IOException {
		InputStream inputStream = new FileInputStream(getConfigFile());
		Scanner scanner = new Scanner(inputStream);
		String inputs = scanner.useDelimiter("\\A").next();
		scanner.close();
		inputStream.close();
		return new JSONObject(inputs);
	}

	protected File getConfigFile() {
		// TODO Auto-generated method stub
		return configFile != null ? configFile : new File(getConfigFilepath());
	}

	private void doProcessReqJsonObj(JSONObject reqJsonObject) {
		for (Object key : reqJsonObject.keySet()) {
			JSONArray jsonArray = reqJsonObject.getJSONArray((String) key);
			doPrepareRuleObj(key, jsonArray);
		}
	}

	private void doPrepareRuleObj(Object key, JSONArray jsonArray) {
		Map<Integer, Object> rules = new TreeMap<>();
		Iterator<Object> itr = jsonArray.iterator();
		while (itr.hasNext()) {
			JSONObject jsonObject = (JSONObject) itr.next();
			Object obj = ObjectInjector.newSorterObjectInstance(jsonObject);
			rules.put(jsonObject.getInt("rule"), obj);
		}
		sorterRules.put((String) key, rules);
	}
}
