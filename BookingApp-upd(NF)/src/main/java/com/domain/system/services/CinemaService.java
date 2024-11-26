package com.domain.system.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.system.models.Cinema;
import com.domain.system.models.CinemaBookingHistory;
import com.domain.system.models.NewCinemaReq;
import com.domain.system.repositories.CinemaRepository;

@Service
public class CinemaService implements ICinemaService
{
	@Autowired
	private CinemaRepository cinemaRepository;

	
	
	@Override
	public List<Cinema> filterCinema(String title, String genre, String location, LocalDate date)
	{
		List<Cinema> cinema = cinemaRepository.findAll();
		List<Cinema> filteredCinema = new ArrayList<>();
		
		for(Cinema c : cinema)
		{
			boolean identical =true;
			
			if(title!=null && c.getTitle().toLowerCase().contains(title.toLowerCase()))
			{
				identical=false;
			}
			if(genre !=null && c.getGenre().toLowerCase().contains(genre.toLowerCase()))
			{
				identical=false;
			}
			if(location !=null && c.getLocation().toLowerCase().contains(location.toLowerCase()))
			{
				identical=false;
			}
			if(date !=null && c.getDate().isEqual(date))
			{
				identical=false;
			}
			if(identical)
			{
				filteredCinema.add(c);
			}
		}
		
		return filteredCinema;
	}
	
	
	
	@Override
	public List<Cinema> getAllCinema(String title, String genre, String location, LocalDate date) 
	{
		if(title ==null && genre==null && location==null && date==null)
		{
			return cinemaRepository.findAll();
		}
		else
		{
			return filterCinema(title, genre, location , date);
		}
	}
	
	
	
	
	
	
	@Override
	public Cinema getCinemaById(Integer id)
	{
		return cinemaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Cinema Id: " + id));
		
	}
	
	
	
	
	
	
	
	@Override
	public List<CinemaBookingHistory> getBookingHistory() {
        List<Cinema> cinema = cinemaRepository.findAll();
        List<CinemaBookingHistory> bookingHistory = new ArrayList<>();

        for (Cinema c : cinema ) {
            int bookedTickets = c.getTotalSeats() - c.getAvailableSeats();

            if (bookedTickets > 0) {
                int totalPrice = bookedTickets * c.getPrice();

                CinemaBookingHistory booking = new CinemaBookingHistory();
                booking.setId(c.getId());
                booking.setTitle(c.getTitle());
                booking.setDirector(c.getDirector());
                booking.setDescription(c.getDescription());
                booking.setGenre(c.getGenre());
                booking.setDate(c.getDate());
                booking.setLocation(c.getLocation());
                booking.setBookedTickets(bookedTickets);
                booking.setTotalPrice(totalPrice);
                bookingHistory.add(booking);
            }
        }
        return bookingHistory;
    }
	
	
	
	
	
	@Override
	public void addCinema(NewCinemaReq request)
	{
		Cinema c = new Cinema();
		c.setDescription(request.getDescription());
        c.setDirector(request.getDirector());
        c.setGenre(request.getGenre());
        c.setTitle(request.getTitle());
        c.setDate(request.getDate());
        c.setLocation(request.getLocation());
        c.setTotalSeats(request.getTotalSeats());
        c.setAvailableSeats(request.getAvailableSeats());
        c.setPrice(request.getPrice());
		cinemaRepository.save(c);
	}
	
	
	
	
	
	
	
	@Override
	public void bookTickets(Integer id, int tickets, int payment)
	{
		Cinema c =getCinemaById(id);
		
		int availableSeats=c.getAvailableSeats();
		if(tickets>availableSeats)
		{
			throw new IllegalArgumentException("No seats available at this time.");
		}
		
		int calPricePayable=tickets * c.getPrice();
		
		if(!(payment==calPricePayable))
		{
			throw new IllegalArgumentException("Invalid Total Price.");
		}
		
		availableSeats-=tickets;
		c.setAvailableSeats(availableSeats);
		
		
		cinemaRepository.save(c);
	}
	
	
	
	
	
	
	
	
	@Override
	public void deleteCinema(Integer id)
	{
		Cinema cinema = cinemaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Cinema Id : "+ id));
		
		cinemaRepository.delete(cinema);
	}
	
	
	
	
	
	
	
	
	@Override
	public void updateCinema(Integer id, NewCinemaReq request)
	{
		Cinema cinema= cinemaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Cinema Id : "+ id));
		
		cinema.setDescription(request.getDescription());
        cinema.setDirector(request.getDirector());
        cinema.setGenre(request.getGenre());
        cinema.setTitle(request.getTitle());
        cinema.setDate(request.getDate());
        cinema.setLocation(request.getLocation());
        cinema.setTotalSeats(request.getTotalSeats());
        cinema.setAvailableSeats(request.getAvailableSeats());
        cinema.setPrice(request.getPrice());
        
        cinemaRepository.save(cinema);
	}
	
	
	
	
	
	
	
	
	
	

}
