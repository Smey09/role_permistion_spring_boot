package com.security.rolepermissionexample.product.service.impl;

import com.security.rolepermissionexample.product.exception.ProductAlreadyExistException;
import com.security.rolepermissionexample.product.model.Product;
import com.security.rolepermissionexample.product.model.dto.request.ProductCreateRequest;
import com.security.rolepermissionexample.product.model.entity.ProductEntity;
import com.security.rolepermissionexample.product.model.mapper.ProductCreateRequestToProductEntityMapper;
import com.security.rolepermissionexample.product.model.mapper.ProductEntityToProductMapper;
import com.security.rolepermissionexample.product.repository.ProductRepository;
import com.security.rolepermissionexample.product.service.ProductCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * Service implementation named {@link ProductCreateServiceImpl} for creating products.
 */
@Service
@RequiredArgsConstructor
public class ProductCreateServiceImpl implements ProductCreateService {

    private final ProductRepository productRepository;

    private final ProductCreateRequestToProductEntityMapper productCreateRequestToProductEntityMapper =
            ProductCreateRequestToProductEntityMapper.initialize();

    private final ProductEntityToProductMapper productEntityToProductMapper = ProductEntityToProductMapper.initialize();

    /**
     * Creates a new product based on the provided product creation request.
     *
     * @param productCreateRequest The request containing data to create the product.
     * @return The created Product object.
     * @throws ProductAlreadyExistException If a product with the same name already exists.
     */
    @Override
    public Product createProduct(ProductCreateRequest productCreateRequest) {

        checkUniquenessProductName(productCreateRequest.getName());

        final ProductEntity productEntityToBeSave = productCreateRequestToProductEntityMapper.mapForSaving(productCreateRequest);

        ProductEntity savedProductEntity = productRepository.save(productEntityToBeSave);

        System.out.println("Created product entity: " + savedProductEntity);
        System.out.println("id : " + String.valueOf(savedProductEntity.getId()));
        System.out.println("name : " + productCreateRequest.getName());
        System.out.println("amount : " + productCreateRequest.getAmount());
        System.out.println("unitPrice : " + productCreateRequest.getUnitPrice());
        System.out.println("status : " + productCreateRequest.getStatus());
        System.out.println("description : " + productCreateRequest.getDescription());
        System.out.println("imageUrl : " + productCreateRequest.getImageUrl());
        System.out.println("category : " + productCreateRequest.getCategory());
        System.out.println("createdAt: " + savedProductEntity.getCreatedAt());
        System.out.println("stock : " + productCreateRequest.getStock());

        return productEntityToProductMapper.map(savedProductEntity);

    }

    /**
     * Checks if a product with the given name already exists in the repository.
     *
     * @param productName The name of the product to check.
     * @throws ProductAlreadyExistException If a product with the same name already exists.
     */
    private void checkUniquenessProductName(final String productName) {
        if (productRepository.existsProductEntityByName(productName)) {
            throw new ProductAlreadyExistException("There is another product with given name: " + productName);
        }
    }

}
