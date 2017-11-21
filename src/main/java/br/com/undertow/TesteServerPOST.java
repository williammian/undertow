package br.com.undertow;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.RoutingHandler;

public class TesteServerPOST {
	
	private static Logger log = Logger.getLogger(TesteServerPOST.class);

	public static void main(String[] args) {
		try {
			
			log.info("**************");
			log.info("Obtendo configurações de servidor e porta em " + new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date()));
			log.info("**************");
			
			Properties defaultProps = new Properties();
			FileInputStream in = new FileInputStream("server.properties");
			defaultProps.load(in);
			in.close();

			String servidor = defaultProps.getProperty("servidor");
			String porta = defaultProps.getProperty("porta");
		
			RoutingHandler routing = Handlers.routing().add("POST", "/teste", new TesteHandlerPOST())
													   .add("POST", "/testeHeader", new TesteHandlerHeader());
			
			Undertow server = Undertow.builder().addHttpListener(new Integer(porta), servidor).setHandler(routing).build();
			server.start();
			
			log.info("**************");
			log.info("Início servidor rodando em " + new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date()));
			log.info("**************");
			
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	
	
}
