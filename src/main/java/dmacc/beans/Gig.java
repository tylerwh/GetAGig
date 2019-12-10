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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Gig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime eventDateTime;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="venue_gigs",
			joinColumns={@JoinColumn(name="venue_id",
			referencedColumnName="id") },
			inverseJoinColumns={@JoinColumn(name="gig_id",
			referencedColumnName="id", unique=true) }
	)
	private Set<Venue> venueGigs;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="band_gigs",
			joinColumns={@JoinColumn(name="band_id",
			referencedColumnName="id") },
			inverseJoinColumns={ @JoinColumn(name="gig_id",
			referencedColumnName="id", unique=true) }
	)
	private Set<Band>opener;
	//@ManyToOne(targetEntity=Band.class, fetch=FetchType.EAGER)
	//private Band headliner;
	
	public Gig() {
		super();
	}
	
	public Gig(String eventDateTime, Set<Venue> venueGigs) {
		super();
		LocalDateTime eventDT = LocalDateTime.parse(eventDateTime, DateTimeFormatter.ISO_DATE_TIME);
		this.eventDateTime = eventDT;
		this.venueGigs = venueGigs;
	}
	
	public Gig(String eventDateTime, Set<Venue> venueGigs, Set<Band> opener) {
		super();
		LocalDateTime eventDT = LocalDateTime.parse(eventDateTime, DateTimeFormatter.ISO_DATE_TIME);
		this.eventDateTime = eventDT;
		this.venueGigs = venueGigs;
		this.opener = opener;
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

	public void setEventDateTime(LocalDateTime eventDateTime) {
		this.eventDateTime = eventDateTime;
		
	}

	public Set<Venue> getVenueGigs() {
		return venueGigs;
	}

	public void setVenueGigs(Set<Venue> venueGigs) {
		this.venueGigs = venueGigs;
	}

	public Set<Band> getOpener() {
		return opener;
	}

	public void setOpener(Set<Band> opener) {
		this.opener = opener;
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
		return "Gig [id=" + id + "eventDateTime=" + eventDateTime + "venue=" + venueGigs.toString() + ", band=" + opener.toString() + ", headliner= + headliner.toString() + ]";
	}
	
}
