package com.product.service.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="product")
public class Product {

    @Column(name="product_id", nullable=false)
    @Id
    @NonNull
    String productId;

    @Column(name="name", nullable=false)
    @NonNull
    String name;

    @Column(name="description", nullable=false)
    @NonNull
    String description;

    @Column(name="price", nullable=false)
    @NonNull
    Double price;

    @Column(name="stock_quantity", nullable=false)
    @NonNull
    Integer stockQuantity;

    @Column(name="created_at", nullable=false, updatable = false)
    @CreationTimestamp
    LocalDateTime createdAt;

    @Column(name="updated_at", nullable=false)
    @UpdateTimestamp
    LocalDateTime updatedAt;
}
