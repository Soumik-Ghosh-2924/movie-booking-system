package com.domain.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.system.models.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> 
{
	

}
