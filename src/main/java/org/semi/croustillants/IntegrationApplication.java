package org.semi.croustillants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegrationApplication {

	public static final String PAYMENT_BASE_URL = "http://ottolink.fr.nf:8080/soa_payment/payment";
	public static final String PROVIDER_BASE_URL = "http://soa-provider.hhacherouf.info/api";
	public static final String SHIPPING_BASE_URL = "https://ubp-isheep.herokuapp.com/isheep";
	public static final String I_SHEEP_TOKEN = "32aa7d9f-bd65-40aa-ba3c-5498fafd14e0";

	public static void main(String[] args) {
		SpringApplication.run(IntegrationApplication.class, args);
	}
}
