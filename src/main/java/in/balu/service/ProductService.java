package in.balu.service;

import in.balu.dto.ProductRequestDto;
import in.balu.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto addProduct(ProductRequestDto productRequestDto);

    boolean isProductExists(Long productId);

    ProductResponseDto getProductById(Long productId);

}
