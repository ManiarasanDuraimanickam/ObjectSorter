package com.nsm.comparator;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Map;

import com.nsm.sorter.model.Specified;
import com.nsm.sorter.model.Unspecified;

public class ChainExecutionComparator<T> extends AbstractComparator implements
		Comparator<T> {

	public ChainExecutionComparator(Map<Integer, Object> rule) {
		super(rule);
	}

	@Override
	public int compare(T o1, T o2) {
		int res = -1;
		for (Integer ruleId : rule.keySet()) {
			try {
				Object rulObj = rule.get(ruleId);
				String declaredMt = null;
				if (rulObj instanceof Unspecified) {
					Unspecified unspecified = (Unspecified) rulObj;
					declaredMt = unspecified.getSorterField();
				} else if (rulObj instanceof Specified) {
					Specified specified = (Specified) rulObj;
					declaredMt = specified.getSorterField();
				}
				Field field1 = o1.getClass().getDeclaredField(declaredMt);
				Field field2 = o2.getClass().getDeclaredField(declaredMt);
				field1.setAccessible(true);
				field2.setAccessible(true);
				if (field1.get(o1) instanceof String
						&& field2.get(o2) instanceof String) {

					res = ((String) field1.get(o1)).compareTo(((String) field2
							.get(o2)));

				} else if (field1.get(o1) instanceof Float
						&& field2.get(o2) instanceof Float) {
					res = ((Float) field1.get(o1)).compareTo(((Float) field2
							.get(o2)));

				} else if (field1.get(o1) instanceof Integer
						&& field2.get(o2) instanceof Integer) {
					res = ((Integer) field1.get(o1))
							.compareTo(((Integer) field2.get(o2)));

				}
				if (res != 0) {
					return res;
				}
			} catch (NoSuchFieldException | SecurityException
					| IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

}
