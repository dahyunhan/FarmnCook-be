package FarmnCook.FarmnCook.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestUserDTO {

    private Long userId;
@NotBlank
    private String email;
@NotBlank
    private String password;
}

