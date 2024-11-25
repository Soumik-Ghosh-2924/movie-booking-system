package com.institutional.moviebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.institutional.moviebookingsystem.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
