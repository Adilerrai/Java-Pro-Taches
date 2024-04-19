package visite.project.jwt;


import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import visite.project.jwt.request.AuthenticationRequest;
import visite.project.jwt.response.AuthenticationResponse;
import visite.project.model.enums.TokenType;
import visite.project.model.User;
import visite.project.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import org.springframework.transaction.annotation.Transactional;
import visite.project.service.AuthenticationService;
import visite.project.service.JwtService;
import visite.project.service.RefreshTokenService;


@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final UserRepository userRepository;
        private final AuthenticationManager authenticationManager;
        private final RefreshTokenService refreshTokenService;
        @Override
        public AuthenticationResponse register(RegisterRequest request) {
            var user = User.builder()
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(request.getRole())
                    .build();
            user = userRepository.save(user);
            var jwt = jwtService.generateToken(user);
            var refreshToken = refreshTokenService.createRefreshToken(user.getId());

            var roles = user.getRole().getAuthorities()
                    .stream()
                    .map(SimpleGrantedAuthority::getAuthority)
                    .toList();

            return AuthenticationResponse.builder()
                    .accessToken(jwt)
                    .email(user.getEmail())
                    .id(user.getId())
                    .refreshToken(refreshToken.getToken())
                    .roles(roles)
                    .tokenType( TokenType.BEARER.name())
                    .build();
        }

        @Override
        public AuthenticationResponse authenticate(AuthenticationRequest request) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

            var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email   or password."));
            var jwt = jwtService.generateToken(user);
            var refreshToken = refreshTokenService.createRefreshToken(user.getId());
            return AuthenticationResponse.builder()
                    .accessToken(jwt)
                    .email(user.getEmail())
                    .id(user.getId())
                    .refreshToken(refreshToken.getToken())
                    .tokenType( TokenType.BEARER.name())
                    .build();
        }
    }

