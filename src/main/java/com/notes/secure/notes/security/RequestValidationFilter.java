package com.notes.secure.notes.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class RequestValidationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Validate the X-Valid-Request header
        String validRequestHeader = request.getHeader("X-Valid-Request");

        if (validRequestHeader == null || !validRequestHeader.equals("true")) {
            // Reject the request if the header is invalid
           response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Invalid request");
            return;
        }

        // Proceed with the filter chain if validation passes
        filterChain.doFilter(request, response);
    }
}
