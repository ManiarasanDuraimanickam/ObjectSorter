package com.nsm.sorter;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.nsm.comparator.ChainExecutionComparator;
import com.nsm.comparator.DefaultCompartor;
import com.nsm.config.json.SorterRule;

public class ChainExecutionSorter<T> extends SorterRule implements
		ObjectSorter<T> {

	public ChainExecutionSorter() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChainExecutionSorter(File configFile) throws IOException {
		super(configFile);
	}

	public ChainExecutionSorter(String configFilepath) throws IOException {
		super(configFilepath);
	}


	@Override
	public void sort(List<T> list, String key) {
		list.sort(new ChainExecutionComparator<T>(SorterRule.getSorterRules().get(key)));
	}

	@Override
	protected String getConfigFilepath() {
		return Thread.currentThread().getContextClassLoader()
				.getResource("ObjectSorterRules.json").getFile();
	}

}
