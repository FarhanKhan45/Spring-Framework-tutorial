
package com.example.springsecurity;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET =
            "MySuperSecretKey12345678901234567890";

    public String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(
                        System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignedKey())
                .compact();
    }

    private SecretKey getSignedKey() {

        byte[] keyBytes =
                SECRET.getBytes(StandardCharsets.UTF_8);

        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {

        return verifySignatureAndExtractAllClaims(token).getSubject();
    }

    public Claims verifySignatureAndExtractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSignedKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isTokenExpired(String token) {

        return verifySignatureAndExtractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }
}
