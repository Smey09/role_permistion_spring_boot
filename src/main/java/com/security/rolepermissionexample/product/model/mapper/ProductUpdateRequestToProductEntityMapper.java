package com.security.rolepermissionexample.product.model.mapper;

import com.security.rolepermissionexample.common.model.mapper.BaseMapper;
import com.security.rolepermissionexample.product.model.dto.request.ProductUpdateRequest;
import com.security.rolepermissionexample.product.model.entity.ProductEntity;
import com.security.rolepermissionexample.product.model.enums.ProductStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Mapper interface named {@link ProductUpdateRequestToProductEntityMapper} for updating {@link ProductEntity} using {@link ProductUpdateRequest}.
 */
@Mapper
public interface ProductUpdateRequestToProductEntityMapper extends BaseMapper<ProductUpdateRequest, ProductEntity> {

    /**
     * Maps fields from ProductUpdateRequest to update ProductEntity.
     *
     * @param productEntityToBeUpdate The ProductEntity object to be updated.
     * @param productUpdateRequest    The ProductUpdateRequest object containing updated fields.
     */
    @Named("mapForUpdating")
    default void mapForUpdating(ProductEntity productEntityToBeUpdate, ProductUpdateRequest productUpdateRequest) {
        if (productUpdateRequest.getName() != null) {
            productEntityToBeUpdate.setName(productUpdateRequest.getName());
        }
        if (productUpdateRequest.getAmount() != null) {
            productEntityToBeUpdate.setAmount(productUpdateRequest.getAmount());
        }
        if (productUpdateRequest.getUnitPrice() != null) {
            productEntityToBeUpdate.setUnitPrice(productUpdateRequest.getUnitPrice());
        }
        if (productUpdateRequest.getStatus() != null) {
            productEntityToBeUpdate.setStatus(productUpdateRequest.getStatus());
        }
        if (productUpdateRequest.getDescription() != null) {
            productEntityToBeUpdate.setDescription(productUpdateRequest.getDescription());
        }
        if (productUpdateRequest.getImageUrl() != null) {
            productEntityToBeUpdate.setImageUrl(productUpdateRequest.getImageUrl());
        }
        if (productUpdateRequest.getCategory() != null) {
            productEntityToBeUpdate.setCategory(productUpdateRequest.getCategory());
        }
        if (productUpdateRequest.getStock() != null) {
            productEntityToBeUpdate.setStock(productUpdateRequest.getStock());
        }

        // Always update updatedAt
        productEntityToBeUpdate.setUpdatedAt(LocalDateTime.now());
    }


    /**
     * Initializes and returns an instance of ProductUpdateRequestToProductEntityMapper.
     *
     * @return Initialized ProductUpdateRequestToProductEntityMapper instance.
     */
    static ProductUpdateRequestToProductEntityMapper initialize() {
        return Mappers.getMapper(ProductUpdateRequestToProductEntityMapper.class);
    }

}
