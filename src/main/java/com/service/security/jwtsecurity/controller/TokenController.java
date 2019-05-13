package com.service.security.jwtsecurity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.security.jwtsecurity.constraint.Roles;
import com.service.security.jwtsecurity.model.JwtUser;
import com.service.security.jwtsecurity.security.JwtGenerator;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController

public class TokenController {

    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/token")
    public String generate(@RequestBody final JwtUser jwtUser) {

        return jwtGenerator.generate(jwtUser);

    }
    
    @PostMapping("/details")
    @Roles({"ADMIN"})
    public String tokendetails(HttpServletRequest httpServletRequest)
    {
    	String header = httpServletRequest.getHeader("Authorisation");
    	Claims body = Jwts.parser()
                .setSigningKey("youtube")
                .parseClaimsJws(header)
                .getBody();
		return header+" data "+body;
    }
}
