package com.nsm.sorter;
import java.util.List;

import com.nsm.sorter.exceptions.OperationNotSupport;


public interface ObjectSorter<T> {

	
	public void sort(List<T> list,String key);
	public default void sort(List<T> list,String key, int rule){
		throw new OperationNotSupport("This is not support..");
	}
}
