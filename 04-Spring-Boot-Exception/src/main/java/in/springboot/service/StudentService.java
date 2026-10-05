package in.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import in.springboot.entity.Student;
import in.springboot.exception.StudentNotFoundException;
import in.springboot.repository.StudentRepository;

@Service
public class StudentService{
	
	@Autowired
	private StudentRepository repo;
	
	//save
	public Student saved(Student student) {
		
		return repo.save(student);
	}
	
	//fetchAll
	public List<Student> fetchAll(){
		return repo.findAll();
	}
	
	//byId
	public Student byId(Long id) {
		
		return repo.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not Found with id: " +id));
	}
	
	//update
	public Student update(Long id,Student student) {
		
		Student existingStudent=repo.findById(id).orElseThrow(()->new StudentNotFoundException("Student not Found with id: " +id));
		  
		existingStudent.setAge(student.getAge());
		existingStudent.setCourse(student.getCourse());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setName(student.getName());
		
		return repo.save(existingStudent);}
	
	//deleteById
	public void deleteById(Long id) {
		
		repo.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not Found with id: " +id));
		
		repo.deleteById(id);
	
	}
	
	public void deleteAll() {
		repo.deleteAll();
		
	}
	
}