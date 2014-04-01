package com.conygre.training.entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Countryoperator.class)
public abstract class Countryoperator_ {

	public static volatile SingularAttribute<Countryoperator, CountryoperatorPK> id;
	public static volatile SingularAttribute<Countryoperator, String> operator;
	public static volatile ListAttribute<Countryoperator, Callfailure> callfailures;
	public static volatile SingularAttribute<Countryoperator, String> country;

}

