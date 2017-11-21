package br.com.undertow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TesteClientGET {

	public static void main(String[] args) {
		try {
			String urlParameters = "param1=XPTO&param2=12345";
			
			URL url = new URL("http://192.168.10.42:8080/teste" + "?" + urlParameters);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			
			//request header
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "text/plain");
			
	        int responseCode = connection.getResponseCode();
	        System.out.println("\nSending 'Get' request to URL : " + url);
	        System.out.println("Get parameters : " + urlParameters);
	        System.out.println("Response Code : " + responseCode);

	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();

	        //print result
	        System.out.println(response.toString());

		}catch(Exception err) {
			err.printStackTrace();
		}
		
	}
	
}
