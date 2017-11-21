package br.com.undertow;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import io.undertow.io.Receiver;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class TesteHandlerPOST implements HttpHandler{
	
	private static Logger log = Logger.getLogger(TesteHandlerPOST.class);

	public void handleRequest(HttpServerExchange exchange) throws Exception {
		
		exchange.getRequestReceiver().receiveFullBytes(new Receiver.FullBytesCallback() {  
			public void handle(HttpServerExchange exchange, byte[] message) {
				try {
					
					log.info("**************");
					log.info("Recebendo request em " + new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date()));
					log.info("**************");
					
					String parameters = new String(message,"UTF-8");
					
					System.out.println("Parameters: " + parameters);
					
					String dados = URLDecoder.decode(parameters, "UTF-8");
					
					System.out.println("Dados: " + dados);
					
					exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
					exchange.getResponseSender().send("Teste undertow POST");
					
					log.info("**************");
					log.info("Finalizando execução da request em " + new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date()));
					log.info("**************");
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}  
		});
		
	}

}
