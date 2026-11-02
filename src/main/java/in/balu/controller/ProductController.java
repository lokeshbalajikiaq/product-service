package in.balu.controller;
import in.balu.dto.ProductRequestDto;
import in.balu.dto.ProductResponseDto;
import in.balu.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductResponseDto addProduct(@Valid @RequestBody ProductRequestDto productRequestDto) {

        return productService.addProduct(productRequestDto);

    }

    @GetMapping("/{productId}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductResponseDto getProduct(@PathVariable Long productId) {

        return productService.getProductById(productId);

    }

    @GetMapping("/exists/{productId}")
    @ResponseStatus(code = HttpStatus.OK)
    public boolean isProductExists(@PathVariable Long productId) {

        return productService.isProductExists(productId);

    }

}
