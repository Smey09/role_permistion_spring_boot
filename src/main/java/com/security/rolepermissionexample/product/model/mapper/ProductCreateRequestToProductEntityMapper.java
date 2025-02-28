package com.security.rolepermissionexample.product.model.mapper;

import com.security.rolepermissionexample.common.model.mapper.BaseMapper;
import com.security.rolepermissionexample.product.model.dto.request.ProductCreateRequest;
import com.security.rolepermissionexample.product.model.entity.ProductEntity;
import com.security.rolepermissionexample.product.model.enums.ProductStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

/**
 * Mapper interface named {@link ProductCreateRequestToProductEntityMapper} for converting {@link ProductCreateRequest} to {@link ProductEntity}.
 */
@Mapper
public interface ProductCreateRequestToProductEntityMapper extends BaseMapper<ProductCreateRequest, ProductEntity> {

    /**
     * Maps ProductCreateRequest to ProductEntity for saving purposes.
     *
     * @param productCreateRequest The ProductCreateRequest object to map.
     * @return ProductEntity object containing mapped data.
     */
    @Named("mapForSaving")
    default ProductEntity mapForSaving(ProductCreateRequest productCreateRequest) {
        return ProductEntity.builder()
                .amount(productCreateRequest.getAmount())
                .name(productCreateRequest.getName())
                .unitPrice(productCreateRequest.getUnitPrice())
                .status(productCreateRequest.getStatus()) // ✅ Status conversion
                .description(productCreateRequest.getDescription())
                .imageUrl(productCreateRequest.getImageUrl())
                .category(productCreateRequest.getCategory())
                .stock(productCreateRequest.getStock())
                .createdAt(LocalDateTime.now()) // Set createdAt
                .build();
    }

    /**
     * Initializes and returns an instance of ProductCreateRequestToProductEntityMapper.
     *
     * @return Initialized ProductCreateRequestToProductEntityMapper instance.
     */
    static ProductCreateRequestToProductEntityMapper initialize() {
        return Mappers.getMapper(ProductCreateRequestToProductEntityMapper.class);
    }

}
