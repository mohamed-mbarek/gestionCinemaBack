package org.sid.cinema.controller;

import java.text.ParseException;
import java.util.List;

import org.sid.cinema.model.Categorie;
import org.sid.cinema.service.CategorieService;
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


@RestController
@RequestMapping("/categories")
public class CategorieController {

	

	private final CategorieService categorieService ;
	
	
	public CategorieController ( CategorieService categorieService) {
		this.categorieService=categorieService;
	}
	
	 @GetMapping("/all")
	    public ResponseEntity<List<Categorie>> getAllCategories () {
	        List<Categorie> Categories = categorieService.findAllCategorie();
	        return new ResponseEntity<>(Categories, HttpStatus.OK);
	    }
	 @GetMapping("/find/{id}")
	    public ResponseEntity<Categorie> getCategorieById (@PathVariable("id") Long id) {
	        Categorie Categorie = categorieService.findCategorieById(id);
	        return new ResponseEntity<>(Categorie, HttpStatus.OK);
	    }
	 
	 @PostMapping("/add")
	    public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie Categorie) {
	        Categorie newCategorie = categorieService.addCategorie(Categorie);
	        return new ResponseEntity<>(newCategorie, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("/update")
	    public ResponseEntity<Categorie> updateCategorie(@RequestBody Categorie Categorie) throws ParseException {
	    	Categorie updateCategorie = categorieService.updateCategorie(Categorie);
	        return new ResponseEntity<>(updateCategorie, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
	        categorieService.deleteCategorie(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	 
	 
}
