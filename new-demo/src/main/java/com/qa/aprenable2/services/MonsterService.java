package com.qa.aprenable2.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.qa.aprenable2.domain.Monster;
import com.qa.aprenable2.interfaces.MonsterRepo;

@Service
public class MonsterService {
	
	private MonsterRepo repo;
	
	public MonsterService(MonsterRepo repo) {
		this.repo = repo;
	}

//	CREATE
	public Monster create(Monster monster) {
		return repo.saveAndFlush(monster);
	}

//	READ
	public Monster getById(long id) {
		return repo.findById(id).get();
	}

	public List<Monster> getAll() {
		return repo.findAll();
	}
	
	public List<Monster> getByOrigin(String speciesOrigin) {
		return repo.findMonsterBySpeciesOrigin(speciesOrigin);
	}
	
	public List<Monster> getByFamily(String speciesFamily) {
		return repo.findMonsterBySpeciesFamily(speciesFamily);
	}

//	UPDATE
	public Monster update(long id, Monster newMonster) {
		Monster existing = repo.findById(id).get();
		
		existing.setSpeciesName(newMonster.getSpeciesName());
		existing.setSpeciesFamily(newMonster.getSpeciesFamily());
		existing.setSpeciesDiet(newMonster.getSpeciesDiet());
		existing.setSpeciesFlight(newMonster.isSpeciesFlight());
		existing.setSpeciesSwim(newMonster.isSpeciesSwim());
		existing.setSpeciesOrigin(newMonster.getSpeciesOrigin());
		
		return repo.saveAndFlush(existing);
	}

//	DELETE
	public boolean remove(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
}
