package com.domain.system.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domain.system.models.Cinema;
import com.domain.system.models.CinemaBookingHistory;
import com.domain.system.models.NewCinemaReq;
import com.domain.system.services.CinemaService;

@RestController
public class CinemaController 
{
	
	@Autowired
	private CinemaService cinemaService;
	
	
	
	@GetMapping("/cinema")
	public List<Cinema> getAllCinema(
			@RequestParam(required= false) String title,
			@RequestParam(required= false) String genre,
			@RequestParam(required= false) String location,
			@RequestParam(required= false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date)
	{
		
		System.out.println("Here's the list of all the movies !");
		
		return cinemaService.getAllCinema(title, genre,location,date);
	}
	
	
	
	@GetMapping("/cinema/{id}")
	public Cinema getCinemaById(@PathVariable Integer id)
	{
		System.out.println("Here's your requested Cinema!");
		
		return cinemaService.getCinemaById(id);
	}
	
	
	
	
	@GetMapping("/cinema/booking/history")
    public List<CinemaBookingHistory> getBookingHistory()
	{
    	
    	System.out.println("Here's your booking history");
    	
        return cinemaService.getBookingHistory();
    }
	
	
	
	
	@PostMapping("/cinema")
	public String addCinema(@RequestBody NewCinemaReq cinema)
	{
		cinemaService.addCinema(cinema);
		
		System.out.println("New Cinema has been added !");		
		return "New Cinema has been added !";
		
	}
	
	
	

	
	@PostMapping("/cinema/booking/{id}/{quantity}/{totalPrice}")
    public String createBooking(
            @PathVariable Integer id,
            @PathVariable int quantity,
            @PathVariable int totalPrice
    ) 
	{
		System.out.println("Your booking is done. ");
        cinemaService.bookTickets(id, quantity, totalPrice);
        return "Your booking is done.";
    }
	
	
	
	
	
	
	@DeleteMapping("/cinema/{id}")
    public String deleteCinema(@PathVariable Integer id) {
		
		System.out.println("Deleted the movie.");
        cinemaService.deleteCinema(id);
        return "Deleted the Movie.";
    }
	
	
	
	
	
	
	@PutMapping("/cinema/{id}")
	public String  updateCinema(@PathVariable Integer id, @RequestBody NewCinemaReq request)
	{
		cinemaService.updateCinema(id, request);
		System.out.println("The Cinema details have been udated. ");
		return "The Cinema details have been udated.";
		
	}	
	

}
