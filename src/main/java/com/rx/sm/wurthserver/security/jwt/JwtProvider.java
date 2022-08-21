package com.rx.sm.wurthserver.security.jwt;

import com.rx.sm.wurthserver.security.model.AuthUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        System.out.println(authUser + "gffd");
        return Jwts.builder().setSubject(authUser.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+expiration*1000l))
                .signWith(SignatureAlgorithm.HS512,secret).compact();
    }
    public  String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validationToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("Malformed token");
        }catch (UnsupportedJwtException e){
            logger.error("Token not supported");
        }catch (ExpiredJwtException e){
            logger.error("El token ha expirado");
        }catch (IllegalArgumentException e){
            logger.error("Token not provided");
        }catch (SignatureException e){
            logger.error("Unknown token");
        }
        return false;
    }
}
