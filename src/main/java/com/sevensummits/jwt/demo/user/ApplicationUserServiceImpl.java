package com.sevensummits.jwt.demo.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class ApplicationUserServiceImpl implements ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    ApplicationUserServiceImpl(
            final ApplicationUserRepository applicationUserRepository,
            final BCryptPasswordEncoder bCryptPasswordEncoder
    ) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public void create(final UserRegistrationDto userRegistrationDto) {

        if (applicationUserRepository.findByUsername(userRegistrationDto.getUsername()).isPresent()) {
            throw new UserConflictException();
        }

        applicationUserRepository.save(ApplicationUser.from(userRegistrationDto.getUsername(), bCryptPasswordEncoder.encode(userRegistrationDto.getPassword())));
    }

    @Override
    @Transactional
    public ApplicationUser findByUsername(final String username) {
        return applicationUserRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    static class UserConflictException extends RuntimeException { }

    static class UserNotFoundException extends RuntimeException { }
}
