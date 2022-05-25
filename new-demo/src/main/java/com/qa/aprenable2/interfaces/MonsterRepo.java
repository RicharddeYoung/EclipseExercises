package com.qa.aprenable2.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.aprenable2.domain.Monster;

@Repository
public interface MonsterRepo extends JpaRepository<Monster, Long> {

//	Derived Queries
	List<Monster> findMonsterBySpeciesOrigin(String speciesOrigin);
	
	List<Monster> findMonsterBySpeciesFamily(String speciesFamily);
	
//	@Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery=true)
//	Optional<Monster> findByUsername(String username);
	
}
