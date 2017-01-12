package hello;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockQuoteController {
		
	@Value("classpath:${file.json.stock.quote.yql}")
	private Resource jsonStockQuoteYQL;
			
	@RequestMapping(value="/stockQuoteYQL", method=RequestMethod.GET, produces="application/json")	
	public String stockQuoteList() throws IOException {
		String jsonOutput = "";				
		try (Scanner scanner = new Scanner(jsonStockQuoteYQL.getInputStream(), StandardCharsets.UTF_8.name())) {
			jsonOutput += scanner.useDelimiter("\\A").next();
	    }
		return jsonOutput;							
	}
	
}