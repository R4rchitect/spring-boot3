package com.teamra.appwswhisper.infrastructure.config.logging.filter;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;

import io.micrometer.common.util.StringUtils;

import org.slf4j.MDC;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RequestResponseLoggingFilter implements Filter {

    //private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
      try {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String traceId = UUID.randomUUID().toString().replace("-", "");
        if(!StringUtils.isEmpty(req.getHeader("trace-id")) || req.getHeader("trace-id")!=null){
        MDC.put("trace-id",req.getHeader("trace-id"));
        traceId = req.getHeader("trace-id");
        } else MDC.put("trace-id", traceId);
        log.info("traceId: "+ traceId);
        log.info("Logging Request "+req.getMethod()+": "+req.getRequestURI());
        chain.doFilter(request, response);
        log.info("Logging Response: " +res.getContentType());
      } finally {
        MDC.remove("trace-id");
      }
    }
}
