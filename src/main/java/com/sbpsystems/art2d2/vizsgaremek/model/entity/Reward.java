package com.sbpsystems.art2d2.vizsgaremek.model.entity;

import com.sbpsystems.art2d2.vizsgaremek.model.entity.enums.RewardType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "reward")
public class Reward extends PersistentObjectWithId {

	private String name;
	private RewardType type;
	private Long numberToAchieve;
	private String imgName;

	// getters and setters

	@NotNull
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	public RewardType getType() {
		return type;
	}

	public void setType(RewardType type) {
		this.type = type;
	}

	@NotNull
	@Column(name = "number_to_achieve")
	public Long getNumberToAchieve() {
		return numberToAchieve;
	}

	public void setNumberToAchieve(Long numberToAchieve) {
		this.numberToAchieve = numberToAchieve;
	}

	@NotNull
	@Column(name = "img_name")
	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Reward reward = (Reward) o;
		return type == reward.type && Objects.equals(numberToAchieve, reward.numberToAchieve);
	}

	@Override public int hashCode() {
		return Objects.hash(type, numberToAchieve);
	}
}
