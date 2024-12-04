package com.sbpsystems.art2d2_vizsgaremek.controller;

import com.sbpsystems.art2d2.vizsgaremek.api.ExcersiseApi;
import com.sbpsystems.art2d2.vizsgaremek.model.ClaimedRewardListResponse;
import com.sbpsystems.art2d2.vizsgaremek.model.EyePractiseDataResponse;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcersiseController implements ExcersiseApi {
    @Override
    public ClaimedRewardListResponse addExcerciseFinish(Object o, Long aLong) {
        return null;
    }

    @Override
    public EyePractiseDataResponse getExerciseByEyePractiseId(Long aLong) {
        return null;
    }
}
