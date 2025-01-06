package com.sbpsystems.art2d2.vizsgaremek.model.entity.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public enum EyePracticeType {

	TORNA("Torna"),
	OLVASAS("Olvasás");

	private String value;

	private EyePracticeType(String value) {
		this.value = value;
	}

	public static EyePracticeType getEyePracticeTypeByKod(String kod) {
		if (StringUtils.isBlank(kod)) {
			return null;
		}
		return Arrays.stream(EyePracticeType.values())
			.filter(item -> item.name().equals(kod)).findFirst().orElse(null);
	}

}
