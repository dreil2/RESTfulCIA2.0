package com.conygre.training.entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Cause.class)
public abstract class Cause_ {

	public static volatile SingularAttribute<Cause, CausePK> id;
	public static volatile SingularAttribute<Cause, String> description;
	public static volatile ListAttribute<Cause, Callfailure> callfailures;

}

