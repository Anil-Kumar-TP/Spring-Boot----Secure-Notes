package com.notes.secure.notes.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfController {

    @GetMapping("/api/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        // Dynamically get the CSRF token attribute using Class.getName()
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());  // Return the CSRF token
    }
}
