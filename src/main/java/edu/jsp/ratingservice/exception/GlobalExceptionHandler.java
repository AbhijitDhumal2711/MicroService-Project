package edu.jsp.ratingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.jsp.ratingservice.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(CountryNotSavedException.class)
	public ResponseEntity<ResponseStructure<String>> handleCountryNotSavedException(
			CountryNotSavedException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());
		structure.setData(null);

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(CountryNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleCountryNotFoundException(CountryNotFoundException exception){
		
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		
		responseStructure.setCode(HttpStatus.NOT_FOUND.value());
		
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData(null);
		
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	
	
	
	@ExceptionHandler(CountryNotUpdateException.class)
	
	public ResponseEntity<ResponseStructure<String>> handleCountryNotUpdateException(CountryNotUpdateException exception){
		
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		
		responseStructure.setCode(HttpStatus.NOT_FOUND.value());
		
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData(null);
		
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(CountryListNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleCountryListNotFoundException(CountryListNotFoundException exception){
		
		
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		
		responseStructure.setCode(HttpStatus.NOT_FOUND.value());
		
		responseStructure.setMessage("NOT FOUND");
		
		responseStructure.setMessage(exception.getMessage());
		
		return new  ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TravellerWithCountryNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleTravellerWithCountryNotFoundException(TravellerWithCountryNotFoundException exception){
		
		
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		
		responseStructure.setCode(HttpStatus.NOT_FOUND.value());
		
		responseStructure.setMessage("NOT FOUND");
		
		responseStructure.setMessage(exception.getMessage());
		
		return new  ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	
	
}
