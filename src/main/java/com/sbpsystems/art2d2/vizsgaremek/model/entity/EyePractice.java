package com.sbpsystems.art2d2.vizsgaremek.model.entity;

import com.sbpsystems.art2d2.vizsgaremek.model.entity.enums.EyePracticeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "eye_practice")
public class EyePractice extends PersistentObjectWithId {

	private String name;
	private EyePracticeType type;
	private Integer recommendedTime;
	private String disclaimer;

	// getters and setters

	@NotNull
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EyePractice that = (EyePractice) o;
		return type == that.type;
	}

	@Override public int hashCode() {
		return Objects.hashCode(type);
	}

	@NotNull
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	public EyePracticeType getType() {
		return type;
	}

	public void setType(EyePracticeType type) {
		this.type = type;
	}

	@Column(name = "recommended_time")
	public Integer getRecommendedTime() {
		return recommendedTime;
	}

	public void setRecommendedTime(Integer recommendedTime) {
		this.recommendedTime = recommendedTime;
	}

	@Column(name = "disclaimer")
	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

}
