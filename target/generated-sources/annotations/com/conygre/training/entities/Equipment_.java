package com.conygre.training.entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Equipment.class)
public abstract class Equipment_ {

	public static volatile SingularAttribute<Equipment, String> operatingSystem;
	public static volatile SingularAttribute<Equipment, String> model;
	public static volatile SingularAttribute<Equipment, Integer> tAC;
	public static volatile SingularAttribute<Equipment, String> equipmentType;
	public static volatile SingularAttribute<Equipment, String> vendorName;
	public static volatile SingularAttribute<Equipment, String> manufacturer;
	public static volatile SingularAttribute<Equipment, String> marketingName;
	public static volatile SingularAttribute<Equipment, String> inputMode;
	public static volatile SingularAttribute<Equipment, String> accessCapability;
	public static volatile ListAttribute<Equipment, Callfailure> callfailures;

}

