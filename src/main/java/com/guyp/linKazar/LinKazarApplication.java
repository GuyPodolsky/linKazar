package com.guyp.linKazar;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class LinKazarApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinKazarApplication.class, args);
	}

}
