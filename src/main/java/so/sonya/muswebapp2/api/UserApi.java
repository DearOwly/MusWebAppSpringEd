package so.sonya.muswebapp2.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import so.sonya.muswebapp2.dto.user.SignInForm;
import so.sonya.muswebapp2.dto.user.UserDto;
import io.swagger.annotations.Api;

import java.util.UUID;

import static so.sonya.muswebapp2.api.common.Variables.BASE_URL;

@RequestMapping(BASE_URL+"user")
@CrossOrigin(maxAge = 3600)
@Api(tags = "", value = "")
public interface UserApi {
    @ApiOperation(value = "")
    @ResponseStatus
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "successfully get the creator", response = UUID.class),
            @ApiResponse(code = 400, message = "validation error"),
            @ApiResponse(code = 500, message = "internal error")})
    @PostMapping("/sign-in")
    UserDto signIn(@RequestBody SignInForm signInForm);
}
