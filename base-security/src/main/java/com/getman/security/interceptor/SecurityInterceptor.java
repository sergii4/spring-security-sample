package com.getman.security.interceptor;

import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Security interceptor used to provide thymeleaf templates with current user authentication
 * details.
 *
 */
@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        if (modelAndView != null) {
            FilterInvocation filterInvocation =
                new FilterInvocation(request, response,
                                     (rq, rs) -> {
                                         throw new UnsupportedOperationException();
                                     });

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null) {
                WebSecurityExpressionRoot
                    sec = new WebSecurityExpressionRoot(authentication, filterInvocation);
                sec.setTrustResolver(new AuthenticationTrustResolverImpl());
                modelAndView.getModel().put("sec", sec);
            }
        }
    }
}