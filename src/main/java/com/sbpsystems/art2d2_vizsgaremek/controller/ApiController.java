package com.sbpsystems.art2d2_vizsgaremek.controller;

import com.sbpsystems.art2d2.vizsgaremek.api.ApiApi;
import com.sbpsystems.art2d2.vizsgaremek.model.AddUserRequestBodyType;
import com.sbpsystems.art2d2_vizsgaremek.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/art2d2/api")
public class ApiController implements ApiApi {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String addUser(AddUserRequestBodyType addUserRequestBodyType) {
        return "";
    }

    @Override
    public String logOut() {
        return "";
    }

    @Override
    @PostMapping("/login")
    public String login() {
        return "kalap kula";
    }
}
