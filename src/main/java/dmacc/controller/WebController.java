package dmacc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Band;
import dmacc.beans.Gig;
import dmacc.beans.Venue;
import dmacc.repository.BandRepository;
import dmacc.repository.GigRepository;
import dmacc.repository.VenueRepository;

@Controller
public class WebController {
	@Autowired
	BandRepository bandRepo;
	@Autowired
	VenueRepository venueRepo;
	@Autowired
	GigRepository gigRepo;
	
	@GetMapping("/viewAllBands")
	public String viewAllBands(Model model) {
		model.addAttribute("bands", bandRepo.findAll());
		return "bandResults";
	}
	
	@GetMapping("/inputBand")
	public String addNewBand(Model model) {
		Band b = new Band();
		model.addAttribute("newBand", b);
		return "bandInput";
	}
	
	@PostMapping("/inputBand")
	public String addNewBand(@ModelAttribute Band b, Model model) {
		bandRepo.save(b);
		model.addAttribute("bands", bandRepo.findAll());
		return "bandResults";
	}
	
	@GetMapping("/editBand/{id}")
	public String showBandUpdateForm(@PathVariable("id") long id, Model model) {
		Band b = bandRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid band Id:" + id));
		model.addAttribute("band", b);
		return "bandUpdate";
	}
	
	@PostMapping("/updateBand/{id}")
	public String updateBand(@PathVariable("id") long id, @Valid Band b, BindingResult result, Model model) {
		if (result.hasErrors()) {
			b.setId(id);
			return "bandUpdate";
		}
		
		bandRepo.save(b);
		model.addAttribute("bands", bandRepo.findAll());
		return "bandResults";
	}
	
	@GetMapping("/deleteBand/{id}")
	public String deleteBand(@PathVariable("id") long id, Model model) {
		Band b = bandRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid band Id:" + id));
		bandRepo.delete(b);
		model.addAttribute("bands", bandRepo.findAll());
		return "bandResults";
	}
	
	@GetMapping("/viewAllVenues")
	public String viewAllVenues(Model model) {
		model.addAttribute("venues", venueRepo.findAll());
		return "venueResults";
	}
	
	@GetMapping("/inputVenue")
	public String addNewVenue(Model model) {
		Venue v = new Venue();
		model.addAttribute("newVenue", v);
		return "venueInput";
	}
	
	@PostMapping("/inputVenue")
	public String addNewVenue(@ModelAttribute Venue v, Model model) {
		venueRepo.save(v);
		model.addAttribute("venues", venueRepo.findAll());
		return "venueResults";
	}
	
	@GetMapping("/editVenue/{id}")
	public String showVenueUpdateForm(@PathVariable("id") long id, Model model) {
		Venue v = venueRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid venue Id:" + id));
		model.addAttribute("venue", v);
		return "venueUpdate";
	}
	
	@PostMapping("/updateVenue/{id}")
	public String updateVenue(@PathVariable("id") long id, @Valid Venue v, BindingResult result, Model model) {
		if (result.hasErrors()) {
			v.setId(id);
			return "venueUpdate";
		}
		
		venueRepo.save(v);
		model.addAttribute("venues", venueRepo.findAll());
		return "venueResults";
	}
	
	@GetMapping("/deleteVenue/{id}")
	public String deleteVenue(@PathVariable("id") long id, Model model) {
		Venue v = venueRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid venue Id:" + id));
		venueRepo.delete(v);
		model.addAttribute("venues", venueRepo.findAll());
		return "venueResults";
	}
	
	
	@GetMapping("/viewAllGigs")
	public String viewAllGigs(Model model) {
		model.addAttribute("gigs", gigRepo.findAll());
		return "gigResults";
	}
	
	@GetMapping("/inputGig")
	public String addNewGig(Model model) {
		Gig g = new Gig();
		model.addAttribute("newGig", g);
		model.addAttribute("venues", venueRepo.findAll());
		model.addAttribute("bands", bandRepo.findAll());
		return "gigInput";
	}
	
	@PostMapping("/inputGig")
	public String addNewGig(@ModelAttribute Gig g, Model model) {
		gigRepo.save(g);
		model.addAttribute("gigs", gigRepo.findAll());
		return "gigResults";
	}
	
	@GetMapping("/editGig/{id}")
	public String showGigUpdateForm(@PathVariable("id") long id, Model model) {
		Gig g = gigRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid gig Id:" + id));
		model.addAttribute("gig", g);
		return "gigUpdate";
	}
	
	@PostMapping("/updateGig/{id}")
	public String updateGig(@PathVariable("id") long id, @Valid Gig g, BindingResult result, Model model) {
		if (result.hasErrors()) {
			g.setId(id);
			return "gigUpdate";
		}
		
		gigRepo.save(g);
		model.addAttribute("gigs", gigRepo.findAll());
		return "gigResults";
	}
	
	@GetMapping("/deleteGig/{id}")
	public String deleteGig(@PathVariable("id") long id, Model model) {
		Gig g = gigRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid gig Id:" + id));
		gigRepo.delete(g);
		model.addAttribute("gigs", gigRepo.findAll());
		return "gigResults";
	}
}



