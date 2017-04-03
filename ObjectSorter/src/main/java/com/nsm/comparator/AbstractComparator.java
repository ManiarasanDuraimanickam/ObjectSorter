package com.nsm.comparator;

import java.lang.reflect.Field;
import java.util.Map;

import com.nsm.sorter.exceptions.FieldTypeNotAvailable;

public abstract class AbstractComparator {

	public enum FIELDTYPES {
		String(""), Boolean("java.lang.Boolean"), Integer("int"), Float("float");
		private final String type;

		private FIELDTYPES(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

		public String getType1(String r) {
			return type;

		}
	}

	protected Map<Integer, Object> rule;

	public AbstractComparator(Map<Integer, Object> rule) {
		this.rule = rule;
	}

	protected int fieldTypeCheck(Field field1, Object o1, Field field2,
			Object o2, boolean reverse) throws IllegalArgumentException,
			IllegalAccessException {
		field1.setAccessible(true);
		field2.setAccessible(true);
		switch (field1.getType().getName()) {
		case "java.lang.String":
			return !reverse ? frwSortStringCompare(field1, field2, o1, o2)
					: revSortStringCompare(field1, field2, o1, o2);
		case "int":
			return !reverse ? frwSortIntCompare(field1, field2, o1, o2)
					: revSortIntCompare(field1, field2, o1, o2);
		case "float":
			return !reverse ? frwSortFloatCompare(field1, field2, o1, o2)
					: revSortFloatCompare(field1, field2, o1, o2);
		default:
			throw new FieldTypeNotAvailable(
					"Field Type not available in the AbstractComparator and the type is "
							+ field1.getType().getName());
		}
	}

	protected int frwSortStringCompare(Field field1, Field field2, Object o1,
			Object o2) throws IllegalArgumentException, IllegalAccessException {
		return ((String) field1.get(o1)).compareTo(((String) field2.get(o2)));
	}

	protected int frwSortIntCompare(Field field1, Field field2, Object o1,
			Object o2) throws IllegalArgumentException, IllegalAccessException {
		return ((Integer) field1.get(o1)).compareTo(((Integer) field2.get(o2)));
	}

	protected int frwSortFloatCompare(Field field1, Field field2, Object o1,
			Object o2) throws IllegalArgumentException, IllegalAccessException {
		return ((Float) field1.get(o1)).compareTo(((Float) field2.get(o2)));
	}

	protected int revSortStringCompare(Field field1, Field field2, Object o1,
			Object o2) throws IllegalArgumentException, IllegalAccessException {
		return ((String) field2.get(o2)).compareTo(((String) field1.get(o1)));
	}

	protected int revSortIntCompare(Field field1, Field field2, Object o1,
			Object o2) throws IllegalArgumentException, IllegalAccessException {
		return ((Integer) field2.get(o2)).compareTo(((Integer) field1.get(o1)));
	}

	protected int revSortFloatCompare(Field field1, Field field2, Object o1,
			Object o2) throws IllegalArgumentException, IllegalAccessException {
		return ((Float) field2.get(o2)).compareTo(((Float) field1.get(o1)));
	}
}
