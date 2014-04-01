package com.conygre.training.entities;

import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Callfailure.class)
public abstract class Callfailure_ {

	public static volatile SingularAttribute<Callfailure, Cause> cause;
	public static volatile SingularAttribute<Callfailure, String> hier321;
	public static volatile SingularAttribute<Callfailure, Date> dateTime;
	public static volatile SingularAttribute<Callfailure, String> hier32;
	public static volatile SingularAttribute<Callfailure, String> iMSI;
	public static volatile SingularAttribute<Callfailure, Equipment> equipment;
	public static volatile SingularAttribute<Callfailure, String> hier3;
	public static volatile SingularAttribute<Callfailure, Integer> baseDataID;
	public static volatile SingularAttribute<Callfailure, Integer> duration;
	public static volatile SingularAttribute<Callfailure, Integer> cellId;
	public static volatile SingularAttribute<Callfailure, Countryoperator> countryoperator;
	public static volatile SingularAttribute<Callfailure, Failureclass> failureclass;
	public static volatile SingularAttribute<Callfailure, String> nEVersion;

}

