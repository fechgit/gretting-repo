package hello.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.clients.QuoteRestClient;
import hello.clients.QuoteRestClientImpl;
import hello.domain.GreetingRequest;
import hello.domain.GreetingResponse;

@Component
public class BusinessGreetingImpl implements BusinessGreeting{
	
	@Autowired
	private QuoteRestClient restClient;

	@Override
	public GreetingResponse sendToRestClient(GreetingRequest request, String url) {
		GreetingResponse response = null;
		restClient = new QuoteRestClientImpl();
		response = restClient.sendToPost(request, url);
		
		return response;
	}
	
	

}
