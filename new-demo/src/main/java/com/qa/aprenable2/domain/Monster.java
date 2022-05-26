package com.qa.aprenable2.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Monster {

//	PROPERTIES

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String speciesName;

	@Column(nullable = false)
	private String speciesFamily;

	@Column(nullable = false)
	private String speciesDiet;

	@Column(nullable = false)
	private boolean speciesFlight;

	@Column(nullable = false)
	private boolean speciesSwim;

	@Column(nullable = false)
	private String speciesOrigin;

//	CONSTRUCTORS
	public Monster(long id, String speciesName, String speciesFamily, String speciesDiet, boolean speciesFlight,
			boolean speciesSwim, String speciesOrigin) {
		super();
		this.id = id;
		this.speciesName = speciesName;
		this.speciesFamily = speciesFamily;
		this.speciesDiet = speciesDiet;
		this.speciesFlight = speciesFlight;
		this.speciesSwim = speciesSwim;
		this.speciesOrigin = speciesOrigin;
	}
	
	public Monster(String speciesName, String speciesFamily, String speciesDiet, boolean speciesFlight,
			boolean speciesSwim, String speciesOrigin) {
		super();
		this.speciesName = speciesName;
		this.speciesFamily = speciesFamily;
		this.speciesDiet = speciesDiet;
		this.speciesFlight = speciesFlight;
		this.speciesSwim = speciesSwim;
		this.speciesOrigin = speciesOrigin;
	}

	public Monster() {
		super();
	}

//	GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	public String getSpeciesFamily() {
		return speciesFamily;
	}

	public void setSpeciesFamily(String speciesFamily) {
		this.speciesFamily = speciesFamily;
	}

	public String getSpeciesDiet() {
		return speciesDiet;
	}

	public void setSpeciesDiet(String speciesDiet) {
		this.speciesDiet = speciesDiet;
	}

	public boolean isSpeciesFlight() {
		return speciesFlight;
	}

	public void setSpeciesFlight(boolean speciesFlight) {
		this.speciesFlight = speciesFlight;
	}

	public boolean isSpeciesSwim() {
		return speciesSwim;
	}

	public void setSpeciesSwim(boolean speciesSwim) {
		this.speciesSwim = speciesSwim;
	}

	public String getSpeciesOrigin() {
		return speciesOrigin;
	}

	public void setSpeciesOrigin(String speciesOrigin) {
		this.speciesOrigin = speciesOrigin;
	}

//	HASHCODE AND EQUALS

	@Override
	public int hashCode() {
		return Objects.hash(id, speciesDiet, speciesFamily, speciesFlight, speciesName, speciesOrigin, speciesSwim);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monster other = (Monster) obj;
		return id == other.id && Objects.equals(speciesDiet, other.speciesDiet)
				&& Objects.equals(speciesFamily, other.speciesFamily) && speciesFlight == other.speciesFlight
				&& Objects.equals(speciesName, other.speciesName) && Objects.equals(speciesOrigin, other.speciesOrigin)
				&& speciesSwim == other.speciesSwim;
	}
	
}
