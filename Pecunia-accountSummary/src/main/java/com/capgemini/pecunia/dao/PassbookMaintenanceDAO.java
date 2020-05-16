package com.capgemini.pecunia.dao;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entities.Account;
import com.capgemini.pecunia.entities.Transactions;

@Repository 
public interface PassbookMaintenanceDAO extends JpaRepository<Account, String> {
	
	
	@Query("select t from Transactions t where account_Id=?1 and t.transDate>=?2 and t.transDate<=?3")
	List<Transactions> accountSummary(String accountId, Date startDate,Date endDate);

	

}