package com.capgemini.pecunia.service;



import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.dao.PassbookMaintenanceDAO;
import com.capgemini.pecunia.entities.Account;
import com.capgemini.pecunia.entities.Transactions;


@Service
@Transactional
public class PassbookMaintenanceServiceImpl implements PassbookMaintenanceService {
	
	Account account=new Account();
	long millis=System.currentTimeMillis();  
	Date date=new Date(millis); 
	
	@Autowired
	private PassbookMaintenanceDAO dao;

	public List<Transactions> updatePassbook(int accountId){
		List<Transactions> result=dao.updatePassbook(accountId);
		updatelastUpdated(accountId);
		return result;	
		
	}

	@Override
	public void updatelastUpdated(int accountId) {
		 dao.update(accountId,date);
	}
}
