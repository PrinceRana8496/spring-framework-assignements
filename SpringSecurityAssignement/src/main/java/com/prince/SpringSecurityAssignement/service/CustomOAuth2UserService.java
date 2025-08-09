package com.prince.SpringSecurityAssignement.service;

import com.prince.SpringSecurityAssignement.entity.Role;
import com.prince.SpringSecurityAssignement.entity.User;
import com.prince.SpringSecurityAssignement.repository.RoleRepository;
import com.prince.SpringSecurityAssignement.repository.UserRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public CustomOAuth2UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String email = oAuth2User.getAttribute("email");

        User user = userRepository.findByUsername(email).orElseGet(() -> {
            Role userRole = roleRepository.findByName("ROLE_USER");
            if (userRole == null) {
                userRole = new Role("ROLE_USER");
                roleRepository.save(userRole);
            }

            User newUser = new User();
            newUser.setUsername(email);
            newUser.setPassword("");
            newUser.setRoles(new HashSet<>() {{ add(userRole); }});
            return userRepository.save(newUser);
        });

        return oAuth2User;
    }
}
