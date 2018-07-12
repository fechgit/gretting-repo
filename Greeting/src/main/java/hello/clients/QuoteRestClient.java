package hello.clients;


import hello.domain.GreetingRequest;
import hello.domain.GreetingResponse;

public interface QuoteRestClient {
	public GreetingResponse sendToPost(GreetingRequest req, String url);
}
