package dmacc.beans;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Gig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime eventDateTime;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="venue_gigs",
			joinColumns={@JoinColumn(name="venue_id",
			referencedColumnName="id") },
			inverseJoinColumns={@JoinColumn(name="gig_id",
			referencedColumnName="id", unique=true) }
	)
	private Set<Venue> venue;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="band_gigs",
			joinColumns={@JoinColumn(name="band_id",
			referencedColumnName="id") },
			inverseJoinColumns={ @JoinColumn(name="gig_id",
			referencedColumnName="id", unique=true, nullable=true) }
	)
	private Set<Band>bandGigs;
	//@ManyToOne(targetEntity=Band.class, fetch=FetchType.EAGER)
	//private Band headliner;
	
	public Gig() {
		super();
	}
	
	public Gig(String eventDateTime, Set<Venue> venue) {
		super();
		LocalDateTime eventDT = LocalDateTime.parse(eventDateTime, DateTimeFormatter.ISO_DATE_TIME);
		this.eventDateTime = eventDT;
		this.venue = venue;
	}
	
	public Gig(String eventDateTime, Set<Venue> venue, Set<Band> opener) {
		super();
		LocalDateTime eventDT = LocalDateTime.parse(eventDateTime, DateTimeFormatter.ISO_DATE_TIME);
		this.eventDateTime = eventDT;
		this.venue = venue;
		this.bandGigs = opener;
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

	public Set<Venue> venue() {
		return venue;
	}
	
	public void setVenue(Set<Venue> venue) {
		this.venue = venue;
	}

	public Set<Band> band() {
		return bandGigs;
	}
	
	public void setBand(Set<Band> band) {
		this.bandGigs = band;
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
		return "Gig [id=" + id + "eventDateTime=" + eventDateTime + "venue=" + venue.toString() + ", band=" + bandGigs.toString() + ", headliner= + headliner.toString() + ]";
	}
	
}
