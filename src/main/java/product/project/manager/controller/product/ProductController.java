package product.project.manager.controller.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import product.project.manager.controller.product.dto.ProductResponseDTO;
import product.project.manager.domain.model.ProductModel;
import product.project.manager.service.product.IProductService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Validated
public class ProductController implements IProductController {

    private final IProductService productService;

    @Override
    public ResponseEntity<ProductResponseDTO> getProductList(Pageable pageable) {

        ProductResponseDTO response = productService.getProductList(pageable);

        return new ResponseEntity<>(response, response.getStatusCode());
    }

    @Override
    public ResponseEntity<ProductResponseDTO> postProduct(ProductModel product) {

        ProductResponseDTO response = productService.postProduct(product);

        return new ResponseEntity<>(response, response.getStatusCode());
    }

    @Override
    public ResponseEntity<ProductResponseDTO> deleteProduct(UUID productId) {

        ProductResponseDTO response = productService.deleteProduct(productId);

        return new ResponseEntity<>(response, response.getStatusCode());
    }

    @Override
    public ResponseEntity<ProductResponseDTO> putProduct(ProductModel product) {

        ProductResponseDTO response = productService.putProduct(product);

        return new ResponseEntity<>(response, response.getStatusCode());
    }

    @Override
    public ResponseEntity<ProductResponseDTO> getSortProductList(Pageable pageable) {

        ProductResponseDTO response = productService.getSortProductList(pageable);

        return new ResponseEntity<>(response, response.getStatusCode());
    }

    @Override
    public ResponseEntity<ProductResponseDTO> getFilterProductList(String productName) {

        ProductResponseDTO response = productService.getFilterProductList(productName);

        return new ResponseEntity<>(response, response.getStatusCode());
    }
}
