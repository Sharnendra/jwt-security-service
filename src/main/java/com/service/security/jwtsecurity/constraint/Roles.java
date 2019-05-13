package com.service.security.jwtsecurity.constraint;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Specifies the list of security roles permitted to access method(s) in an 
 * application.  The value of the <code>Roles</code> annotation 
 * is a list of security role names. 
 * This annotation can be specified on a class or on method(s). Specifying it 
 * at a class level means that it applies to all the methods in the class. 
 * Specifying it on a method means that it is applicable to that method only. 
 * If applied at both the class and methods level, the method value overrides 
 * the class value if the two conflict.
 *
 * @since Common Annotations 1.0
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface Roles {
    /**
     * List of roles that are permitted access.
     */
    String[] value();
}
