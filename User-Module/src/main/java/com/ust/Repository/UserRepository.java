package com.ust.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.model.User;

public interface UserRepository extends JpaRepository<User,String> {

	public User getByUserid(int Id);
}
