package com.github.mperry.rest;

import id.hypersign.annotation.HSAuthorize;
import id.hypersign.annotation.HSAuthenticate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("")
class RestController {

    @HSAuthorize
    @RequestMapping(value = "/person", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    String getByOnlyCollabKey() {

        return "this is fun";
    }

    @HSAuthenticate
    @RequestMapping(value = "/auth/hs/api/v2/auth", method = RequestMethod.POST ,headers = "Accept=application/json")
    public @ResponseBody AuthResponse auth(@RequestBody String request) {
        System.out.println("Request body from app is" + request);
         //Do whatever you want to do with the user data.
        AuthResponse response = new AuthResponse("authentication is successful" ,200,null) ;
        return response;
    }

}
