package FarmnCook.FarmnCook.service;

import FarmnCook.FarmnCook.dto.UserDTO;
import FarmnCook.FarmnCook.entity.User;
import FarmnCook.FarmnCook.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long createUser(UserDTO userDTO) {
        User postUser = userRepository.save(
                User.builder()
                        .email(userDTO.getEmail())
                        .name(userDTO.getName())
                        .password(userDTO.getPassword()).
                        build());

        return postUser.getId();
    }

    @Transactional
    public UserDTO getOneUser(Long userId) {

        User getUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found User"));

        return UserDTO.entityToDTO(getUser);

    }
}
