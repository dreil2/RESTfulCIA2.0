package com.conygre.training.dao.fake;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

import com.conygre.training.dao.CompactDiscDAO;
import com.conygre.training.entities.CompactDisc;

@Alternative
public class FakeCompactDiscDAO {
	
	private List<CompactDisc> library;
		
	
	public FakeCompactDiscDAO() {
		library = new ArrayList<CompactDisc>();
		library.add(new CompactDisc("Gold", 12.99, "Abba"));
		library.add(new CompactDisc("Spice World", 4.99, "Spice Girls"));
		library.add(new CompactDisc("Money for Nothing", 7.99, "Dire Straits"));
		library.add(new CompactDisc("True", 5.99, "Spandau Ballet"));
		library.add(new CompactDisc("Justin", 4.99, "Justin Bieber"));
	}
	
	
	
	
	
	public List<CompactDisc> getLibrary() {
		return library;
	}

	public void setLibrary(List<CompactDisc> library) {
		this.library = library;
	}

	public void addCompactDisc(CompactDisc disc) {
		// TODO Auto-generated method stub
		library.add(disc);

	}

	public CompactDisc getCompactDiscByTitle(String title) {
		// Assumes only 1 CD ever has a particular title
		for (CompactDisc compactDisc : library) {
			if (compactDisc.getTitle().equals(title)) {
				return compactDisc;
			}
		}
		// will only return if there are no matches
		return null;
	}

	public List<CompactDisc> getDiscsByArtist(String artist) {
		List<CompactDisc> returnDiscs = new ArrayList<CompactDisc>();
		for (CompactDisc compactDisc : library) {
			if (compactDisc.getArtist().equals(artist)) {
				returnDiscs.add(compactDisc);
			}
		}
		return returnDiscs;	}

	public List<CompactDisc> getAllDiscs() {
		// TODO Auto-generated method stub
		return library;
	}


}
