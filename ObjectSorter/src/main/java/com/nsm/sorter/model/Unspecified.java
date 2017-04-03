package com.nsm.sorter.model;

public class Unspecified {
	private int ruleId;
	private String sorterField;
	private boolean reverse;

	public boolean isReverse() {
		return reverse;
	}

	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}

	public int getRuleId() {
		return ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	public String getSorterField() {
		return sorterField;
	}

	public void setSorterField(String sorterField) {
		this.sorterField = sorterField;
	}
}
