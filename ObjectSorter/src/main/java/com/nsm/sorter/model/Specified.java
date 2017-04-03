package com.nsm.sorter.model;

public class Specified extends Unspecified {

	private String specificField;
	private String specificValue;
	private String specificOperation;
	private String specificFieldType;

	public String getSpecificField() {
		return specificField;
	}

	public void setSpecificField(String specificField) {
		this.specificField = specificField;
	}

	public String getSpecificValue() {
		return specificValue;
	}

	public void setSpecificValue(String specificValue) {
		this.specificValue = specificValue;
	}

	public String getSpecificOperation() {
		return specificOperation;
	}

	public void setSpecificOperation(String specificOperation) {
		this.specificOperation = specificOperation;
	}

	public String getSpecificFieldType() {
		return specificFieldType;
	}

	public void setSpecificFieldType(String specificFieldType) {
		this.specificFieldType = specificFieldType;
	}
}
