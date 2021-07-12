package org.sid.cinema.controller;

import java.text.ParseException;
import java.util.List;

import org.sid.cinema.model.Admin;import org.sid.cinema.repository.AdminRepository;
import org.sid.cinema.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AdminService adminService;

	 public LoginController (AdminService repository) {
		 this.adminService=repository;
	 }
	 

	 @GetMapping("/all")
	    public ResponseEntity<List<Admin>> getAlladmins () {
	        List<Admin> admins = adminService.findAllAdmin();
	        return new ResponseEntity<>(admins, HttpStatus.OK);
	    }
	 @GetMapping("/find/{id}")
	    public ResponseEntity<Admin> getadminById (@PathVariable("id") Long id) {
	        Admin admin = adminService.findAdminById(id);
	        return new ResponseEntity<>(admin, HttpStatus.OK);
	    }
	 
	 @PostMapping("/add")
	    public ResponseEntity<Admin> addadmin(@RequestBody Admin admin) {
	        Admin newadmin = adminService.addAdmin(admin);
	        return new ResponseEntity<>(newadmin, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("/update")
	    public ResponseEntity<Admin> updateadmin(@RequestBody Admin admin) throws ParseException {
	    	Admin updateadmin = adminService.updateAdmin(admin);
	        return new ResponseEntity<>(updateadmin, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
	        adminService.deleteAdmin(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	 
	
}
