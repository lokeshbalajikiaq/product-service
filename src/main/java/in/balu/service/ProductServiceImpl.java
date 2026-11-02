package in.balu.service;

import in.balu.dto.ProductRequestDto;
import in.balu.dto.ProductResponseDto;
import in.balu.models.Product;
import in.balu.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {

        Product product = new Product();
        BeanUtils.copyProperties(productRequestDto, product);

        Product dbProduct = productRepository.save(product);

        return mapToDto(dbProduct);
    }
    @Override
    public boolean isProductExists(Long productId) {
         return productRepository.existsById(productId);
    }

    @Override
    public ProductResponseDto getProductById(Long productId) {
        return productRepository.findById(productId)
//                .map(p -> mapToDto(p))
                .map(this :: mapToDto)
                .orElseThrow(() -> new RuntimeException("Product not found in DB"));

    }

    private ProductResponseDto mapToDto(Product dbProduct) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        BeanUtils.copyProperties(dbProduct, productResponseDto);
        return productResponseDto;
    }
}
