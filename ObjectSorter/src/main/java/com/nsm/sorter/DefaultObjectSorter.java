package com.nsm.sorter;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.nsm.comparator.DefaultCompartor;
import com.nsm.config.json.SorterRule;

public class DefaultObjectSorter<T> extends SorterRule implements
		ObjectSorter<T>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DefaultObjectSorter() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort(List<T> list, String key) {
		Map<Integer, Object> rules = (Map<Integer, Object>) SorterRule
				.getSorterRules().get(key);
		for (Integer rule : rules.keySet()) {
			list.sort(new DefaultCompartor<T>(rules.get(rule)));
		}
	}

	public void sort(java.util.List<T> list, String key, int rule) {
		Map<Integer, Object> rules = (Map<Integer, Object>) SorterRule
				.getSorterRules().get(key);
		list.sort(new DefaultCompartor<T>(rules.get(rule)));
	}

	@Override
	protected String getConfigFilepath() {
		return Thread.currentThread().getContextClassLoader()
				.getResource("ObjectSorterRules.json").getFile();
	}

}
