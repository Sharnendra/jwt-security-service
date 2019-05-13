package com.service.security.jwtsecurity.aspect;

import java.lang.reflect.Method;

import javax.annotation.security.RolesAllowed;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.service.security.jwtsecurity.constraint.Roles;

@Aspect
@Component
public class EmployeeServiceAspect {

	@Before(value = "execution(* com.service.security.jwtsecurity.aspect.EmployeeService.*(..)) and args(name,empId,ls) && @annotation(com.service.security.jwtsecurity.constraint.Roles)")
	public void beforeAdvice(JoinPoint joinPoint, String name, String empId, String[] ls) {
		System.out.println("Before method:" + joinPoint.getSignature());

		System.out.println("Creating Employee with name - " + name + " and id - " + empId+" Annonatation v ");
	}

	@After(value = "execution(* com.service.security.jwtsecurity.aspect.EmployeeService.*(..)) and args(name,empId,ls) && @annotation(com.service.security.jwtsecurity.constraint.Roles)")
	public void afterAdvice(JoinPoint joinPoint, String name, String empId, String[] ls) {
		System.out.println("After method:" + joinPoint.getArgs().toString());

		System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Class<?> declaringClass = method.getDeclaringClass();
        RolesAllowed myAnnotation = declaringClass.getAnnotation(RolesAllowed.class);
		System.err.println("Successfully created Employee with name - " + name + " and Roles - " + myAnnotation.value());
	}
	
}
