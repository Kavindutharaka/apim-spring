package com.example.demo;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class AppController {
    @GetMapping("/")
    public String currentUserName(Model model, Authentication authentication) {

        DefaultOidcUser userDetails = (DefaultOidcUser) authentication.getPrincipal();
        model.addAttribute("userName", userDetails.getName());
        model.addAttribute("IDTokenClaims", userDetails);
        return "redirect:/site/index.html";
    }

}
