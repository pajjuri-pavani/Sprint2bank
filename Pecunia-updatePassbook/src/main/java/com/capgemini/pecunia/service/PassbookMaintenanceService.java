package com.capgemini.pecunia.service;

import java.util.List;

import com.capgemini.pecunia.entities.Transactions;

public interface PassbookMaintenanceService {

	List<Transactions> updatePassbook(int accountId);
	
	void  updatelastUpdated(int accountId);

	
}
