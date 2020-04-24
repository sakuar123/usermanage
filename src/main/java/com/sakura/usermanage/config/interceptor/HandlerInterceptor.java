//package com.sakura.usermanage.config.interceptor;
//
//import com.sakura.usermanage.config.security.Permission;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class HandlerInterceptor extends HandlerInterceptorAdapter {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Permission permission = handlerMethod.getMethodAnnotation(Permission.class);
//            if (permission.noLogin()) {
//                return true;
//            }
//
//        }
//        return super.preHandle(request, response, handler);
//    }
//}
