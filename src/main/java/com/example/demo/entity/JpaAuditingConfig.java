package com.example.demo.entity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing  // Habilita la auditoría de JPA
public class JpaAuditingConfig {
}