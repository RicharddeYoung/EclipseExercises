package com.qa.aprenable2.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.aprenable2.domain.Monster;

@Repository
public interface MonsterRepo extends JpaRepository<Monster, Long> {

//	Derived Queries
	List<Monster> findMonsterBySpeciesOrigin(String speciesOrigin);
	
	List<Monster> findMonsterBySpeciesFamily(String speciesFamily);
	
	@Query(value = "SELECT * FROM monster WHERE species_origin = ?1 AND species_family = ?2", nativeQuery=true)
	List<Monster> findMonsterByOriginAndFamily(String speciesOrigin, String speciesFamily);
	
	@Query(value = "SELECT * FROM monster WHERE species_diet = ?1 AND species_family = ?2", nativeQuery=true)
	List<Monster> findMonsterByDietAndFamily(String speciesDiet, String speciesFamily);
	
}
