package com.conygre.training.entities;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(CompactDisc.class)
public abstract class CompactDisc_ {

	public static volatile SingularAttribute<CompactDisc, Integer> id;
	public static volatile SingularAttribute<CompactDisc, String> title;
	public static volatile SingularAttribute<CompactDisc, Double> price;
	public static volatile SetAttribute<CompactDisc, Track> trackTitles;
	public static volatile SingularAttribute<CompactDisc, String> artist;

}

