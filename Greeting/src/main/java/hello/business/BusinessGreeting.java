package hello.business;


import hello.domain.GreetingRequest;
import hello.domain.GreetingResponse;

public interface BusinessGreeting {
	public GreetingResponse sendToRestClient(GreetingRequest request, String url);

}
