package level8.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

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

                // 아래 URL만 접근 가능: 나머지는 세션이 있어야함
                if (path.equals("/auth/login")
                    || path.equals("/auth/logout")
                    || path.equals("/members/signup")) {
                    filterChain.doFilter(request, response);
                    return;
                }
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
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