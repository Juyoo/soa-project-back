package org.semi.croustillants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegrationApplication {

	public static final String PAYMENT_BASE_URL = "http://ottolink.fr.nf:8080/soa_payment/payment";
	public static final String PROVIDER_BASE_URL = "http://soa-provider.hhacherouf.info/api";

	public static void main(String[] args) {
		SpringApplication.run(IntegrationApplication.class, args);
	}
}
