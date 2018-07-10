package hello.services;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import hello.clients.QuoteRequest;
import hello.clients.QuoteResponse;
import hello.domain.GreetingRequest;
import hello.domain.GreetingResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Api(value = "Saludo", description = "Rest API for user operations", tags = "Saludo API")
public class GreetingController {
    private String url = "http://localhost:8089/api/random";
    
    
    @ApiOperation(value = "getGreeting", nickname = "getGreeting")
    @RequestMapping(value = "/greeting", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	
    	QuoteRequest requestJson = new QuoteRequest();
    	requestJson.setUsuario(name);
    	
    	RestTemplate restTemplate = new RestTemplate();
    	QuoteResponse quote = restTemplate.postForObject(url, requestJson, QuoteResponse.class);

    	//Para llamar por GET.
    	//QuoteResponse quote = restTemplate.getForObject("http://localhost:8089/api/random", QuoteResponse.class);
    	
    	GreetingResponse response = new GreetingResponse(
    				quote.getValue().getId().intValue(),
    				"Hola "+name+", El estado de la llamada fue: "+quote.getType()+", y la glosa es: "+quote.getValue().getQuote()+"."
    			);
    	
    	return new ResponseEntity<GreetingResponse>(response, HttpStatus.OK);

    }
    
    @ApiOperation(value = "Envia un Saludo", notes = "Este metodo retorna HTTP CODE y un Mensaje segun sea el caso de exito u error.", response = GreetingResponse.class)
    @ApiResponse(code = 200, message = "Success", response = ResponseEntity.class)
    @RequestMapping(value = "/greeting", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> greeting(@ApiParam("Parametro de tipo GreetingRequest que corresponde al envio del saludo") @Valid @RequestBody GreetingRequest request) {
    	
    	QuoteRequest requestJson = new QuoteRequest();
    	requestJson.setUsuario(request.getUser());
    	
    	RestTemplate restTemplate = new RestTemplate();
    	QuoteResponse quote = restTemplate.postForObject(url, requestJson, QuoteResponse.class);
    	
    	GreetingResponse response = new GreetingResponse(
    				quote.getValue().getId().intValue(),
    				"Hola "+request.getUser()+", El estado de la llamada fue: "+quote.getType()+", y la glosa es: "+quote.getValue().getQuote()+"."
    			);
    	
    	return new ResponseEntity<GreetingResponse>(response, HttpStatus.OK);

    }
}
