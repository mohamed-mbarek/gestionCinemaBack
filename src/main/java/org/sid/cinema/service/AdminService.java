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
	
	public Admin addAdmin(Admin admin) {
		String aa=admin.getImage();
		String bb=admin.copy(aa);
		admin.setImage(bb);
		return adminRepository.save(admin);
	}
	
	public List<Admin> findAllAdmin(){
		return adminRepository.findAll();
	}
	
	public void deleteAdmin(Long id ) {
		adminRepository.deleteById(id);
	}
	
	public Admin updateAdmin(Admin Admin) {
		 int x=Admin.getImage().indexOf("\\");
		 if(x>0) {
				String aa=Admin.getImage();
				String bb=Admin.copy(aa);
				Admin.setImage(bb);
		 }
	
			return adminRepository.save(Admin);
		
	}
	
	public Admin findAdminById(Long id) {
		return  adminRepository.findAdminById(id) ;
	}
	
}
