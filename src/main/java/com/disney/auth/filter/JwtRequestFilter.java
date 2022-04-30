package com.disney.auth.filter;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.disney.auth.service.JwtUtils;
import com.disney.auth.service.UserDetailsCustomService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

    @Autowired
    private UserDetailsCustomService userDetailsCustomService;
    @Autowired
    JwtUtils jwtUtil;

    private static final String BEARER = "Bearer";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;
        
        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER)) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsCustomService.loadUserByUsername(username);
            if (jwtUtil.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authReq =
                    new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), Collections.EMPTY_LIST);
                SecurityContextHolder.getContext().setAuthentication(authReq);
            }
        }
        filterChain.doFilter(request, response);
     }
}
