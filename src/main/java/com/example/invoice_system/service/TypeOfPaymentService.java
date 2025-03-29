package com.example.invoice_system.service;

import com.example.invoice_system.model.TypeOfPayment;
import com.example.invoice_system.repository.TypeOfPaymentRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import org.springframework.cache.annotation.CacheEvict;


import java.util.List;

@Service
public class TypeOfPaymentService {

    private final TypeOfPaymentRepository repository;

    public TypeOfPaymentService(TypeOfPaymentRepository repository) {
        this.repository = repository;
    }

    @Cacheable("typeOfPayments")
    public List<TypeOfPayment> getAll() {
        return repository.findAll();
    }

    @CacheEvict(value = "typeOfPayments", allEntries = true)  // Очищаем кэш, если данные изменяются
    public TypeOfPayment save(TypeOfPayment type) {
        return repository.save(type);
    }

    @CacheEvict(value = "typeOfPayments", allEntries = true)
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
