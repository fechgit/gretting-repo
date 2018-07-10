package hello.clients;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("QuoteRequest")
@JsonTypeInfo(include= JsonTypeInfo.As.WRAPPER_OBJECT,use= JsonTypeInfo.Id.NAME)
public class QuoteRequest {

    private String usuario;

    public QuoteRequest() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


   /* @Override
    public String toString() {
        return "QuoteRequest{" +
                "type='" + usuario + '\'' +
                '}';
                
    }*/
}