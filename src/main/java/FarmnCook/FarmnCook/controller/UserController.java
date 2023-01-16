package FarmnCook.FarmnCook.controller;

import FarmnCook.FarmnCook.CommonResponse;
import FarmnCook.FarmnCook.dto.UserDTO;
import FarmnCook.FarmnCook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
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


}
