package com.actualize.mortgage.sercurity;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author DWC
 * 
 *         See <a href=
 *         "http://stackoverflow.com/questions/16190699/automatically-add-header-to-every-response"
 *         >http://stackoverflow.com/questions/16190699</a> and <a href=
 *         "https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS"
 *         >https://developer.mozilla.org/en-US/docs/Web/HTTP/
 *         Access_control_CORS</a>
 */
public class CrossOriginResourceSharingFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = Logger.getLogger(CrossOriginResourceSharingFilter.class);
    static final String HTTP_METHOD_OPTIONS = "OPTIONS";
    static final String REQ_HEADER_ORIGIN = "Origin";
    static final String REQ_HEADER_ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";
    static final String RESP_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    static final String RESP_HEADER_ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    static final String RESP_HEADER_ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    static final String RESP_VALUES_ACCESS_CONTROL_ALLOW_METHODS = "GET, POST, PUT, DELETE";
    static final String RESP_HEADER_ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    static final String RESP_VALUES_ACCESS_CONTROL_ALLOW_HEADERS = "X-Requested-With,Origin,Content-Type, Accept";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String origin = request.getHeader(REQ_HEADER_ORIGIN);
        LOGGER.debug("originIsAllowed for "+origin);

        response.addHeader(RESP_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN, origin);
        LOGGER.debug("CORS pre-flight request, setting headers");
        response.addHeader(RESP_HEADER_ACCESS_CONTROL_ALLOW_METHODS, RESP_VALUES_ACCESS_CONTROL_ALLOW_METHODS);
        response.addHeader(RESP_HEADER_ACCESS_CONTROL_ALLOW_HEADERS, RESP_VALUES_ACCESS_CONTROL_ALLOW_HEADERS);
        response.addHeader(RESP_HEADER_ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        filterChain.doFilter(request, response);
       
        LOGGER.trace("doFilterInternal completed");
    }
}
