// This entity class uses annotations instead of the mapping XML file

package com.conygre.training.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


// add an annotations specifying the table that this will map to
@Entity @Table(name="compact_discs")
// ensure that the class implements Serializable
public class CompactDisc implements Serializable {


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		//result = prime * result + tracks;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompactDisc other = (CompactDisc) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		//if (tracks != other.tracks)
		//	return false;
		return true;
	}

	// add an attribute specifying a column for the id property
	// add attributes to ensure that the id column is automantically generated
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	// add attributes for all the remaining properties
	@Column(name="title") private String title;
	@Column(name="artist") private String artist;
	@Column(name="price") private double price;
	//@Column(name="tracks") private int tracks;

	public CompactDisc() {}

	public CompactDisc(String t, double p,String a){
	    title=t;
	    price=p;
	    artist=a;
	    //tracks=tr;
	    
	  }

	public void addTrack(Track t) {
		t.setDisc(this);
		//t.setCdId(this.id);
		trackTitles.add(t);
	}
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	public int getTracks() {
//		return tracks;
//	}
//
//	public void setTracks(int tracks) {
//		this.tracks = tracks;
//	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	// Adding relationships 
	@OneToMany(mappedBy="disc", cascade={CascadeType.PERSIST})
	private Set<Track> trackTitles = new HashSet<Track>();

	public Set<Track> getTrackTitles() {
		return trackTitles;
	}

	public void setTrackTitles(Set<Track> trackTitles) {
		this.trackTitles = trackTitles;
	}



}
