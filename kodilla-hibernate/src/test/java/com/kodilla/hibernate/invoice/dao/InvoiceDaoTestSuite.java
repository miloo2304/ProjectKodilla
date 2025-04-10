package com.kodilla.hibernate.invoice.dao;


import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    public void testInvoiceDaoSave() {
        // Given
        Product product1 = new Product("Keyboard");
        Product product2 = new Product("Mouse");

        Item item1 = new Item(product1, new BigDecimal("150.00"), 2);
        Item item2 = new Item(product2, new BigDecimal("80.00"), 1);

        Invoice invoice = new Invoice("FV/2025/002");
        invoice.addItem(item1);
        invoice.addItem(item2);

        // When
        Invoice savedInvoice = invoiceRepository.save(invoice);
        int savedId = savedInvoice.getId();

        // Then
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(savedId);
        assertTrue(optionalInvoice.isPresent());
        assertEquals(2, optionalInvoice.get().getItems().size());

        // CleanUp
        invoiceRepository.deleteAll();
        //invoiceRepository.deleteById(savedId);
    }
}

