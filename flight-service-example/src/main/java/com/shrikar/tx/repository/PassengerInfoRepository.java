package com.shrikar.tx.repository;


import com.shrikar.tx.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {
}