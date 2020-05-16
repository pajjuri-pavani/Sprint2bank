package com.capgemini.pecunia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.entities.Transactions;
import com.capgemini.pecunia.service.PassbookMaintenanceService;

@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = "http://localhost:4200")
public class PassbookController {

	@Autowired
	private PassbookMaintenanceService service;

	//Fetching the transactions till last updated date
	@GetMapping("/updatePassbook/{accountId}")
	public  ResponseEntity<List<Transactions>> updatePassbook(@PathVariable("accountId") int accountId)
	{
			List<Transactions> list = service.updatePassbook(accountId);
			return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
		}
		
}



