package product.project.manager.controller.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import product.project.manager.controller.product.dto.ProductListResponseDTO;
import product.project.manager.service.product.IProductService;

@RestController
@RequiredArgsConstructor
public class ProductController implements IProductController {

    private final IProductService productService;

    @Override
    public ResponseEntity<ProductListResponseDTO> getProductList(Pageable pageable) {

        ProductListResponseDTO response = productService.getProductList(pageable);

        return new ResponseEntity<>(response, response.getStatusCode());
    }
}
