package com.domain.system.models;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity

public class Cinema {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private String title;
    private String director;
    private String description;
    private String genre;
    private LocalDate date;
    private String location;
    private int totalSeats;
    private int availableSeats;
    private int price;

    public Cinema(int id, String title, String director, String description, String genre, LocalDate date,
                 String location, int totalSeats, int availableSeats, int price) {
            this.id = id;
            this.title = title;
            this.director = director;
            this.description = description;
            this.genre = genre;
            this.date = date;
            this.location = location;
            this.totalSeats = totalSeats;
            this.availableSeats = availableSeats;
            this.price = price;
        }

    public Cinema() {}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDirector() {return director;}

    public void setDirector(String director) {this.director = director;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getGenre() {return genre;}

    public void setGenre(String genre) {this.genre = genre;}

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public LocalDate getDate() {return date;}

    public void setDate(LocalDate date) {this.date = date;}

    public String getLocation() {return location;}

    public void setLocation(String location) {this.location = location;}

    public int getTotalSeats() {return totalSeats;}

    public void setTotalSeats(int totalSeats) {this.totalSeats = totalSeats;}

    public int getAvailableSeats() {return availableSeats;}

    public void setAvailableSeats(int availableSeats) {this.availableSeats = availableSeats;}

    public int getPrice() {return price;}

    public void setPrice(int price) {this.price = price;}
}
