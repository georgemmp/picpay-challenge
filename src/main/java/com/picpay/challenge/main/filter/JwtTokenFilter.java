package com.picpay.challenge.main.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.picpay.challenge.infrastructure.security.jwt.JwtService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class JwtTokenFilter extends GenericFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String token = this.jwtService.resolveToken((HttpServletRequest) servletRequest);

        if (Objects.nonNull(token) && this.jwtService.validateToken(token)) {
            DecodedJWT decoded = this.jwtService.decodedJWT(token);
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(decoded.getSubject());

            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
