package com.example.cruddemo.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/user", produces = {"application/json; charset=UTF-8"})
public class JWTController {
    private static final String SECRET = "ThisIsASecretKeyThatShouldBeLongEnoughForHS512";
    @RequestMapping("/login/{username}/{password}")
    public Map login(@PathVariable String username, @PathVariable String password) {
        Map result = new HashMap();
        if (username.equals("admin") && password.equals("123456")) {
            String jwt = Jwts.builder().
                    setSubject(username).
                    signWith(SignatureAlgorithm.HS256, SECRET).
                    compact();
            result.put("token", jwt);
        } else {
            result.put("message", "账号密码错误");
        }
        return result;
    }
    @RequestMapping("/goods/{token}")
    public Map verifyToken(@PathVariable String token) {
        Map result = new HashMap();
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        result.put("username", claimsJws.getBody().getSubject());
        return result;
    }
}
