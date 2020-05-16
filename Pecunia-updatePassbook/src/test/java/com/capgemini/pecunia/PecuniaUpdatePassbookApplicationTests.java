package com.capgemini.pecunia;
import java.net.URI;
import java.net.URISyntaxException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.capgemini.pecunia.dao.PassbookMaintenanceDAO;
import com.capgemini.pecunia.entities.Transactions;
import junit.framework.Assert;


@SuppressWarnings("deprecation")
@SpringBootTest
public class PecuniaUpdatePassbookApplicationTests {
	
	@SuppressWarnings("unused")
	@Autowired
	private PassbookMaintenanceDAO dao;
	
	
	@Test
	public void updatePassbookTestSuccess() throws URISyntaxException {

	RestTemplate restTemplate = new RestTemplate();
    
    final String baseUrl = "http://localhost:" + 9999 + "/bank/updatePassbook/123456789012" ;
    URI uri = new URI(baseUrl);
 
    ResponseEntity<Transactions[]> result = restTemplate.getForEntity(uri, Transactions[].class);
    Transactions[] trans = result.getBody();
    System.out.println(trans.length);
    Assert.assertEquals(200, result.getStatusCodeValue());
    Assert.assertEquals(0, trans.length);
}

	@Test
	public void updatePassbookTestUnSuccessful() throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
	    
	    final String baseUrl = "http://localhost:" + 9999 + "/bank/updatePassbook/123456789012" ;
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<Transactions[]> result = restTemplate.getForEntity(uri, Transactions[].class);
	    Transactions[] trans = result.getBody();
	    Assert.assertEquals(400, result.getStatusCodeValue());
	    Assert.assertEquals(10, trans.length);
	}

	
}

