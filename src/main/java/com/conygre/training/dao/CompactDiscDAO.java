package com.conygre.training.dao;

import java.util.Collection;
import java.util.List;

import com.conygre.training.entities.CompactDisc;

public interface CompactDiscDAO {
	
	void addCompactDisc(CompactDisc disc);
	CompactDisc getCompactDiscByTitle(String title);
	List<CompactDisc> getDiscsByArtist(String artist);
	CompactDisc  findById(int id); 
	List<CompactDisc> getAllDiscs();
}
