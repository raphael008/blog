package com.github.raphael008.auth;

import com.github.raphael008.auth.manager.LoginManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class AuthAspect {

    @Autowired
    private LoginManager loginManager;

    @Pointcut(value = "@annotation(com.github.raphael008.auth.Auth)")
    public void authAspect() {

    }

    @Around(value = "authAspect() && @annotation(auth)")
    public Object around(ProceedingJoinPoint point, Auth auth) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

            Boolean isAuthorized = loginManager.checkAuth(request, auth.value());
            if (!isAuthorized) {
                throw new RuntimeException("请登录后重试。");
            }

            Object result = point.proceed();
            return result;
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable.getCause());
        }
    }
}
