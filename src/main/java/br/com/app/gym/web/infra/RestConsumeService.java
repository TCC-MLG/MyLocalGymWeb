package br.com.app.gym.web.infra;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class RestConsumeService {
	
    HttpClient client = new HttpClient(); 
    
    
	public Object restGet(String classe, String metodo, String atributo){
        try {  

 
            client.getHttpConnectionManager().getParams().setConnectionTimeout(30000);  
           /* Executando chamada com método HTTP GET */  
        String getURI = "http://localhost:8080/mylocalgymweb/"+classe+"/"+metodo+"/"+atributo+"";  
        GetMethod get = new GetMethod(getURI);   
        int statusCodeGET = client.executeMethod(get);  
        String responseBody = get.getResponseBodyAsString();  
        System.out.println("Chamada GET");  
        System.out.println(" Status Code: "+statusCodeGET+" \nResponse Body:\n"+responseBody);  
        
        Object obj = new ObjectMapper().readValue(responseBody, Object.class);
        
        return obj;
        
        } catch (Exception ex) 
        {/* OMITIDO */
        	 return null;	
        }     
	}
	
	public static Object restPost(String classe, String metodo, Object object){
		try {
			ResteasyClient client = new ResteasyClientBuilder().build();

			ResteasyWebTarget target = client
					.target("http://localhost:8080/mylocalgym/"+classe+"/"+metodo+"");

			Response response = target.request().post(
					Entity.entity(object, MediaType.APPLICATION_JSON));

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Server response : \n");
			System.out.println(response.readEntity(Object.class));
		
			 Object object2 = response.getEntity();
			 
			response.close();
			
			return object2;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
