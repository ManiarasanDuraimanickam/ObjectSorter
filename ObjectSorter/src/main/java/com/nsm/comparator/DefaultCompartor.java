package com.nsm.comparator;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nsm.sorter.exceptions.FieldTypeNotAvailable;
import com.nsm.sorter.model.Specified;
import com.nsm.sorter.model.Unspecified;

public class DefaultCompartor<T> extends AbstractComparator implements
		Comparator<T> {
	private Logger LOG = Logger.getGlobal();

	private Object rulObj;

	public DefaultCompartor(Object rulObj) {
		super(null);
		this.rulObj = rulObj;
	}

	@Override
	public int compare(Object o1, Object o2) {

		int res = -1;
		try {
			String declaredMt = null;
			boolean reverse = false;
			if (rulObj instanceof Unspecified) {
				Unspecified unspecified = (Unspecified) rulObj;
				declaredMt = unspecified.getSorterField();
				reverse = unspecified.isReverse();
			} else if (rulObj instanceof Specified) {
				Specified specified = (Specified) rulObj;
				declaredMt = specified.getSorterField();
				reverse = specified.isReverse();
			}
			Field field1 = o1.getClass().getDeclaredField(declaredMt);
			Field field2 = o2.getClass().getDeclaredField(declaredMt);
			return fieldTypeCheck(field1, o1, field2, o2, reverse);
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException
				| FieldTypeNotAvailable e) {
			LOG.log(Level.ALL, e.getMessage());
		}
		return res;

	}

}
