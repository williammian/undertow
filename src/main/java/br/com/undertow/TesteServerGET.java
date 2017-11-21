package br.com.undertow;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.RoutingHandler;

public class TesteServerGET {

	public static void main(String[] args) {
		RoutingHandler routing = Handlers.routing().add("GET", "/teste", new TesteHandlerGET());
		
		Undertow server = Undertow.builder().addHttpListener(8080, "192.168.10.42").setHandler(routing).build();
		server.start();
	}
	
}
