package edu.jsp.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.jsp.userservice.dto.Traveller;
import edu.jsp.userservice.respossestructure.ResponseStructure;


@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(TravellerNotSavedException.class)
	public ResponseEntity<edu.jsp.userservice.respossestructure.ResponseStructure<String>> handleTravellerNotSavedException(
			TravellerNotSavedException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());
		structure.setData(null);

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(TravellerNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleTravellerNotFoundException(TravellerNotFoundException exception){
		
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		
		responseStructure.setCode(HttpStatus.NOT_FOUND.value());
		
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData(null);
		
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	
	
	
	@ExceptionHandler(TravellerNotUpdateException.class)
	public ResponseEntity<ResponseStructure<String>> handleTravellerNotUpdateException(TravellerNotUpdateException exception){
		
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		
		responseStructure.setCode(HttpStatus.NOT_FOUND.value());
		
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData(null);
		
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(TravellerListNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleTravellerListNotFoundException(TravellerListNotFoundException exception){
		
		
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		
		responseStructure.setCode(HttpStatus.NOT_FOUND.value());
		
		responseStructure.setMessage("NOT FOUND");
		
		responseStructure.setMessage(exception.getMessage());
		
		return new  ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
}
