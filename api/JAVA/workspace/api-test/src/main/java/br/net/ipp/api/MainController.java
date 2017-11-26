package br.net.ipp.api;

import java.util.Calendar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping(path = "/")
	public String index () {
	    
	    Calendar c = Calendar.getInstance();

	    int dia = c.get(Calendar.DAY_OF_MONTH);
	    int mes = c.get(Calendar.MONTH);
	    int ano = c.get(Calendar.YEAR);
	    
	    int hora = c.get(Calendar.HOUR_OF_DAY);
	    int minuto = c.get(Calendar.MINUTE);
		
	    return " <h1 style='text-align:center'>AWS - IPP API</h1> " 
	    		 + "<br> <h4 style='text-align:center'> Data: " + dia + "/" + mes + "/" + ano + "</h4>"
	    		 + "<h4 style='text-align:center'> Hora: " + hora + ":" + minuto + "</h4>";
	}
	
	@RequestMapping(path = "/new")
	public String novo (@RequestParam String nome) {
		return nome;
	}
	
}
