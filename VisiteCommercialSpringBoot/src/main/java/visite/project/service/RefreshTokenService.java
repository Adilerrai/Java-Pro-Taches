package visite.project.service;

import org.springframework.stereotype.Service;
import visite.project.jwt.RefreshToken;
import visite.project.jwt.request.RefreshTokenRequest;
import visite.project.jwt.response.RefreshTokenResponse;
@Service

public interface RefreshTokenService {
    public RefreshToken createRefreshToken(Long id) ;

    public abstract RefreshToken verifyExpiration(RefreshToken token);

    public abstract RefreshTokenResponse generateNewToken(RefreshTokenRequest request);
}
