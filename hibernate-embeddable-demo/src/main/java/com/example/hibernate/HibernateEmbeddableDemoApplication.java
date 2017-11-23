package com.example.hibernate;

import com.example.hibernate.model.Address;
import com.example.hibernate.model.Name;
import com.example.hibernate.model.User;
import com.example.hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateEmbeddableDemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateEmbeddableDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAllInBatch();

		Name name = new Name("Rajeev", "Kumar", "Singh");
		Address address = new Address("747", "Golf View Road", "Bangalore", "Karnataka", "India", "560008");
		User user = new User(name, "rajeev@callicoder.com", address);

		userRepository.save(user);
	}
}