package hello.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonTypeName("GreetingResponse")
@JsonTypeInfo(include= JsonTypeInfo.As.WRAPPER_OBJECT,use= JsonTypeInfo.Id.NAME)
@ApiModel(description="Clase que representa la respuesta de la API")
public class GreetingResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7083908649768943941L;

	@JsonGetter(value="identificador")
	public long getId() {
		return id;
	}
	public String getContent() {
		return content;
	}

	public GreetingResponse(long id, String content) {
		this.id = id;
		this.content = content;
	}
	
	@ApiModelProperty(notes="Corresponde al identificador de la respuesta.", example="1", required=true, position=0)
	private final long id;
	
	@JsonProperty("content")
	@ApiModelProperty(notes="Corresponde al contenido de la respuesta al saludo enviado.", example="Hola Felipe, El estado de la llamada fue: success", required=true, position=1)
	private final String content;

}
