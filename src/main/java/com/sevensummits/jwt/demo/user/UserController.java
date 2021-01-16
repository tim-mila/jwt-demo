package com.sevensummits.jwt.demo.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public static final String PATH = "/users";
    public static final String REGISTER_PATH  = PATH + "/register";

    private final ApplicationUserService applicationUserService;

    public UserController(final ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @PostMapping(REGISTER_PATH)
    public void register(@RequestBody UserRegistrationDto userRegistrationDto) {
        applicationUserService.create(userRegistrationDto);
    }
}
