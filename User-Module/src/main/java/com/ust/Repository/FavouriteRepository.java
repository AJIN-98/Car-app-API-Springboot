package com.ust.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.model.FavouriteVehicle;

@Repository
public interface FavouriteRepository extends JpaRepository<FavouriteVehicle, Integer> {
	FavouriteVehicle getByFavId(int id);
}
