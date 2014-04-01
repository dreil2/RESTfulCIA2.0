package com.conygre.training.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the countryoperator database table.
 * 
 */
@Entity
@NamedQuery(name="Countryoperator.findAll", query="SELECT c FROM Countryoperator c")
public class Countryoperator implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CountryoperatorPK id;

	private String country;

	private String operator;

	//bi-directional many-to-one association to Callfailure
	@JsonIgnore
	@OneToMany(mappedBy="countryoperator")
	private List<Callfailure> callfailures;

	public Countryoperator() {
	}

	public CountryoperatorPK getId() {
		return this.id;
	}

	public void setId(CountryoperatorPK id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public List<Callfailure> getCallfailures() {
		return this.callfailures;
	}

	public void setCallfailures(List<Callfailure> callfailures) {
		this.callfailures = callfailures;
	}

	public Callfailure addCallfailure(Callfailure callfailure) {
		getCallfailures().add(callfailure);
		callfailure.setCountryoperator(this);

		return callfailure;
	}

	public Callfailure removeCallfailure(Callfailure callfailure) {
		getCallfailures().remove(callfailure);
		callfailure.setCountryoperator(null);

		return callfailure;
	}

}