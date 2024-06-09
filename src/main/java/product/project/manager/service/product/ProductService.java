package product.project.manager.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import product.project.manager.controller.product.dto.ProductResponseDTO;
import product.project.manager.domain.model.ProductModel;
import product.project.manager.repository.ProductRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponseDTO getProductList(Pageable pageable) {
        ProductResponseDTO response = new ProductResponseDTO();

        Page<ProductModel> productModelList = productRepository.findAll(pageable);

        if (productModelList.isEmpty()) {
            response.setStatusCode(HttpStatus.NOT_FOUND);
        } else {
            response.setStatusCode(HttpStatus.OK);
            response.setContent(productModelList.stream().toList());
        }
        return response;
    }

    @Override
    public ProductResponseDTO postProduct(ProductModel product) {
        ProductResponseDTO response = new ProductResponseDTO();

        ProductModel productModel = productRepository.save(product);

        response.setStatusCode(HttpStatus.CREATED);
        response.setContent(Collections.singletonList(productModel));

        return response;
    }

    @Override
    public ProductResponseDTO deleteProduct(UUID productId) {
        ProductResponseDTO response = new ProductResponseDTO();

        productRepository.deleteById(productId);

        response.setStatusCode(HttpStatus.NO_CONTENT);

        return response;
    }

    @Override
    public ProductResponseDTO putProduct(ProductModel product) {
        ProductResponseDTO response = new ProductResponseDTO();

        Optional<ProductModel> productModel = productRepository.findById(product.getId());

        if (productModel.isEmpty()) {
            response.setStatusCode(HttpStatus.NOT_FOUND);
        } else {
            response.setStatusCode(HttpStatus.ACCEPTED);
            response.setContent(Collections.singletonList(productRepository.save(product)));
        }

        return response;
    }

    @Override
    public ProductResponseDTO getSortProductList(Pageable pageable) {
        ProductResponseDTO response = new ProductResponseDTO();

        Page<ProductModel> productModelPage = productRepository.findAll(pageable);

        if (productModelPage.isEmpty()) {
            response.setStatusCode(HttpStatus.NOT_FOUND);
        } else {
            List<ProductModel> productModelList = productModelPage.stream().toList();
            Collections.shuffle(productModelList);
            response.setStatusCode(HttpStatus.OK);
            response.setContent(productModelList);
        }
        return response;
    }

    @Override
    public ProductResponseDTO getFilterProductList(String productName) {
        ProductResponseDTO response = new ProductResponseDTO();

        List<ProductModel> filteredProductList = productRepository.findByNameContainingIgnoreCase(productName);

        if (filteredProductList.isEmpty()) {
            response.setStatusCode(HttpStatus.NOT_FOUND);
        } else {
            response.setStatusCode(HttpStatus.OK);
            response.setContent(filteredProductList);
        }

        return response;
    }
}
