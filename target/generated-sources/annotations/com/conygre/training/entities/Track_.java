package com.conygre.training.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Track.class)
public abstract class Track_ {

	public static volatile SingularAttribute<Track, Integer> id;
	public static volatile SingularAttribute<Track, String> title;
	public static volatile SingularAttribute<Track, CompactDisc> disc;

}

