package visite.project.exceptions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Http403ForbiddenEntryPoint implements AuthenticationEntryPoint {

    private static final Log logger = LogFactory.getLog(Http403ForbiddenEntryPoint.class);

    /**
     * Always returns a 403 error code to the client.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
            throws IOException {
        logger.debug("Pre-authenticated entry point called. Rejecting access");
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
    }

}
