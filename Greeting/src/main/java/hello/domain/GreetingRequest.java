package hello.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonTypeName("GreetingRequest")
@JsonTypeInfo(include= JsonTypeInfo.As.WRAPPER_OBJECT,use= JsonTypeInfo.Id.NAME)
@ApiModel(description="Clase que representa el objeto Greeting")
@JsonPropertyOrder({ "user", "age" })
public class GreetingRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7083908649768943941L;

	@JsonProperty("user")
	@NotNull
	@Size(min=2, message="El nombre del usuario debe tener a lo menos 2 caracteres")
	@ApiModelProperty(notes="Corresponde al nombre del la persona que envia un saludo.", example="Felipe", required=true, position=0)
	private String user;
	@ApiModelProperty(notes="Corresponde a la edad de la persona que envia el saludo.", example="37", required=false, position=1)
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
