package com.sbpsystems.art2d2.vizsgaremek.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "eye_exercise_images")
public class EyeExerciseImages extends PersistentObjectWithId {

	private EyeExercise eyeExercise;
	private Integer orderNumber;
	private String imgName;

	// getters and setters

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "eye_exercise_id")
	public EyeExercise getEyeExercise() {
		return eyeExercise;
	}

	public void setEyeExercise(EyeExercise eyeExercise) {
		this.eyeExercise = eyeExercise;
	}

	@NotNull
	@Column(name = "order_number")
	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
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
		EyeExerciseImages that = (EyeExerciseImages) o;
		return Objects.equals(eyeExercise, that.eyeExercise) && Objects.equals(orderNumber, that.orderNumber) && Objects.equals(imgName, that.imgName);
	}

	@Override public int hashCode() {
		return Objects.hash(eyeExercise, orderNumber, imgName);
	}
}
