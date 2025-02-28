package com.security.rolepermissionexample.product.model.dto.response;

import com.security.rolepermissionexample.product.model.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a response object containing product details as {@link ProductResponse}.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

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
