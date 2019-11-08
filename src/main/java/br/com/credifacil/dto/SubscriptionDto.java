package br.com.credifacil.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.credifacil.model.Subscription.Gender;


@SuppressWarnings("rawtypes")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionDto implements Comparable{
	

	private String id;
	private String name;
	private Integer age;
	private Gender gender;
	private String civilStatus;
	private String state;
	private Integer dependents;
	private Double income;
	
	public SubscriptionDto() {}

	public SubscriptionDto(String id, String name, Integer age, Gender gender, String civilStatus, String state,
			Integer dependents, Double income) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.civilStatus = civilStatus;
		this.state = state;
		this.dependents = dependents;
		this.income = income;
	}


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

	@Override
	public String toString() {
		return "SubscriptionDto [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", civilStatus="
				+ civilStatus + ", state=" + state + ", dependents=" + dependents + ", income=" + income + "]";
	}
	
	@Override
	public int compareTo(Object o) {
		return this.getName().compareTo(((SubscriptionDto) o).getName());
	}
	

}
