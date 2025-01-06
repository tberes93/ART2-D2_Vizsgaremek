package com.sbpsystems.art2d2.vizsgaremek.model.dto;

import java.util.List;

public class EyeExerciseDto {

	private Long id;
	private Long eyePracticeId;
	private Integer orderNumber;
	private String name;
	private String text;
	private List<EyeExerciseImagesDto> images;

	public EyeExerciseDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEyePracticeId() {
		return eyePracticeId;
	}

	public void setEyePracticeId(Long eyePracticeId) {
		this.eyePracticeId = eyePracticeId;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<EyeExerciseImagesDto> getImages() {
		return images;
	}

	public void setImages(List<EyeExerciseImagesDto> images) {
		this.images = images;
	}
}


