package FarmnCook.FarmnCook.dto;

import FarmnCook.FarmnCook.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserDTO {

    private Long userId;
    @NotBlank
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String password;


    public static UserDTO entityToDTO(User entity){
        return UserDTO.builder()
                .userId(entity.getId())
                .email(entity.getEmail())
                .name(entity.getName())
                .build();
    }

}
