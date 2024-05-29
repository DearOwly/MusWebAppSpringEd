package so.sonya.muswebapp2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import so.sonya.muswebapp2.api.UserApi;
import so.sonya.muswebapp2.dto.user.SignInForm;
import so.sonya.muswebapp2.dto.user.UserDto;
import so.sonya.muswebapp2.service.UserService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserService userService;

    @Override
    public UserDto signIn(SignInForm signInForm) {
        return null;
    }

//    @PutMapping
//    public ResponseEntity<UUID> add(@RequestBody UserDto user){
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(userService.save(user));
//    }

}
