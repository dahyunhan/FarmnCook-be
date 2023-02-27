package FarmnCook.FarmnCook.dto;

import FarmnCook.FarmnCook.entity.User;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserDTO {

    private Long userId;

    private String email;

    private String name;

    private String password;


    public static UserDTO entityToDTO(User entity){
        return UserDTO.builder()
                .userId(entity.getId())
                .email(entity.getEmail())
                .name(entity.getName())
                .password(entity.getPassword())
                .build();
    }

}
