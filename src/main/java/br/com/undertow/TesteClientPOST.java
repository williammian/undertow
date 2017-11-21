package br.com.undertow;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TesteClientPOST {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://192.168.10.42:8080/teste");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			
			//request header
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "text/plain");
			
			String dados = new String("<ea01><ea01num>12345</ea01num></ea01>".getBytes(), "UTF-8");
			StringBuilder urlParams = new StringBuilder();
			urlParams.append("metodo=").append(URLEncoder.encode("enviarDadosVenda", "UTF-8"));
			urlParams.append("&").append("dados=").append(URLEncoder.encode(dados, "UTF-8"));
			
			String urlParameters = urlParams.toString();
			connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes("UTF-8").length));
			connection.setRequestProperty("Content-Language", "en-US");

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// Send request
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			
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
