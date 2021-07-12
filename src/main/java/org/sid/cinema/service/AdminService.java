package org.sid.cinema.service;

import java.util.List;

import org.sid.cinema.model.Admin;
import org.sid.cinema.repository.AdminRepository;
import org.sid.cinema.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	private final AdminRepository adminRepository;

	@Autowired
	public AdminService (AdminRepository repository) {
		adminRepository=repository;
	}
	
	public Admin addAdmin(Admin Admin) {
		return adminRepository.save(Admin);
	}
	
	public List<Admin> findAllAdmin(){
		return adminRepository.findAll();
	}
	
	public void deleteAdmin(Long id ) {
		adminRepository.deleteById(id);
	}
	
	public Admin updateAdmin(Admin Admin) {
		return adminRepository.save(Admin);
	}
	
	public Admin findAdminById(Long id) {
		return  adminRepository.findAdminById(id) ;
	}
	
}
