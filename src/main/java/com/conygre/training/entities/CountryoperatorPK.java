package com.conygre.training.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the countryoperator database table.
 * 
 */
@Embeddable
public class CountryoperatorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private double mCC;

	private double mNC;

	public CountryoperatorPK() {
	}
	public double getMCC() {
		return this.mCC;
	}
	public void setMCC(double mCC) {
		this.mCC = mCC;
	}
	public double getMNC() {
		return this.mNC;
	}
	public void setMNC(double mNC) {
		this.mNC = mNC;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CountryoperatorPK)) {
			return false;
		}
		CountryoperatorPK castOther = (CountryoperatorPK)other;
		return 
			(this.mCC == castOther.mCC)
			&& (this.mNC == castOther.mNC);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.mCC) ^ (java.lang.Double.doubleToLongBits(this.mCC) >>> 32)));
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.mNC) ^ (java.lang.Double.doubleToLongBits(this.mNC) >>> 32)));
		
		return hash;
	}
}