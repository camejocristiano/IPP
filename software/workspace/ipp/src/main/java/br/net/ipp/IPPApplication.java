package br.net.ipp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import br.net.ipp.storage.StorageProperties;
import br.net.ipp.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class IPPApplication {

	public static void main(String[] args) {
		SpringApplication.run(IPPApplication.class, args);
	}
	
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
           // storageService.deleteAll();
           // storageService.init();
        };
    }
}
