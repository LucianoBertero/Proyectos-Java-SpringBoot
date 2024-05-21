package com.google.service.impl;

import com.google.controller.response.RecaptchaResponse;
import com.google.service.RecaptchaService;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class RecaptchaServiceImpl  implements RecaptchaService {
    private static final String GOOGLE_RECAPTCHA_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";

    private final String RECAPTCHA_SECRET= "6LeDHeMpAAAAAHy9GPeuG5tU7-BOkaZCxqFJBpWl";

    @Override
    public boolean validateRecaptcha(String recaptcha) {

        RestTemplate restTemplate = new RestTemplate();
        //se hace para poder mandar en el body la consulta
        MultiValueMap<String,String> request = new LinkedMultiValueMap<>();
        request.add("secret", RECAPTCHA_SECRET);
        request.add("response", recaptcha);
        RecaptchaResponse apiResponse = restTemplate.postForObject(GOOGLE_RECAPTCHA_ENDPOINT,request,RecaptchaResponse.class);

        if(apiResponse==null){
            return false;
        }

        return Boolean.TRUE.equals(apiResponse.getSuccess());
    }
}
