package product.project.manager.service.product;

import org.springframework.data.domain.Pageable;
import product.project.manager.controller.product.dto.ProductResponseDTO;
import product.project.manager.domain.model.ProductModel;

import java.util.UUID;

public interface IProductService {

    ProductResponseDTO getProductList (Pageable pageable);

    ProductResponseDTO postProduct (ProductModel product);

    ProductResponseDTO deleteProduct (UUID productId);

    ProductResponseDTO putProduct (ProductModel product);

    ProductResponseDTO getSortProductList (Pageable pageable);

    ProductResponseDTO getFilterProductList (String productName);
}
