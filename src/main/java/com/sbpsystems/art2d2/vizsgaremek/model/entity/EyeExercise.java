package com.sbpsystems.art2d2.vizsgaremek.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "eye_exercise")
public class EyeExercise extends PersistentObjectWithId {

	private String name;
	private String text;
	private EyePractice eyePractice;
	private Integer orderNumber;
	private Set<EyeExerciseImages> imagesSet;

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
	@Column(name = "text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "eye_practice_id")
	public EyePractice getEyePractice() {
		return eyePractice;
	}

	public void setEyePractice(EyePractice eyePractice) {
		this.eyePractice = eyePractice;
	}

	@NotNull
	@Column(name = "order_number")
	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	@OneToMany(mappedBy = "eyeExercise", fetch = FetchType.EAGER)
	public Set<EyeExerciseImages> getImagesSet() {
		return imagesSet;
	}

	public void setImagesSet(Set<EyeExerciseImages> imagesSet) {
		this.imagesSet = imagesSet;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EyeExercise that = (EyeExercise) o;
		return Objects.equals(eyePractice, that.eyePractice) && Objects.equals(orderNumber, that.orderNumber);
	}

	@Override public int hashCode() {
		return Objects.hash(eyePractice, orderNumber);
	}
}
