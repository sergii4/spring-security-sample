package com.getman.security.service;


import com.getman.domain.entity.User;
import com.getman.repository.UserRepository;
import com.getman.security.domain.PermissionCentricUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * {@link UserDetailsService} implementation which handles also roles permissions.
 */
@Component
public class PermissionCentricUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);
        String lcLogin = login.toLowerCase();
        Optional<User> dbUser = userRepository.findOneByName(lcLogin);
        return dbUser
            .map(u -> {
                List<GrantedAuthority> grantedRoles = u.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
                return new PermissionCentricUserDetails(lcLogin, u.getId(), u.getPasswordHash(),
                                                        grantedRoles, u.getRoles());
            })
            .orElseThrow(() -> new UsernameNotFoundException("No such user: " + lcLogin));
    }
}
