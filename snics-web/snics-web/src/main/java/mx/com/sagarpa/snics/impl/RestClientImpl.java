package mx.com.sagarpa.snics.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;




import mx.com.sagarpa.snics.RestClient;
import mx.com.sagarpa.snics.SeguridadFiltro;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("RestClientImpl")
public class RestClientImpl implements RestClient {
	
	Logger LOG = LoggerFactory.getLogger(SeguridadFiltro.class);
	
	private final String secretKey = "_EUQ?x2ZUwc-?-rQVYqE5vnz!ZJWb-*T"; //TODO pasarla a configuracion
	private final String publicKey = "SNICS_WEB_KEY"; //TODO pasarla a configuracion
	
	
	public String  POST(String contenido,String ruta,String Snowflake){
		JSONParser parser = new JSONParser();
		
		StringBuffer respuesta = new StringBuffer();
		try {
			URL url = new URL(ruta);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			String md5 = this.GetMD5RequestBody(contenido);
			
			String nakedSign = "SIGNED_REQUEST" + "||"
					+ md5 + "||" 
					+ "SIGNED_REQUEST";
			
			
			String sign = this.hmacSha256Sign(nakedSign);
			
			String header = this.publicKey + "||" + sign;
			
			String headerB64 = Base64.encodeBase64String(header.getBytes());
			
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");

			conn.setRequestProperty("Content-MD5",md5);
			conn.setRequestProperty("Authorization", headerB64);
			LOG.info("Authorization: " + headerB64);

			LOG.info("Content-MD5: " + md5);
			String input = contenido;
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
	  
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream()),Charset.forName("UTF-8")));
	 
			String output;
			while ((output = br.readLine()) != null) {
				respuesta.append(output);
			}
			conn.disconnect();
		  } catch (MalformedURLException e) {
			LOG.error(e.getMessage());
		  } catch (IOException e) {
			LOG.error(e.getMessage());
		 }
		return respuesta.toString();
	}
	
	private String GetMD5RequestBody(String requestBody){
		String md5 = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(requestBody.getBytes());
			byte [] digest = md.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			md5 = bigInt.toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return md5;
	}
	
	private String hmacSha256Sign (String nakedSign){
		String sign = "";
		try {
			Mac hmac_sha256 = Mac.getInstance("HmacSHA256");
			SecretKeySpec key = new SecretKeySpec(this.secretKey.getBytes(),"HmacSHA256");
			hmac_sha256.init(key);
			sign = Base64.encodeBase64String(hmac_sha256.doFinal(nakedSign.getBytes()));
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sign;
	}
	
}
