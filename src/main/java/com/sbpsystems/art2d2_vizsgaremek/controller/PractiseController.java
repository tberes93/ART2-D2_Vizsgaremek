package com.sbpsystems.art2d2_vizsgaremek.controller;

import com.sbpsystems.art2d2.vizsgaremek.api.PractiseApi;
import com.sbpsystems.art2d2.vizsgaremek.model.EyePractiseDataResponse;
import com.sbpsystems.art2d2.vizsgaremek.model.EyePractiseListResponse;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PractiseController implements PractiseApi {
    @Override
    public EyePractiseDataResponse getPractiseDataById(Long aLong) {
        return null;
    }

    @Override
    public EyePractiseListResponse getPractiseList() {
        return null;
    }
}
