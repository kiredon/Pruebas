package mx.com.sagarpa.snics.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat
import java.text.SimpleDateFormat
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("RestClient")
public class RestClient {
	public String  peticion(){
		
		
		String respuesta="";
		try {
			String contenido=""
			String ruta="http://localhost:8000/api/"//ruta del servidor node js
			DateFormat df = new SimpleDateFormat("MM&dd&yyyy&HH&mm&ss");
			Date hoy=new java.util.Date()
			println "string hoy:"+hoy.toString()
			ruta=ruta+df.format(hoy)//se agrega la fecha a la ruta
			//URL url = new URL("http://localhost:8081/mus-services/Usuario/validarPermiso.do");
			URL url = new URL(ruta);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("token", "password123456")
			//{"token":"3","ruta":"lalala"}
			//String input = "{\"qty\":100,\"name\":\"iPad 4\"}";
			//String input = "{\"token\":4,\"ruta\":\"lalala\"}";
			String input = contenido;
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
	 
//			if (conn.getResponseCode() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : "
//					+ conn.getResponseCode());
//				
//			}
	 
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
	 
			String output;
			//System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				//System.out.println(output);
				respuesta=respuesta+output;
			}
			
			conn.disconnect();
			
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		 }
		//System.out.print("error al mandar o recibir datos del cliente");
		return respuesta;
		
	}

}
