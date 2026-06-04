package com.smartsolutions.eschool.security;

import com.smartsolutions.eschool.user.model.SystemUserEntity;
import com.smartsolutions.eschool.user.repository.SystemUserRepository;
import com.smartsolutions.eschool.util.jwt.UserDetailsImp;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final SystemUserRepository userRepository;

    public CustomUserDetailsService(SystemUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        SystemUserEntity user = userRepository.findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found: " + username));

        return UserDetailsImp.build(user);
    }
}

