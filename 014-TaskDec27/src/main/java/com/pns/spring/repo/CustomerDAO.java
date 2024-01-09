package com.pns.spring.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pns.spring.model.CustomerDTO;

public interface CustomerDAO extends JpaRepository<CustomerDTO, Integer> {
	boolean existsByAgeAndPincodeAndAdditionalFieldAndCityAndName(int age, long pincode, Map<String,String> additionalField,
			String city, String name);

	List<CustomerDTO> findByNameAndCity(String name, String city);

	@Query("SELECT c FROM CustomerDTO c WHERE c.name=:name and c.city=:city and JSON_UNQUOTE(JSON_EXTRACT(c.additionalField, '$.\"051\"'))=:additional")
	List<CustomerDTO> findByNameAndCityAndAdditional(@Param(value = "name") String name,
			@Param(value = "city") String city, @Param(value = "additional") String additional);
}
