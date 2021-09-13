package com.nagarro.tables.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.tables.entity.ErrorMessage;

public interface ErrorMessageRepository extends JpaRepository<ErrorMessage, Long> {

}
