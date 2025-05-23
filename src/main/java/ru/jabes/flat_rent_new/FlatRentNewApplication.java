package ru.jabes.flat_rent_new;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.jabes.flat_rent_new.entity.Client;
import ru.jabes.flat_rent_new.repository.ClientRepository;

@SpringBootApplication
public class FlatRentNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlatRentNewApplication.class, args);

//		ClientRepository clientRepository = context.getBean(ClientRepository.class);
//		Client client = new Client(null, "Петрович", "email");
//		System.out.println(clientRepository.save(client));
	}

}
