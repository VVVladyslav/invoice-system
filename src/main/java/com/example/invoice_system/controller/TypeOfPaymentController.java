package com.example.invoice_system.controller;

import com.example.invoice_system.model.TypeOfPayment;
import com.example.invoice_system.service.TypeOfPaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeOfPaymentController {

    private final TypeOfPaymentService service;

    public TypeOfPaymentController(TypeOfPaymentService service) {
        this.service = service;
    }

    @GetMapping
    public List<TypeOfPayment> getAll() {
        return service.getAll();
    }

    @PostMapping
    public TypeOfPayment create(@RequestBody TypeOfPayment type) {
        return service.save(type);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
