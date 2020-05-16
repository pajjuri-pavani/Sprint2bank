package com.capgemini.pecunia.dao;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entities.Transactions;

@Repository 
public interface PassbookMaintenanceDAO extends JpaRepository<Transactions, String> {

	
	@Query("select t from Transactions t where account_Id=?1 and t.transDate>(select u.lastUpdated from Account u where account_Id=?1) ")
	List<Transactions> updatePassbook(int accountId);

	@Modifying
	@Query("update Account set lastUpdated=?2 where  account_Id=?1")
	void update(int accountId, Date date);
}