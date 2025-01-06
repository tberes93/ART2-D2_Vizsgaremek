package com.sbpsystems.art2d2.vizsgaremek.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@MappedSuperclass
public abstract class PersistentObjectWithId implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	/** A generált elsődleges kulcs */
	@NotNull
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REMEK_SEQ")
	@SequenceGenerator(name="REMEK_SEQ", sequenceName="REMEK_SEQ", allocationSize=1)
	//@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id", nullable = false)
	public Long getId() {
		return id;
	}

	/** Beállítja az elsődleges kulcs értékét.
	 * @param id
	 * 	a surrogate ID
	 * @throws IllegalArgumentException
	 * 	ha a már beállított értéket próbálják meg más értékre módosítani
	 */
	//@Override
	public void setId(Long id) {
		if (this.id != null && !this.id.equals(id))
			throw new IllegalArgumentException(getClass().getSimpleName() + ": the primary key is immutable");
		this.id = id;
	}

}