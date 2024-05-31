package so.sonya.muswebapp2.security.filters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.authentication.UsernamePasswordAuthenticationToken.unauthenticated;

@Setter
public class JsonUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static final Logger LOG = LoggerFactory.getLogger(JsonUsernamePasswordAuthenticationFilter.class);

    private boolean postOnly = true;

    public JsonUsernamePasswordAuthenticationFilter() {
        super();
    }

    private JsonUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        String username;
        String password;

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(request.getReader());
            username = jsonNode.get(getUsernameParameter()).asText();
            password = jsonNode.get(getPasswordParameter()).asText();
        } catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage());
        }

        username = (username != null) ? username.trim() : "";
        password = (password != null) ? password : "";

        LOG.info("Username: {}, Password: {}", username, password);

        UsernamePasswordAuthenticationToken authRequest = unauthenticated(username, password);

        return getAuthenticationManager().authenticate(authRequest);
    }
}
