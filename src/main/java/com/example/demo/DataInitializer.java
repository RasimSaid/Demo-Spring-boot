package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        
        if (userRepository.findByUsername("rasimsaid").isEmpty()) {
            User admin = new User();
            admin.setUsername("rasimsaid");
            admin.setEmail("rasimsaid@admin.com");
            admin.setPassword(passwordEncoder.encode("350948ft"));
            admin.setRole("ROLE_ADMIN");

            userRepository.save(admin);
            System.out.println("--- ADMIN ACCOUNT HAS BEEN CREATED ---");
            System.out.println("User: rasimsaid");
        }
    }
}