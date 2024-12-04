package com.sbpsystems.art2d2_vizsgaremek.config;

import com.sbpsystems.art2d2_vizsgaremek.controller.ApiController;
import com.sbpsystems.art2d2_vizsgaremek.controller.ExcersiseController;
import com.sbpsystems.art2d2_vizsgaremek.controller.PractiseController;
import com.sbpsystems.art2d2_vizsgaremek.controller.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ApiController apiController() {
        return new ApiController();
    }

    @Bean
    public ExcersiseController excersiseController() {
        return new ExcersiseController();
    }

    @Bean
    public PractiseController practiseController() {
        return new PractiseController();
    }

    @Bean
    public UserController userController() {
        return new UserController();
    }
}
