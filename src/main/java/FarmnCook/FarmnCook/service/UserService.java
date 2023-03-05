package FarmnCook.FarmnCook.service;

import FarmnCook.FarmnCook.dto.RequestUserDTO;
import FarmnCook.FarmnCook.dto.UserDTO;
import FarmnCook.FarmnCook.entity.User;
import FarmnCook.FarmnCook.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

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

    public UserDTO getOneUser(Long userId) {

        User getUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found User"));

        return UserDTO.entityToDTO(getUser);

    }

    @Transactional
    public Long updateUsers(Long userId, RequestUserDTO request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        user.changeEmail(request.getEmail());
        user.changePassword(request.getPassword());
        userRepository.save(user);

        return user.getId();
    }

    public List<UserDTO> getAllUser() {

        List<User> userList = userRepository.
                findAll();

        return userList.stream()
                .map(u -> UserDTO.builder()
                        .userId(u.getId())
                        .email(u.getEmail())
                        .name(u.getName())
                        .password(u.getPassword())
                        .build())
                .collect(Collectors.toList());
    }
}
