package br.com.undertow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TesteClientHEADER {

	public static void main(String[] args) {
		try {
						
			URL url = new URL("http://192.168.10.42:8080/testeHeader");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			
			//request header
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "text/plain");
			
			String dados = new String("<ea01><ea01num>12345</ea01num></ea01>".getBytes(), "UTF-8");
			connection.setRequestProperty("dados", dados);
			
	        int responseCode = connection.getResponseCode();
	        System.out.println("\nSending 'Get' request to URL : " + url);
	        System.out.println("Response Code : " + responseCode);

	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();

	        //print result
	        System.out.println("Retorno: " + response.toString());

		}catch(Exception err) {
			err.printStackTrace();
		}
		
	}
	
}
