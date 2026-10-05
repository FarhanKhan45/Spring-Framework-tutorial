package in.springboot.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler{
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<?> HandleStudentNotFound(StudentNotFoundException ex,HttpServletRequest req){
		

	    ErrorResponse errorResp = new ErrorResponse(
	            LocalDateTime.now(),
	            HttpStatus.NOT_FOUND.value(),
	            HttpStatus.NOT_FOUND.getReasonPhrase(),
	            ex.getMessage(),
	            req.getRequestURI()
	    );

		
		return ResponseEntity.status(404).body(errorResp);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handlevalidationException(MethodArgumentNotValidException ex){
		
		return ResponseEntity.status(400).body(ex.getBindingResult().getFieldError().getDefaultMessage());
	}
	
}
