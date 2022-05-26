package com.qa.aprenable2.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qa.aprenable2.domain.Monster;
import com.qa.aprenable2.services.MonsterService;

@RestController
@RequestMapping("/monster")
public class MonsterController {

	private MonsterService service;

	public MonsterController(MonsterService service) {
		this.service = service;
	}

//	CREATE - Post Request - @PostMapping
	@PostMapping("/create")
	public ResponseEntity<Monster> create(@RequestBody Monster monster) {
		return new ResponseEntity<Monster>(service.create(monster), HttpStatus.CREATED);
	}

//	READ - Get Request - @GetMapping
	@GetMapping("/get/{id}")
	public ResponseEntity<Monster> getById(@PathVariable long id) {
		return new ResponseEntity<Monster>(service.getById(id), HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Monster>> getAll() {
		return new ResponseEntity<List<Monster>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getByOrigin/{speciesOrigin}")
	public ResponseEntity<List<Monster>> getByOrigin(@PathVariable String speciesOrigin) {
		return new ResponseEntity<List<Monster>>(service.getByOrigin(speciesOrigin), HttpStatus.OK);
	}
	
	@GetMapping("/getByFamily/{speciesFamily}")
	public ResponseEntity<List<Monster>> getByFamily(@PathVariable String speciesFamily) {
		return new ResponseEntity<List<Monster>>(service.getByFamily(speciesFamily), HttpStatus.OK);
	}
	
	@GetMapping("/getByOriginAndFamily/{speciesOrigin}/{speciesFamily}")
	public ResponseEntity<List<Monster>>getByOriginAndFamily(@PathVariable String speciesOrigin, @PathVariable String speciesFamily) {
		return new ResponseEntity<List<Monster>>(service.getByOriginAndFamily(speciesOrigin, speciesFamily), HttpStatus.OK);
	}
	
	@GetMapping("/getByDietAndFamily/{speciesDiet}/{speciesFamily}")
	public ResponseEntity<List<Monster>>getByDietAndFamily(@PathVariable String speciesDiet, @PathVariable String speciesFamily) {
		return new ResponseEntity<List<Monster>>(service.getByDietAndFamily(speciesDiet, speciesFamily), HttpStatus.OK);
	}

//	UPDATE - Put/Patch Request - @PutMapping
	@PutMapping("/update/{id}")
	public ResponseEntity<Monster> update(@PathVariable long id, @RequestBody Monster monster) {
		return new ResponseEntity<Monster>(service.update(id, monster), HttpStatus.ACCEPTED);
	}

//	DELETE - Delete Request - @DeleteMapping
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> remove(@PathVariable long id) {
		return service.remove(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
