package com.hospitality.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospitality.reservation.entity.Reservation;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}

