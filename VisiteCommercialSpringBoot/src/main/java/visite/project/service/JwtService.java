package visite.project.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    public abstract String extractUserName(String token);

    public abstract String generateToken(UserDetails userDetails);

    public abstract boolean isTokenValid(String token, UserDetails userDetails);
}
