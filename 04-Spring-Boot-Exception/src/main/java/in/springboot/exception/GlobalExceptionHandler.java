package in.springboot.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> HandleStudentNotFound(StudentNotFoundException ex){
		return ResponseEntity.status(404).body(ex.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex){
		
		return ResponseEntity.status(400).body(ex.getBindingResult().getFieldError().getDefaultMessage());
	}

}
