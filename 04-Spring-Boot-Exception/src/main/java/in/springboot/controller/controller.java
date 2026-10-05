package in.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.springboot.entity.Student;
import in.springboot.service.StudentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class Controller{
	
	@Autowired
	private StudentService service;
	
	//save
	@PostMapping
	public ResponseEntity<Student> save(@Valid @RequestBody Student student ){
		
		return ResponseEntity.status(201).body(service.saved(student));
		
	}
	
	//fetchall
	@GetMapping
	public List<Student> fetchAll(){
		
		return service.fetchAll();
	}
	
	//byid
	@GetMapping("/{id}")
	public ResponseEntity<Student> byId(@PathVariable Long id){
		
		return ResponseEntity.ok(service.byId(id));
		
		
	}
	
	//update
	@PutMapping("/{id}")
     public ResponseEntity<Student> update(@PathVariable Long id,@RequestBody Student student){
		
		return ResponseEntity.ok(service.update(id, student));
		
		
	}
     //deletebyid
	@DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteById(@PathVariable Long id){
    	 
    	 service.deleteById(id);
 		
 		return ResponseEntity.noContent().build();
 		
 		
 	}
     @DeleteMapping
     public ResponseEntity<Void> DeleteAll(){
 		
 		return ResponseEntity.status(204).build();
 		
 		
 	}
	
}
