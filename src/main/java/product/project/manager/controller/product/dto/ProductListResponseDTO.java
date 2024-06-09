package product.project.manager.controller.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import product.project.manager.common.dto.DefaultErrorResponseDTO;
import product.project.manager.controller.product.ProductController;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductListResponseDTO {

    private List<ProductController> content;

    private DefaultErrorResponseDTO error;

    @JsonIgnore private HttpStatus statusCode;
}
