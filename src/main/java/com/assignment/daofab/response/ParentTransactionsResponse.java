package com.assignment.daofab.response;

/**
 * Used a Builder Design Pattern to create a ParentTransactionsResponse.
 * 
 * @author Sanket Lathiya
 *
 */
public class ParentTransactionsResponse {
	long id;
	String sender;
	String receiver;
	long totalAmount;
	long totalPaidAmount;
	
	public ParentTransactionsResponse setParentId(long id) {
		this.id = id;
		return this;
	}
	
	public ParentTransactionsResponse setSender(String sender) {
		this.sender = sender;
		return this;
	}
	
	public ParentTransactionsResponse setReceiver(String receiver) {
		this.receiver = receiver;
		return this;
	}
	
	public ParentTransactionsResponse setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}

	public ParentTransactionsResponse setTotalPaidAmount(long totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
		return this;
	}
}
