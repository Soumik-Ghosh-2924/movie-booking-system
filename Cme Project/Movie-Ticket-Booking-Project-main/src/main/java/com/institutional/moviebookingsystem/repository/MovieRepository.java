
package com.institutional.moviebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.institutional.moviebookingsystem.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}