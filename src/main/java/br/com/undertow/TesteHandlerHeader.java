package br.com.undertow;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HeaderMap;
import io.undertow.util.HeaderValues;
import io.undertow.util.Headers;
import io.undertow.util.HttpString;

public class TesteHandlerHeader implements HttpHandler{
	
	private static Logger log = Logger.getLogger(TesteHandlerHeader.class);

	public void handleRequest(HttpServerExchange exchange) throws Exception {
		
		log.info("**************");
		log.info("Header / Recebendo request em " + new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date()));
		log.info("**************");
		
		HeaderMap headerMap = exchange.getRequestHeaders();
		Collection<HttpString> headerNames = headerMap.getHeaderNames();
		Iterator<HttpString> it = headerNames.iterator();
		while(it.hasNext()) {
			HttpString headerName = it.next();
			HeaderValues headerValues = headerMap.get(headerName);
			System.out.println(headerName.toString());
			System.out.println(headerValues.getFirst());
		}
		
		
		exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
		exchange.getResponseSender().send("Teste undertow Header");
		
		log.info("**************");
		log.info("Finalizando execução da request em " + new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date()));
		log.info("**************");
		
	}

}
