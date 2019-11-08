package br.com.credifacil.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "result")
public class Result implements Serializable{

	private static final long serialVersionUID = 1417482193738713380L;

	@Id
	private String id;
	
	private Boolean approved;
	
	private String limit;
	
	private String resultMessage;
	
	@DBRef
	@Indexed(unique = true)
	private Subscription subscription;

	
	public Result() {}
	
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
	 * @return the approved
	 */
	public Boolean getApproved() {
		return approved;
	}

	/**
	 * @param approved the approved to set
	 */
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	/**
	 * @return the limit
	 */
	public String getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(String limit) {
		this.limit = limit;
	}

	/**
	 * @return the subscriptionDto
	 */
	public Subscription getSubscription() {
		return subscription;
	}

	/**
	 * @param subscriptionDto the subscriptionDto to set
	 */
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
		
	
	/**
	 * @return the resultMessage
	 */
	public String getResultMessage() {
		return resultMessage;
	}

	/**
	 * @param resultMessage the resultMessage to set
	 */
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", approved=" + approved + ", limit=" + limit + ", subscription=" + subscription
				+ "]";
	}

	
}
