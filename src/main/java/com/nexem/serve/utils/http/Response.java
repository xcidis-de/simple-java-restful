package com.nexem.serve.utils.http;

import org.springframework.http.HttpEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.regex.Pattern;

public class Response extends HttpEntity implements Serializable {
    private static final long serialVersionUID = 1990l;

    public Response(Object data, ResponseInfo info) {
        super(data, info.asHeaders());
    }
    public Response(Object data, String code) {
        super(data, resolveResponse(code).asHeaders());
    }

    public Response(String code) {
        super(null, resolveResponse(code).asHeaders());
    }

    public static ResponseInfo resolveResponse(String code) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String requestUri = request.getRequestURI();
        String requestMethod = request.getMethod();

        StringBuilder sb = new StringBuilder();
        sb.append(requestMethod).append(" to route ").append(requestUri);

        Boolean success = Pattern.matches("2\\d\\d", code);

        if (success) {
            sb.append(" was successful.");
            return new ResponseInfo(sb.toString(), code);
        }

        Boolean forbidden = Pattern.matches("4\\d\\d", code);

        if (forbidden) {
            sb.append(" failed due to client error.");
            return new ResponseInfo(sb.toString(), code);
        }

        Boolean errored = Pattern.matches("5\\d\\d", code);

        if (errored) {
            sb.append(" failed due to internal error");
            return new ResponseInfo(sb.toString(), code);
        }

        return null;
    }
}