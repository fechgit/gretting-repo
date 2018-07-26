package hello.services;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.business.BusinessGreeting;
import hello.domain.GreetingRequest;
import hello.domain.GreetingResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;


@RestController
@Api(value = "Saludo", description = "Rest API for user operations", tags = "Saludo API")
public class GreetingController {
    
	//private String url = "http://192.168.40.159:8089/api/random";
	//private String url = "http://192.168.0.4:8089/api/random";
	//private String url = "http://192.168.42.29:8089/api/random";
	private String url = System.getenv("URL_BACKEND");
	
	@Autowired
    private BusinessGreeting business;
    
    
    @ApiOperation(value = "getGreeting", nickname = "getGreeting")
    @RequestMapping(value = "/greeting", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	
    	GreetingRequest request = new GreetingRequest();
    	request.setUser(name);
    	
    	GreetingResponse response = business.sendToRestClient(request, url);
    	return new ResponseEntity<GreetingResponse>(response, HttpStatus.OK);

    }
    
    @ApiOperation(value = "Envia un Saludo", notes = "Este metodo retorna HTTP CODE y un Mensaje segun sea el caso de exito u error.", response = GreetingResponse.class)
    @ApiResponse(code = 200, message = "Success", response = ResponseEntity.class)
    @RequestMapping(value = "/greeting", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> greeting(@ApiParam("Parametro de tipo GreetingRequest que corresponde al envio del saludo") @Valid @RequestBody GreetingRequest request) {

    	GreetingResponse response = business.sendToRestClient(request, url);    	
    	return new ResponseEntity<GreetingResponse>(response, HttpStatus.OK);

    }
}
