package br.com.credifacil.model;

import java.util.List;

public class Response<T> {
	
	private T data;
	
	private List<String> errors;
	
	public Response() {}

	public Response(T data, List<String> errors) {
		super();
		this.data = data;
		this.errors = errors;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the error
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * @param error the error to set
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	

}
