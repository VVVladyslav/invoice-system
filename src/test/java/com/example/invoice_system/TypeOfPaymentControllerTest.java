package com.example.invoice_system;

import com.example.invoice_system.model.TypeOfPayment;
import com.example.invoice_system.repository.TypeOfPaymentRepository;
import com.example.invoice_system.service.TypeOfPaymentService;
import com.example.invoice_system.controller.TypeOfPaymentController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class TypeOfPaymentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TypeOfPaymentService typeOfPaymentService;

    @InjectMocks
    private TypeOfPaymentController typeOfPaymentController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(typeOfPaymentController).build();
    }

    @Test
    public void testGetAllTypesOfPayment() throws Exception {
        mockMvc.perform(get("/api/types"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testCreateTypeOfPayment() throws Exception {
        TypeOfPayment newType = new TypeOfPayment();
        newType.setName("Test Payment");

        when(typeOfPaymentService.save(any(TypeOfPayment.class))).thenReturn(newType);

        mockMvc.perform(post("/api/types")
                        .contentType("application/json")
                        .content("{\"name\": \"Test Payment\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Payment"));
    }

    @Test
    public void testDeleteTypeOfPayment() throws Exception {
        mockMvc.perform(delete("/api/types/1"))
                .andExpect(status().isOk());

        verify(typeOfPaymentService, times(1)).deleteById(1L);
    }
}
