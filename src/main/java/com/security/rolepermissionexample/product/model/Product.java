package com.security.rolepermissionexample.product.model;

import com.security.rolepermissionexample.common.model.BaseDomainModel;
import com.security.rolepermissionexample.product.model.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Represents a domain model for a product as {@link Product}.
 */
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseDomainModel {

    private String id;
    private String name;
    private BigDecimal amount;
    private BigDecimal unitPrice;
    private ProductStatus status;
    private String description;
    private String imageUrl;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer stock;
}