package com.capgemini.pecunia;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.entities.Transactions;

import junit.framework.Assert;



@SuppressWarnings("deprecation")
@SpringBootTest
public class PecuniaAccountSummaryApplicationTests {


	@Test
	public void accountSummaryTestUnsuccesful() throws URISyntaxException {

	RestTemplate restTemplate = new RestTemplate();
    
    final String baseUrl = "http://localhost:" + 8888 + "/bank/accountSummary/123456789012/2020-04-19/2020-04-23" ;
    URI uri = new URI(baseUrl);
 
    ResponseEntity<Transactions[]> result = restTemplate.getForEntity(uri, Transactions[].class);
    Transactions[] trans = result.getBody();
    Assert.assertEquals(400, result.getStatusCodeValue());
    Assert.assertEquals(4, trans.length);
}

}
	