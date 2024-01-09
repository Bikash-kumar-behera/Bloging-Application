package com.pns.spring.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pns.spring.model.CardDTO;

public interface CardDAO extends JpaRepository<CardDTO, Integer> {
	@Query(value = "Select * from card_details_otm where cc_join=?",nativeQuery=true)
	Optional<List<CardDTO>> findCardsByMobileNumber(long mobileNumber);
	
}
