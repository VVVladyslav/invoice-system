package com.example.invoice_system.service;

import com.example.invoice_system.model.TypeOfPayment;
import com.example.invoice_system.repository.TypeOfPaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfPaymentService {

    private final TypeOfPaymentRepository repository;

    public TypeOfPaymentService(TypeOfPaymentRepository repository) {
        this.repository = repository;
    }

    public List<TypeOfPayment> getAll() {
        return repository.findAll();
    }

    public TypeOfPayment save(TypeOfPayment type) {
        return repository.save(type);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
