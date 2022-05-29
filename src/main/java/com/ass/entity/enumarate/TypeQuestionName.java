package com.ass.entity.enumarate;

public enum TypeQuestionName {
	Easy("0"), MultipleChoice("1");

	private String value;

	private TypeQuestionName(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static TypeQuestionName of(String value) {
		if (value == null) {
			return null;
		}

		for (TypeQuestionName name : TypeQuestionName.values()) {
			if (name.getValue().equals(value)) {
				return name;
			}
		}

		return null;
	}

}
