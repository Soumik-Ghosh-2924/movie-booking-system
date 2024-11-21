package com.cinema_package.cinema_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinema_package.cinema_project.models.Prevbookhistory;
import com.cinema_package.cinema_project.models.Movie;
import com.cinema_package.cinema_project.models.LatestMovReq;
import com.cinema_package.cinema_project.repository.MovieRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMService {

	@Autowired
	private MovieRepository movieRepository;
    
	@Override
    public List<Movie> filterMovies(String title, LocalDate date, String location, String genre) 
	{
        List<Movie> movies = movieRepository.findAll();
        List<Movie> filteredMovies = new ArrayList<>();

        for (Movie movie : movies) {
            boolean identical = true;

            if (title != null && !movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                identical = false;
            }
            if (date != null && !movie.getDate().isEqual(date)) {
                identical = false;
            }
            if (location != null && !movie.getLocation().toLowerCase().contains(location.toLowerCase())) {
                identical = false;
            }
            if (genre != null && !movie.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                identical = false;
            }
            if (identical) {
                filteredMovies.add(movie);
            }
        }

        return filteredMovies;
    }
    
    
    
	
	
	@Override
    public List<Movie> getAllMovies(String title, LocalDate date, String location, String genre) 
	{
        if (title == null && date == null && location == null && genre == null) {
            return movieRepository.findAll();
        } else {
            return filterMovies(title, date, location, genre);
        }
    }

    
    
    
	@Override
    public Movie getMovieById(Integer id) 
	{
        return movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));
    }

    
    
    
	@Override
    public List<Prevbookhistory> getBookingHistory() {
        List<Movie> movies = movieRepository.findAll();
        List<Prevbookhistory> bookHistory = new ArrayList<>();

        for (Movie movie : movies) {
            int bookedTickets = movie.getTotalSeats() - movie.getAvailableSeats();

            if (bookedTickets > 0) {
                int totalPrice = bookedTickets * movie.getPrice();

                Prevbookhistory booking = new Prevbookhistory();
                booking.setId(movie.getId());
                booking.setTitle(movie.getTitle());
                booking.setDirector(movie.getDirector());
                booking.setDescription(movie.getDescription());
                booking.setGenre(movie.getGenre());
                booking.setDate(movie.getDate());
                booking.setLocation(movie.getLocation());
                booking.setBookedTickets(bookedTickets);
                booking.setTotalPrice(totalPrice);
                bookHistory.add(booking);
            }
        }
        return bookHistory;
    }


    
	
	
	
	@Override
    public void bookTickets(Integer id,Integer tickets,Integer payment)
    {
        Movie movie = getMovieById(id);

        int availableSeats = movie.getAvailableSeats();
        if (tickets > availableSeats) {
            throw new IllegalArgumentException("Seats Unavailable.");
        }

        int calculatedTotalPrice = tickets * movie.getPrice();
        if (!payment.equals(calculatedTotalPrice)) {
            throw new IllegalArgumentException("Invalid total price.");
        }

        availableSeats -= tickets;
        movie.setAvailableSeats(availableSeats);

        movieRepository.save(movie);
    }

	
	
	
	
	
	@Override
    public void addMovie(LatestMovReq request) {
        Movie movie = new Movie();
        movie.setDescription(request.getDescription());
        movie.setDirector(request.getDirector());
        movie.setGenre(request.getGenre());
        movie.setTitle(request.getTitle());
        movie.setDate(request.getDate());
        movie.setLocation(request.getLocation());
        movie.setTotalSeats(request.getTotalSeats());
        movie.setAvailableSeats(request.getAvailableSeats());
        movie.setPrice(request.getPrice());
        movieRepository.save(movie);
    }

	
	
	
	
	
	@Override
    public void deleteMovie(Integer id)
    {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));

        movieRepository.delete(movie);
    }

    
    
    
    
	@Override
    public void updateMovie(Integer id, LatestMovReq request)
	{

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));

        movie.setDescription(request.getDescription());
        movie.setDirector(request.getDirector());
        movie.setGenre(request.getGenre());
        movie.setTitle(request.getTitle());
        movie.setDate(request.getDate());
        movie.setLocation(request.getLocation());
        movie.setTotalSeats(request.getTotalSeats());
        movie.setAvailableSeats(request.getAvailableSeats());
        movie.setPrice(request.getPrice());
        movieRepository.save(movie);
    }
}