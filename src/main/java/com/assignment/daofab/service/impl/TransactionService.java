package com.assignment.daofab.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.daofab.dao.ITransactionDao;
import com.assignment.daofab.model.ChildTransaction;
import com.assignment.daofab.model.ParentTransaction;
import com.assignment.daofab.response.ChildTransactionsResponse;
import com.assignment.daofab.response.ParentTransactionsResponse;
import com.assignment.daofab.service.ITransactionService;

/**
 * 
 * @author Sanket Lathiya
 *
 */
@Service
public class TransactionService implements ITransactionService {

	@Autowired
	private ITransactionDao transactionDao;

	@Override
	public List<ParentTransactionsResponse> getParentTransactions(int page, int size) {
		List<ParentTransactionsResponse> parentTransactionList = new ArrayList<>();

		for(ParentTransaction parentTransaction : transactionDao.getParentTransactions(page, size)) {
			parentTransactionList.add(
					//Builder Design Pattern
					new ParentTransactionsResponse()
					.setParentId(parentTransaction.getId())
					.setSender(parentTransaction.getSender())
					.setReceiver(parentTransaction.getReceiver())
					.setTotalAmount(parentTransaction.getTotalAmount())
					.setTotalPaidAmount(transactionDao.getTotalPaidAmountForParentTransaction(parentTransaction.getId()))
					);
		}

		return parentTransactionList;
	}

	@Override
	public List<ChildTransactionsResponse> getChildTransactions(ParentTransaction parentTransaction) {
		List<ChildTransactionsResponse> childTransactionList = new ArrayList<>();

		for(ChildTransaction childTransaction : transactionDao.getChildTransactions(parentTransaction.getId())) {
			childTransactionList.add(
					//Builder Design Pattern
					new ChildTransactionsResponse()
					.setChildId(childTransaction.getId())
					.setSender(parentTransaction.getSender())
					.setReceiver(parentTransaction.getReceiver())
					.setTotalAmount(parentTransaction.getTotalAmount())
					.setPaidAmount(childTransaction.getPaidAmount())
					);

		}

		return childTransactionList.stream().sorted(Comparator.comparing(ChildTransactionsResponse::getChildId)).collect(Collectors.toList());
	}

	@Override
	public Optional<ParentTransaction> getParentTransaction(long parentId) {
		return transactionDao.getParentTransaction(parentId);
	}

}
