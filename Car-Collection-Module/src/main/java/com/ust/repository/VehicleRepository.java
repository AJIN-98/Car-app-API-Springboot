package com.ust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,String>{
  Vehicle GetByVehicleId(int id);
   void deleteByVehicleId(int id);
}
