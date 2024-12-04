package com.sbpsystems.art2d2_vizsgaremek.controller;

import com.sbpsystems.art2d2.vizsgaremek.api.UserApi;
import com.sbpsystems.art2d2.vizsgaremek.model.GetTopTenResponse;
import com.sbpsystems.art2d2.vizsgaremek.model.UserDataResponse;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {
    @Override
    public GetTopTenResponse getTopTen() {
        return null;
    }

    @Override
    public UserDataResponse getUserData(Long aLong) {
        return null;
    }
}
