package visite.project.jwt.request;

import lombok.Data;

@Data
public class RefreshTokenRequest {
    private String refreshToken;
}
