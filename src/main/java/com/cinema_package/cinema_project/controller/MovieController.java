package com.cinema_package.cinema_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.cinema_package.cinema_project.models.Prevbookhistory;
import com.cinema_package.cinema_project.models.Movie;
import com.cinema_package.cinema_project.models.LatestMovReq;
import com.cinema_package.cinema_project.service.MovieService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
    

    @GetMapping("/movie")
    public List<Movie> getMovies(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String genre

    ) {return movieService.getAllMovies(title, date, location, genre);}

    
    
    
    
    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable("id") Integer id) 
    {
    	System.out.println("Here's your requested Movie .");
        return movieService.getMovieById(id);
    }

    
    
    
    
    @GetMapping("/movie/booking/history")
    public List<Prevbookhistory> getBookingHistory(){
    	
    	System.out.println("Here's your booking history");
    	
        return movieService.getBookingHistory();
    }


    
    
    
    
    @PostMapping("/movie")
    public String addMovie(@RequestBody LatestMovReq movie) {
        movieService.addMovie(movie);
        
        return "The movie has been added.";
    }

    
    
    
    
    @PostMapping("/movie/booking/{movieId}/{quantity}/{totalPrice}")
    public String createBooking(
            @PathVariable("movieId") Integer id,
            @PathVariable("quantity") Integer quantity,
            @PathVariable("totalPrice") Integer totalPrice
    ) {
        movieService.bookTickets(id, quantity, totalPrice);
        return "Your booking is done.";
    }
    
    
    
    
    @DeleteMapping("/movie/{movieId}")
    public String deleteMovie(@PathVariable("movieId") Integer id) {
        movieService.deleteMovie(id);
        
        return "Deleted the Movie.";
    }

    
    
    
    
    @PutMapping("/movie/{movieId}")
    public String updateMovie(@PathVariable("movieId") Integer id, @RequestBody LatestMovReq movie) 
    {
        movieService.updateMovie(id, movie);
        
        return "Updated the Movie";
    }


}