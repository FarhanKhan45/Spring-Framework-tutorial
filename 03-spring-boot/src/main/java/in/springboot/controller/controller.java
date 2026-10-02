package in.springboot.controller;

import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping("/student")
public class controller{
	
@Autowired
private StudentService service;
	
//save
@PostMapping
public ResponseEntity<Student> save(@RequestBody Student student){
	
	return ResponseEntity.status(201).body(service.save(student));
}

//fetchall
@GetMapping
public List<Student> fetchAll(){
	
	return service.fetchAll();
}

//fetchByid
@GetMapping("/{id}")
public ResponseEntity<Student> fetchById(@PathVariable Long id){
	
	Optional<Student> find=service.byId(id);
	
	if(find.isEmpty())
		return ResponseEntity.status(404).build();
	
	return ResponseEntity.ok(find.get());

}
// update
@PutMapping("/{id}")
public ResponseEntity<Student> update(@PathVariable Long id,@RequestBody Student student){
	Optional<Student> check=service.updated(id, student);
	
	 if(check.isEmpty())
		 return ResponseEntity.notFound().build();
	 
	 return ResponseEntity.ok(check.get());
}

//delete
@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id){
	
	Optional<Student> deleted=service.delete(id);
	
	if(deleted.isEmpty())
		return ResponseEntity.notFound().build();
	
	return ResponseEntity.noContent().build();
	
}

	
}