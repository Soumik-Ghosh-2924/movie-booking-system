
package com.cinema_package.cinema_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema_package.cinema_project.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> 
{
	
}