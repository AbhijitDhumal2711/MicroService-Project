package edu.jsp.userservice.respossestructure;

public class ResponseStructure<T> {
   
	
	private int code;
	
	private String message;
	
	private T data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public ResponseStructure() {
		
		super();
		// TODO Auto-generated constructor stub
	}
}
