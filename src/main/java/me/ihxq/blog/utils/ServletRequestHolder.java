package me.ihxq.blog.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SuppressWarnings("unused")
@Component
@RequestScope
public class ServletRequestHolder {
    @Resource
    private HttpServletRequest servletRequest;

    @Resource
    private HttpSession session;

    public ServletRequest getServletRequest() {
        return servletRequest;
    }

    public HttpSession getSession() {
        return session;
    }

    public String getHeader(String name) {
        return servletRequest.getHeader(name);
    }

    public <T> T getAttributeFromSession(String name, Class<T> attributeClass) {
        Object sourceValue = session.getAttribute(name);
        if (sourceValue == null) {
            return null;
        }
        Class aClass = sourceValue.getClass();
        do {
            if (aClass.equals(attributeClass)) {
                //noinspection unchecked
                return (T) sourceValue;
            }
        } while ((aClass = aClass.getSuperclass()) != null);
        return null;
    }
}
