package FarmnCook.FarmnCook.controller;


import FarmnCook.FarmnCook.CommonResponse;
import FarmnCook.FarmnCook.dto.UserDTO;
import FarmnCook.FarmnCook.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("")
    public ResponseEntity<CommonResponse<UserDTO>>login(@RequestBody UserDTO userDTO){
UserDTO user = loginService.login(userDTO);
CommonResponse<UserDTO> result = CommonResponse.success(user);
 return ResponseEntity.ok(result);

    }
}
