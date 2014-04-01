package com.conygre.training.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Failureclass.class)
public abstract class Failureclass_ {

	public static volatile SingularAttribute<Failureclass, String> description;
	public static volatile SingularAttribute<Failureclass, Integer> failureClass;

}

