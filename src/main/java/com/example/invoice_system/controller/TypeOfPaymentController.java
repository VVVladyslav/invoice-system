package com.example.invoice_system.controller;

import com.example.invoice_system.model.TypeOfPayment;
import com.example.invoice_system.service.TypeOfPaymentService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeOfPaymentController {

    private final TypeOfPaymentService service;

    public TypeOfPaymentController(TypeOfPaymentService service) {
        this.service = service;
    }

    @Cacheable(value = "typesCache") // Аннотация для кэширования данных
    @GetMapping
    public List<TypeOfPayment> getAll() {
        return service.getAll();
    }

    @CacheEvict(value = "typesCache", allEntries = true) // Очистка кэша при добавлении нового типа оплаты
    @PostMapping
    public TypeOfPayment create(@RequestBody TypeOfPayment type) {
        return service.save(type);
    }

    @CacheEvict(value = "typesCache", allEntries = true) // Очистка кэша при удалении типа оплаты
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
