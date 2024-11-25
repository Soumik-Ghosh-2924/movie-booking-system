package com.domain.system.services;

import java.time.LocalDate;
import java.util.List;

import com.domain.system.models.Cinema;
import com.domain.system.models.CinemaBookingHistory;
import com.domain.system.models.NewCinemaReq;

public interface ICinemaService 
{
	public List<Cinema> filterCinema(String title, String genre, String location, LocalDate date);

    public List<Cinema> getAllCinema(String title, String genre, String location, LocalDate date);

    public Cinema getCinemaById(Integer id);

    public List<CinemaBookingHistory> getBookingHistory();

    public void bookTickets(Integer id, int tickets, int payment);

    public void addCinema(NewCinemaReq request);

    public void deleteCinema(Integer id);

    public void updateCinema(Integer id, NewCinemaReq request);

}
