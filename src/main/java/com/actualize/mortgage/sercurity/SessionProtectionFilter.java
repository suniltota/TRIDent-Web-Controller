package com.actualize.mortgage.sercurity;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class SessionProtectionFilter implements Filter {
    private static final Logger log = Logger.getLogger(SessionProtectionFilter.class);

    private String updateSession;

    @Autowired
    private SessionContext sessionContext;

    /**
     * @return the updateSession
     */
    public String getUpdateSession() {
        return updateSession;
    }

    /**
     * @param updateSession
     *            the updateSession to set
     */
    public void setUpdateSession(String updateSession) {
        this.updateSession = updateSession;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    static boolean isProtectedPath(List<String> protectedPaths, String requestedPath) {
        boolean protectedPath = false;

        if (null != protectedPaths) {
            protectedPath = protectedPaths.contains(requestedPath);
        }
        log.trace(String.format("isProtectedPath is: %b for requestedPath: %s", protectedPath, requestedPath));
        return protectedPath;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;

            if (httpRequest.getSession() == null || httpRequest.getSession().isNew() || sessionContext.getUserDetails() == null || updateSession.equals(httpRequest.getPathInfo())) {
                httpRequest.getSession().invalidate();
                httpRequest.getSession(true);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
