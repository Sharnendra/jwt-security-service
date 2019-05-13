package com.service.security.jwtsecurity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.security.jwtsecurity.aspect.EmployeeService;
import com.service.security.jwtsecurity.constraint.LogExecutionTime;
import com.service.security.jwtsecurity.constraint.Roles;
import com.service.security.jwtsecurity.model.JwtUser;
import com.service.security.jwtsecurity.security.JwtGenerator;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController

public class TokenController {

	@Autowired
	private EmployeeService employeeService;
    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/token")
    public String generate(@RequestBody final JwtUser jwtUser) {

        return jwtGenerator.generate(jwtUser);

    }
    
    @PostMapping("/details")
    @Valid @Roles(value = {"user" })
    public String tokendetails(HttpServletRequest httpServletRequest)
    {
    	String[] ls={"Admin"};
    	String header = httpServletRequest.getHeader("Authorisation");
    	employeeService.createEmployee("fdfdf", "55",ls);
    	Claims body = Jwts.parser()
                .setSigningKey("youtube")
                .parseClaimsJws(header)
                .getBody();
		return header+" data "+body;
    }
}
