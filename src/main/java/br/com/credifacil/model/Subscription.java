package br.com.credifacil.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Document(collection = "subscriptions")
public class Subscription implements Serializable{
	
	private static final long serialVersionUID = -7847638691959567683L;

	@Id
	private String id;
	
	@NotBlank(message = "Nome precisa ser preenchido")
	private String name;
	
	@NotNull(message = "Idade precisa ser preenchido")
	@Min(18) @Max(100)
	private Integer age;
	
	@NotNull(message = "Sexo precisa ser preenchido")
	private Gender gender;
	
	@NotBlank(message = "Estado civil precisa ser preenchido")
	@Field("civil_status")
	private String civilStatus;
	
	@NotBlank(message = "Estado precisa ser preenchido")
	private String state;
	
	@Field
	private Integer dependents = 0;
	
	@NotBlank(message = "CPF precisa ser preenchido")
	@CPF
	@Indexed(unique = true)
	private String document;
	
	@NotNull(message = "Renda precisa ser preenchido")
	@NumberFormat(style = Style.NUMBER)
	@Min(1) @Max(999999)
	private Double income;
	
	public enum Gender {
		F,M
	}

	public Subscription() {}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the civilStatus
	 */
	public String getCivilStatus() {
		return civilStatus;
	}

	/**
	 * @param civilStatus the civilStatus to set
	 */
	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the dependents
	 */
	public Integer getDependents() {
		return dependents;
	}

	/**
	 * @param dependents the dependents to set
	 */
	public void setDependents(Integer dependents) {
		this.dependents = dependents;
	}

	/**
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	/**
	 * @return the income
	 */
	public Double getIncome() {
		return income;
	}

	/**
	 * @param income the income to set
	 */
	public void setIncome(Double income) {
		this.income = income;
	}

	
}
