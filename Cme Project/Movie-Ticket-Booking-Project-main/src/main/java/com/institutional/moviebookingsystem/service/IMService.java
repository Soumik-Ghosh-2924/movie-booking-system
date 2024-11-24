package com.institutional.moviebookingsystem.service;
import java.time.LocalDate;
import java.util.List;

import com.institutional.moviebookingsystem.models.BookingHistory;
import com.institutional.moviebookingsystem.models.Movie;
import com.institutional.moviebookingsystem.models.NewMovieRequest;

public interface IMService 
{

    public List<Movie> filterMovies(String title, LocalDate date, String location, String genre);

    public List<Movie> getAllMovies(String title, LocalDate date, String location, String genre);

    public Movie getMovieById(Integer id);

    public List<BookingHistory> getBookingHistory();

    public void bookTickets(Integer id, Integer tickets, Integer payment);

    public void addMovie(NewMovieRequest request);

    public void deleteMovie(Integer id);

    public void updateMovie(Integer id, NewMovieRequest request);
}

