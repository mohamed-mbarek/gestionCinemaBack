package org.sid.cinema.service;

import java.util.List;

import org.sid.cinema.model.Categorie;
import org.sid.cinema.model.Categorie;
import org.sid.cinema.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategorieService {

	public final CategoryRepository CategorieRepository  ;
	
	@Autowired
	public CategorieService ( CategoryRepository  CategorieRepository) {
		this.CategorieRepository=CategorieRepository;
	}

	public Categorie addCategorie(Categorie Categorie) {
		return CategorieRepository.save(Categorie);
	}
	
	public List<Categorie> findAllCategorie(){
		return CategorieRepository.findAll();
	}
	
	public void deleteCategorie(Long id ) {
		CategorieRepository.deleteById(id);
	}
	
	public Categorie updateCategorie(Categorie Categorie) {
		return CategorieRepository.save(Categorie);
	}
	
	public Categorie findCategorieById(Long id) {
		return  CategorieRepository.findCategorieById(id);
	}
	
	
}
