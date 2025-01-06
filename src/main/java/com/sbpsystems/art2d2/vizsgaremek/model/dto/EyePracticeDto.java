package com.sbpsystems.art2d2.vizsgaremek.model.dto;

import com.sbpsystems.art2d2.vizsgaremek.model.entity.enums.EyePracticeType;

public class EyePracticeDto {

	private Long id;
	private String name;
	private EyePracticeType type;
	private Integer recommendedTime;
	private String disclaimer;

	public EyePracticeDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EyePracticeType getType() {
		return type;
	}

	public void setType(EyePracticeType type) {
		this.type = type;
	}

	public Integer getRecommendedTime() {
		return recommendedTime;
	}

	public void setRecommendedTime(Integer recommendedTime) {
		this.recommendedTime = recommendedTime;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
}