package com.vince.boot.demo.webapp.fe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
	
    @GetMapping(value = {"/"})
    public String rootPortfolio() {
        return "/indexFreelancer";
    }
	
    @GetMapping(value = {"/home","/login"})
    public String homeLogin() {
        return "/login";
    }
    
    @GetMapping(value = {"/indexAdmin"})
    public String homeAdmin() {
        return "/indexAdmin";
    }
    
    @GetMapping(value = {"/indexFreelancer"})
    public String homeIndex() {
        return "/indexFreelancer";
    }

    @GetMapping("/homeProtected")
    public String homeProtected() {
        return "/homeProtected";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }
    
    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
    
}
