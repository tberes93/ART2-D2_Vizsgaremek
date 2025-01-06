package com.sbpsystems.art2d2.vizsgaremek.model.dto;

import com.sbpsystems.art2d2.vizsgaremek.model.entity.enums.RewardType;

public class RewardDto {

	private Long id;
	private String name;
	private RewardType type;
	private String imgName;

	public RewardDto() {
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

	public RewardType getType() {
		return type;
	}

	public void setType(RewardType type) {
		this.type = type;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
}


