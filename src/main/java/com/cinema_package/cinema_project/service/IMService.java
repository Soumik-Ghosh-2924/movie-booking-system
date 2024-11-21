package com.cinema_package.cinema_project.service;
import com.cinema_package.cinema_project.models.Prevbookhistory;
import com.cinema_package.cinema_project.models.Movie;
import com.cinema_package.cinema_project.models.LatestMovReq;

import java.time.LocalDate;
import java.util.List;

public interface IMService 
{

    public List<Movie> filterMovies(String title, LocalDate date, String location, String genre);

    public List<Movie> getAllMovies(String title, LocalDate date, String location, String genre);

    public Movie getMovieById(Integer id);

    public List<Prevbookhistory> getBookingHistory();

    public void bookTickets(Integer id, Integer tickets, Integer payment);

    public void addMovie(LatestMovReq request);

    public void deleteMovie(Integer id);

    public void updateMovie(Integer id, LatestMovReq request);
}

