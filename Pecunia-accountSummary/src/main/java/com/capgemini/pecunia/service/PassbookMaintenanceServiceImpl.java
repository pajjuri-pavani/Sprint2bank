package com.capgemini.pecunia.service;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.dao.PassbookMaintenanceDAO;
import com.capgemini.pecunia.entities.Transactions;


@Service
public class PassbookMaintenanceServiceImpl implements PassbookMaintenanceService {

	@Autowired
	private PassbookMaintenanceDAO dao;

	@Override
	public List<Transactions> accountSummary(String accountId, Date startDate, Date endDate) {
		return dao.accountSummary(accountId, startDate, endDate);
	}


	
}

	
	
