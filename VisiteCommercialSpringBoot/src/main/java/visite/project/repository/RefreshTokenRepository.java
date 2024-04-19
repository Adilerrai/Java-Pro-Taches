package visite.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import visite.project.jwt.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

}
