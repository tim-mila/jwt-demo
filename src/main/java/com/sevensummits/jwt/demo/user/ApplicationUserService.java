package com.sevensummits.jwt.demo.user;

public interface ApplicationUserService {

    void create(UserRegistrationDto userRegistrationDto);

    ApplicationUser findByUsername(String username);
}
