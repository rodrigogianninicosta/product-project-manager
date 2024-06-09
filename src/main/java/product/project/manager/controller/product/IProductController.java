package product.project.manager.controller.product;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import product.project.manager.controller.product.dto.ProductListResponseDTO;
import product.project.manager.domain.model.ProductModel;

import java.util.UUID;

@RequestMapping("/product")
@Validated
public interface IProductController {

    @GetMapping(path = {""}, produces = "application/json")
    ResponseEntity<ProductListResponseDTO> getProductList(
            @PageableDefault(page = 0, size = 1000, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    );

    @PostMapping(path = {""}, produces = "application/json")
    ResponseEntity<ProductListResponseDTO> postProduct(
            @RequestBody ProductModel product
    );

    @DeleteMapping(path = {""}, produces = "application/json")
    ResponseEntity<ProductListResponseDTO> deleteProduct(
            @RequestParam(name = "productId", required = true) UUID productId
    );

    @PutMapping(path = {""}, produces = "application/json")
    ResponseEntity<ProductListResponseDTO> putProduct(
            @RequestBody ProductModel product
    );

    @GetMapping(path = {"/sort"}, produces = "application/json")
    ResponseEntity<ProductListResponseDTO> sortProductList(
            @PageableDefault(page = 0, size = 1000, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    );

    @GetMapping(path = {"/filter"}, produces = "application/json")
    ResponseEntity<ProductListResponseDTO> filterProductList(
            @RequestParam(name = "productName", required = true) String productName
    );


}
