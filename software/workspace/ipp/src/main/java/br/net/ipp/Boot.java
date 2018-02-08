package br.net.ipp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class Boot
{

   public static void main(String[] args)
   {
      SpringApplication.run(Boot.class, args);
   }
   
   @Bean
   public EmbeddedServletContainerCustomizer containerCustomizer() {
    
      return (container -> {
           ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/400.jsp");
           ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.jsp");
           ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.jsp");
           ErrorPage error405Page = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/405.jsp");
           ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.jsp");
    
           container.addErrorPages(error400Page, error401Page, error404Page, error405Page, error500Page);
      });
   }
   
}
