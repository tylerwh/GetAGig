package dmacc.beans;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Gig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime eventDateTime;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="venue_gigs",
			joinColumns={@JoinColumn(name="venue_id",
			referencedColumnName="id") },
			inverseJoinColumns={ @JoinColumn(name="gig_id",
			referencedColumnName="id", unique=true) }
	)
	private Venue venue;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="band_gigs",
			joinColumns={@JoinColumn(name="band_id",
			referencedColumnName="id") },
			inverseJoinColumns={ @JoinColumn(name="gig_id",
			referencedColumnName="id", unique=true) }
	)
	private Band band;
	//@ManyToOne(targetEntity=Band.class, fetch=FetchType.EAGER)
	//private Band headliner;
	
	public Gig() {
		super();
	}
	
	public Gig(String eventDateTime, Venue venue) {
		super();
		LocalDateTime eventDT = LocalDateTime.parse(eventDateTime, DateTimeFormatter.ISO_DATE_TIME);
		this.eventDateTime = eventDT;
		this.venue = venue;
	}
	
	public Gig(String eventDateTime, Venue venue, Band opener) {
		super();
		LocalDateTime eventDT = LocalDateTime.parse(eventDateTime, DateTimeFormatter.ISO_DATE_TIME);
		this.eventDateTime = eventDT;
		this.venue = venue;
		this.band = opener;
		//this.headliner = headliner;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDateTime getEventDateTime() {
		return eventDateTime;
	}
	public void setEventDateTime(String eventDateTime) {
		LocalDateTime eventDT = LocalDateTime.parse(eventDateTime, DateTimeFormatter.ISO_DATE_TIME);
		this.eventDateTime = eventDT;
	}

	public Venue getVenue() {
		return venue;
	}
	
	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Band getBand() {
		return band;
	}
	
	public void setBand(Band opener) {
		this.band = opener;
	}
/*
	public Band getHeadliner() {
		return headliner;
	}
	
	public void setHeadliner(Band headliner) {
		this.headliner = headliner;
	}
	*/
	@Override
	public String toString() {
		return "Gig [id=" + id + "eventDateTime=" + eventDateTime + "venue=" + venue.toString() + ", band=" + band.toString() + ", headliner= + headliner.toString() + ]";
	}
	
}
