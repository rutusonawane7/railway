package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.SaveRecord;

public interface SaveRecordRepo extends JpaRepository<SaveRecord, Long> {
	
	

}
