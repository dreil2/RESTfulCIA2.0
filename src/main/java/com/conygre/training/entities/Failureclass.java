package com.conygre.training.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the failureclass database table.
 * 
 */
@Entity
@XmlRootElement
//@NamedQuery(name="Failureclass.findAll", query="SELECT f FROM Failureclass f")
@Table(name = "Failureclass", uniqueConstraints = @UniqueConstraint(columnNames = "failureClass"))
public class Failureclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int failureClass;

	private String description;

	//bi-directional many-to-one association to Callfailure
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy="failureclass")
	private List<Callfailure> callfailures;

	public Failureclass() {
	}

	public int getFailureClass() {
		return this.failureClass;
	}

	public void setFailureClass(int failureClass) {
		this.failureClass = failureClass;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Callfailure> getCallfailures() {
		return this.callfailures;
	}

	public void setCallfailures(List<Callfailure> callfailures) {
		this.callfailures = callfailures;
	}

	public Callfailure addCallfailure(Callfailure callfailure) {
		getCallfailures().add(callfailure);
		callfailure.setFailureclass(this);

		return callfailure;
	}

	public Callfailure removeCallfailure(Callfailure callfailure) {
		getCallfailures().remove(callfailure);
		callfailure.setFailureclass(null);

		return callfailure;
	}

}