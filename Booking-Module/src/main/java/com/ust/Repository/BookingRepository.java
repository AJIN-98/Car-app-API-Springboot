package com.ust.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
