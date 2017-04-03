package com.nsm.sorter;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.nsm.config.json.SorterRule;

public class ConfigurableSorter<T> extends SorterRule implements
		ObjectSorter<T> {

	public ConfigurableSorter(File configFile) throws IOException {
		super(configFile);
	}

	public ConfigurableSorter(String configFilepath) throws IOException {
		super(configFilepath);
	}

	@Override
	public void sort(List<T> list, String key) {
		// TODO Auto-generated method stub

	}

}
