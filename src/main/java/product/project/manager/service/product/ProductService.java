package product.project.manager.service.product;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.Pageable;
import product.project.manager.controller.product.dto.ProductListResponseDTO;


public class ProductService implements IProductService{

    @Override
    public ProductListResponseDTO getProductList(Pageable pageable) {
        return null;
    }
}
