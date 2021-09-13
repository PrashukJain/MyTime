package com.nagarro.tables.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.tables.entity.User;


public interface UserRepository extends JpaRepository<User, String>{

}
