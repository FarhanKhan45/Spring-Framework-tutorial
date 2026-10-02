package in.springboot.service;

import java.util.List;
import java.util.Optional;

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
	public Student save(Student student) {
		return repo.save(student);
	}
	
	//fetch all student
	public List<Student> fetchAll(){
		return repo.findAll();
	}
	
	//fetch StudentById
	public Student byId(Long id){
		return repo.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found with id: " +id));
	}
	
	//update
	public Optional<Student> updated(Long id,Student student){
		Optional<Student> find=repo.findById(id);
		
		if(find.isEmpty())
			return Optional.empty();
		
		Student existingStudent=find.get();
		
		existingStudent.setAge(student.getAge());
		existingStudent.setCourse(student.getCourse());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setName(student.getName());
		
		return Optional.of(repo.save(existingStudent));
	
	}
	
	//delete
	public Optional<Student> delete(Long id){
		Optional<Student> check= repo.findById(id);
		
		if(check.isEmpty())
			return Optional.empty();
		
		repo.deleteById(id);
		return check;
	}
}