package com.qa.aprenable2.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.aprenable2.domain.Monster;
import com.qa.aprenable2.interfaces.MonsterRepo;

@SpringBootTest
public class MonsterServiceTest {
	
	@Autowired
	private MonsterService service;
	
	@MockBean
	private MonsterRepo repo;
	
//	CREATE TEST
//	@Disabled
	@Test
	public void createTest() {
		final Monster created = new Monster(1L, "Kraken", "Cephalopod", "Piscivore", false, true, "Norse");
		
		Mockito.when(repo.saveAndFlush(created)).thenReturn(created);
		
		assertEquals(created, service.create(created));
		
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(created);
	}

//	READ TESTS
//	@Disabled
	@Test
	public void getByIdTest() {
		final Monster output = new Monster(1L, "Kraken", "Cephalopod", "Piscivore", false, true, "Norse");
		
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(output));
		
		assertEquals(output, service.getById(1L));
		
		Mockito.verify(repo, Mockito.times(1)).findById(1L);
	}

//	@Disabled
	@Test
	public void getAllTest() {
		List<Monster> output = new ArrayList<>();
		output.add(new Monster(1L, "Kraken", "Cephalopod", "Piscivore", false, true, "Norse"));
		
		Mockito.when(repo.findAll()).thenReturn(output);
		
		assertEquals(output, service.getAll());
		
		Mockito.verify(repo, Mockito.times(1)).findAll();
	}
	
//	@Disabled
	@Test
	public void getByOriginTest() {
		List<Monster> output = new ArrayList<>();
		output.add(new Monster(1L, "Kraken", "Cephalopod", "Piscivore", false, true, "Norse"));
		
		Mockito.when(repo.findMonsterBySpeciesOrigin("Norse")).thenReturn(output);
		
		assertEquals(output, service.getByOrigin("Norse"));
		
		Mockito.verify(repo, Mockito.times(1)).findMonsterBySpeciesOrigin("Norse");
	}
	
//	@Disabled
	@Test
	public void getByFamilyTest() {
		List<Monster> output = new ArrayList<>();
		output.add(new Monster(1L, "Kraken", "Cephalopod", "Piscivore", false, true, "Norse"));
		
		Mockito.when(repo.findMonsterBySpeciesFamily("Cephalopod")).thenReturn(output);
		
		assertEquals(output, service.getByFamily("Cephalopod"));
		
		Mockito.verify(repo, Mockito.times(1)).findMonsterBySpeciesFamily("Cephalopod");
	}
	
//	@Disabled
	@Test
	public void getByOriginAndFamilyTest() {
		List<Monster> output = new ArrayList<>();
		output.add(new Monster(1L, "Kraken", "Cephalopod", "Piscivore", false, true, "Norse"));
		
		Mockito.when(repo.findMonsterByOriginAndFamily("Norse","Cephalopod")).thenReturn(output);
		
		assertEquals(output, service.getByOriginAndFamily("Norse","Cephalopod"));
		
		Mockito.verify(repo, Mockito.times(1)).findMonsterByOriginAndFamily("Norse","Cephalopod");
	}
	
//	@Disabled
	@Test
	public void getByDietAndFamilyTest() {
		List<Monster> output = new ArrayList<>();
		output.add(new Monster(1L, "Kraken", "Cephalopod", "Piscivore", false, true, "Norse"));
		
		Mockito.when(repo.findMonsterByDietAndFamily("Piscivore","Cephalopod")).thenReturn(output);
		
		assertEquals(output, service.getByDietAndFamily("Piscivore","Cephalopod"));
		
		Mockito.verify(repo, Mockito.times(1)).findMonsterByDietAndFamily("Piscivore","Cephalopod");
	}

//	UPDATE TEST
//	@Disabled
	@Test
	public void updateTest() {
		Monster input = new Monster("Harpy", "Avian", "Omnivore", true, false, "Greek");
		Optional<Monster> existing = Optional.of(new Monster(1L, "Kraken", "Cephalopod", "Piscivore", false, true, "Norse"));
		Monster output = new Monster(1L, "Harpy", "Avian", "Omnivore", true, false, "Greek");
		
		Mockito.when(repo.findById(1L)).thenReturn(existing);
		Mockito.when(repo.saveAndFlush(output)).thenReturn(output);
		
		assertEquals(output, service.update(1L, input));
		
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(output);
		Mockito.verify(repo, Mockito.times(1)).findById(1L);
		
	}

//	DELETE TEST
//	@Disabled
	@Test
	public void removeTest() {
		final long Id = 1L;
		Mockito.when(repo.existsById(Id)).thenReturn(false);
	
		assertEquals(true, service.remove(Id));
		
		Mockito.verify(repo, Mockito.times(1)).deleteById(Id);
		Mockito.verify(repo, Mockito.times(1)).existsById(Id);
	}

}
