// this is a regular JavaBean that instances of will be passed
// back to the web application clients
// the alternative is to pass entity bean references back for the CDs,
// but this would mean a substantial overhead in remote reference calls as all the data
// is accessed by the pages

package com.conygre.training.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity @Table(name="tracks")
public class Track implements Serializable {

  //Instance variables
  @Column(name="title") private String title;

//  @Column(name="cd_id", insertable=false, updatable=false)
//  private int cdId;

  @Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
  	@Column(name="id")
	private int id;

  //Methods
  public int getId(){
    return id;
  }

  public void setId(int s){
    id = s;
  }

  public void setTitle(String s){
    title = s;
  }


  public String getTitle(){
    return title;
  }

//  public int getCdId(){
//    return cdId;
//  }
//
//  public void setCdId(int id)
//  {
//	  cdId = id;
//  }

  // bidirectional
  //@JoinColumn (name="cd_id", referencedColumnName="id")
  @JsonIgnore
  @ManyToOne
  private CompactDisc disc;
  
  @JsonIgnore
  public CompactDisc getDisc() {
	return disc;
}
  @JsonIgnore
public void setDisc(CompactDisc disc) {
	this.disc = disc;
}

//constructors
  public Track(){}

  public Track(int id, int cdId, String title){
    this.title=title;
    this.id = id;
    //this.cdId = cdId;
  }
  
  
  public Track(String title) {
	  this.title = title;
  }
}