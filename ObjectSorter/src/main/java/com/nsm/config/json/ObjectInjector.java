package com.nsm.config.json;

import org.json.JSONObject;

import com.nsm.sorter.model.Specified;
import com.nsm.sorter.model.Unspecified;

public class ObjectInjector {

	private static enum RULETYPES {
		ALL, SPECIFIC;
	}

	public static Object newSorterObjectInstance(JSONObject jsonObject) {
		switch (RULETYPES.valueOf(((String) jsonObject.get("type"))
				.toUpperCase())) {
		case ALL:
			Unspecified unspecified = new Unspecified();
			unspecified.setRuleId(jsonObject.getInt("rule"));
			unspecified.setSorterField((String) jsonObject.get("field"));
			unspecified.setReverse(jsonObject.has("reverse") ? jsonObject
					.getBoolean("reverse") : false);
			return unspecified;
		case SPECIFIC:
			Specified specified = new Specified();
			specified.setRuleId(jsonObject.getInt("rule"));
			specified.setSorterField((String) jsonObject.get("field"));
			specified.setSpecificFieldType((String) jsonObject
					.get("specificfield"));
			specified.setSpecificOperation((String) jsonObject
					.get("specificOperation"));
			specified
					.setSpecificValue((String) jsonObject.get("specificvalue"));
			specified.setReverse(jsonObject.has("reverse") ? jsonObject
					.getBoolean("reverse") : false);
			return specified;
		default:
			return null;
		}
	}
}
