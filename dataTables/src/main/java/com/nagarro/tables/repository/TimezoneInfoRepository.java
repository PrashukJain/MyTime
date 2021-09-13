package com.nagarro.tables.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.tables.entity.TimezoneInfo;

public interface TimezoneInfoRepository extends JpaRepository<TimezoneInfo, Long>{

}
