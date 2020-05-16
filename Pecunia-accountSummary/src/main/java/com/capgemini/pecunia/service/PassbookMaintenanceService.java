package com.capgemini.pecunia.service;
import java.sql.Date;
import java.util.List;

import com.capgemini.pecunia.entities.Transactions;

public interface PassbookMaintenanceService {

	List<Transactions> accountSummary(String accountId, Date startDate, Date endDate);


}
