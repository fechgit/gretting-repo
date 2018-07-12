package hello.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import hello.domain.GreetingRequest;
import hello.domain.GreetingResponse;

@Component
public class QuoteRestClientImpl implements QuoteRestClient{
	
	public GreetingResponse sendToPost(GreetingRequest request, String url){
		
		GreetingResponse response = null;
		
    	QuoteRequest requestJson = new QuoteRequest();
    	requestJson.setUsuario(request.getUser());
    	
    	RestTemplate restTemplate = new RestTemplate();
    	QuoteResponse quote = restTemplate.postForObject(url, requestJson, QuoteResponse.class);
    	
    	response = new GreetingResponse(
    				quote.getValue().getId().intValue(),
    				"Hola "+request.getUser()+", El estado de la llamada fue: "+quote.getType()+", y la glosa es: "+quote.getValue().getQuote()+"."
    			);
		
		
		return response;
		
	}
	

}
