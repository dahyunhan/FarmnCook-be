package FarmnCook.FarmnCook.controller;

import FarmnCook.FarmnCook.CommonResponse;
import FarmnCook.FarmnCook.dto.RequestUserDTO;
import FarmnCook.FarmnCook.dto.UserDTO;
import FarmnCook.FarmnCook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<CommonResponse<UserDTO>> createUser(@RequestBody UserDTO userDTO) {

        Long newUserId = userService.createUser(userDTO);
        CommonResponse<UserDTO> result = CommonResponse.success(newUserId);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/{accountId}")
    public ResponseEntity<CommonResponse<UserDTO>> getOneUser(@PathVariable(name = "accountId") Long userId) {

        UserDTO response = userService.getOneUser(userId);
        CommonResponse<UserDTO> result = CommonResponse.success(response);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{accountId}")
    public ResponseEntity<CommonResponse<RequestUserDTO>> updateUsers(@PathVariable(name = "accountId") Long userId, @RequestBody RequestUserDTO requestUserDTO) {


        Long response = userService.updateUsers(userId, requestUserDTO);
        CommonResponse<RequestUserDTO> result = CommonResponse.success(response);
        return ResponseEntity.ok(result);
    }

    @GetMapping()
    public ResponseEntity<CommonResponse<UserDTO>> getAllUser() {
        List<UserDTO> response = userService.getAllUser();
        CommonResponse<UserDTO> result = CommonResponse.success(response);
        return ResponseEntity.ok(result);
    }


}
