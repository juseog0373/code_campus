package hanium.cocam.user;

import hanium.cocam.refresh.RefreshTokenService;
import hanium.cocam.user.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody JoinRequest request) {
        return ResponseEntity.ok().body(userService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok().body(userService.login(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{userNo}")
    public ResponseEntity<UserResponse> findUser(@PathVariable(name = "userNo") Long userNo) {
        return ResponseEntity.ok(userService.findUser(userNo));
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<LoginResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(userService.refreshToken(request).orElseThrow(() -> new RuntimeException("Refresh Token이 존재하지 않습니다.")));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody LogoutRequest request) {
       return ResponseEntity.ok(userService.logout(request));
    }

}
