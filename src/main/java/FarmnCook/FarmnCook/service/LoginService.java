package FarmnCook.FarmnCook.service;

import FarmnCook.FarmnCook.dto.UserDTO;
import FarmnCook.FarmnCook.entity.User;
import FarmnCook.FarmnCook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class LoginService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDTO login(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getUserId()).orElseThrow();
        if (user.isSamePassword(userDTO.getPassword())) {
            throw new IllegalArgumentException();
        }
        return UserDTO.entityToDTO(user);
    }
}
