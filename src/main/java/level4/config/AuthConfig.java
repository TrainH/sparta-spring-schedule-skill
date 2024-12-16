package level4.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AuthConfig {
    @Bean
    public OncePerRequestFilter authFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain filterChain)
                    throws ServletException, IOException {
                String path = request.getRequestURI();
                System.out.println(path);
                if (path.equals("/auth/login")
                    || path.equals("/auth/logout")
                    || path.equals("/members/signup")) {
                    filterChain.doFilter(request, response);
                    return;
                }
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        System.out.println("Cookie Name: " + cookie.getName());
                        System.out.println("Cookie Value: " + cookie.getValue());
                        if ("SESSION".equals(cookie.getName()) &&
                                isValidSession(cookie.getValue())) {
                            filterChain.doFilter(request, response);
                            return;
                        }
                    }
                }
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            }

            private boolean isValidSession(String sessionId) {
                return true;
            }
        };
    }
}