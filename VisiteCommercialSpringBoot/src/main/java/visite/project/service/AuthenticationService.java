package visite.project.service;

import visite.project.jwt.RegisterRequest;
import visite.project.jwt.request.AuthenticationRequest;
import visite.project.jwt.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
