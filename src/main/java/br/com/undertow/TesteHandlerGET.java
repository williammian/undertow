package br.com.undertow;

import java.util.Deque;
import java.util.Map;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class TesteHandlerGET implements HttpHandler{

	public void handleRequest(HttpServerExchange exchange) throws Exception {
		
		Map<String, Deque<String>> params = exchange.getQueryParameters();
		if(params != null && params.size() > 0) {
			for(String param : params.keySet()) {
				System.out.println(param);
				Deque<String> conteudo = params.get(param);
				System.out.println(conteudo.element());
			}
		}
		
		exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
		exchange.getResponseSender().send("Teste undertow GET");
	}
	
}
