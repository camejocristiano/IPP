package br.net.ipp.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {

	@GetMapping(path = "/")
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}

}
