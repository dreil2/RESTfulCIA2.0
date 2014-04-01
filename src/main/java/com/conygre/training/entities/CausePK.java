package com.conygre.training.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the cause database table.
 * 
 */
@Embeddable
public class CausePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private double causeCode;

	private double eventId;

	public CausePK() {
	}
	public double getCauseCode() {
		return this.causeCode;
	}
	public void setCauseCode(double causeCode) {
		this.causeCode = causeCode;
	}
	public double getEventId() {
		return this.eventId;
	}
	public void setEventId(double eventId) {
		this.eventId = eventId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CausePK)) {
			return false;
		}
		CausePK castOther = (CausePK)other;
		return 
			(this.causeCode == castOther.causeCode)
			&& (this.eventId == castOther.eventId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.causeCode) ^ (java.lang.Double.doubleToLongBits(this.causeCode) >>> 32)));
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.eventId) ^ (java.lang.Double.doubleToLongBits(this.eventId) >>> 32)));
		
		return hash;
	}
}