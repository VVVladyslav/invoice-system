package com.example.invoice_system.repository;

import com.example.invoice_system.model.TypeOfPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfPaymentRepository extends JpaRepository<TypeOfPayment, Long> {
}
