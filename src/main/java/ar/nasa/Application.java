package ar.nasa;

import java.util.Date;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
    	
    	try{
	    	Date start = new Date();
	        SpringApplication.run(Application.class, args);
	        Date end = new Date();
	
	        System.out.println("\t!!! Duración total del proceso:\t" + (end.getTime()-start.getTime())/1000 + " seg.");
	        System.out.println();
			System.out.println("================================================================================");
			System.out.println();
			
    	} catch(BeanCreationException e) {
    		if (e.getBeanName().equals("batchDatabaseInitializer")) {
    			System.out.println();
    			System.out.println("================================================================================");
    			System.out.println("\t!!! No se pudo establecer conexión con IFS");
    			System.out.println("\t!!! Compruebe usuario y password");
    			System.out.println();
    			System.out.println("================================================================================");
    			System.out.println();
    		}
    	}
    }
}
