package com.smartsolutions.eschool.util.jwt;

import com.smartsolutions.eschool.auth.dtos.auth.responseDto.LoginResponseDTO;
import com.smartsolutions.eschool.global.props.jwtProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;

@Component
@Slf4j
public class JwtUtil {
    private final jwtProperties jwtProperties;


    public JwtUtil(jwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public String createToken(Map<String,Object> claims) {
        log.info("jwt private key {}", jwtProperties.getPrivateKey());
        log.info("jwt audience {}", jwtProperties.getAudience());
        log.info("jwt issuer {}", jwtProperties.getIssuer());
        log.info("jwt expiry {}", jwtProperties.getExpiry());
        long expire  = (jwtProperties.getExpiry())/1000*60*60;
        String jwtToken = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setClaims(claims)
                .setAudience(jwtProperties.getAudience())
                .setIssuer(jwtProperties.getIssuer())
                .setExpiration(new Date((new Date()).getTime() + expire))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getPrivateKey())
                .compact();
        log.info("jwt token - {}", jwtToken);
        return jwtToken;
    }


    public boolean validateJwtToken(String authToken, HttpServletResponse response) throws IOException {
        try {
            Jwts.parser().setSigningKey(jwtProperties.getPrivateKey()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public Claims extractClaims(String token) {

        return Jwts.parser()
                .setSigningKey(jwtProperties.getPrivateKey())
                .parseClaimsJws(token)
                .getBody();
    }

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expirationTime}")
    private String expirationTimeInMs;
    private Key key;


    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }


    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        // Add roles to token
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        claims.put("roles", roles);

        return Jwts.builder()
                .setClaims(claims)               // add roles here
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(expirationTimeInMs)))
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
