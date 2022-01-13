package com.assignment.daofab.response;

/**
 * Used a Builder Design Pattern to create a ChildTransactionsResponse.
 * 
 * @author Sanket Lathiya
 *
 */
public class ChildTransactionsResponse {
	long id;
	String sender;
	String receiver;
	long totalAmount;
	long paidAmount;
	
	public long getChildId() {
		return id;
	}
	
	public ChildTransactionsResponse setChildId(long id) {
		this.id = id;
		return this;
	}
	
	public ChildTransactionsResponse setSender(String sender) {
		this.sender = sender;
		return this;
	}
	
	public ChildTransactionsResponse setReceiver(String receiver) {
		this.receiver = receiver;
		return this;
	}
	
	public ChildTransactionsResponse setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}
	
	public ChildTransactionsResponse setPaidAmount(long paidAmount) {
		this.paidAmount = paidAmount;
		return this;
	}
}
