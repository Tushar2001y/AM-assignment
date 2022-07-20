package com.project.asset.rmgx.repositories;

import com.project.asset.rmgx.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,Integer> {
}
