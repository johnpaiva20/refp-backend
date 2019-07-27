package com.tostringtech.refp.application.authentication.api.rest.controllers;

import com.tostringtech.refp.application.authentication.api.rest.resources.TokenResource;
import com.tostringtech.refp.application.authentication.api.rest.resources.UserResource;
import com.tostringtech.refp.application.authentication.core.models.User;
import com.tostringtech.refp.application.authentication.core.providers.JwtTokenProvider;
import com.tostringtech.refp.application.authentication.core.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "Authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/authentication")
    public ResponseEntity<TokenResource> Authentication(@RequestBody UserResource userResource) {
        try {

            User user = new User(userResource);

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            String token = jwtTokenProvider.createToken(user.getUsername()/*, this.userService.findUserByUsernameOrEmail(username).getRoles()*/);

            TokenResource tokenResource = new TokenResource(user.getUsername(), token);

            return new ResponseEntity<>(tokenResource, HttpStatus.OK);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email/password supplied");
        }

    }


}
