package product.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import product.project.manager.domain.model.ProductModel;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

    List<ProductModel> findByNameContainingIgnoreCase(String name);
}
