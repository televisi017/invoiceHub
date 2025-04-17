package com.invoice.service.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "INVOICE_ID")
    private String invoiceId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "INVOICE_NUMBER")
    String invoiceNumber;

    @Column(name = "PRODUCT_IDS")
    String productIds;

    @CreationTimestamp
    @Column(name = "CREATED_TIME")
    LocalDateTime createdTime;

    @CreationTimestamp
    @Column(name = "UPDATED_TIME")
    LocalDateTime updatedTime;
}
