package com.nexem.serve.utils.http;

import org.springframework.util.MultiValueMap;

import java.io.Serializable;
import java.util.*;

public class ResponseInfo implements Serializable {
    private static final long serialVersionUID = 1990l;

    public String message = null;
    public String code = null;
    public String callback = null;

    public ResponseInfo(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public ResponseInfo(String message, String code, String callback) {
        this.message = message;
        this.code = code;
        this.callback = callback;
    }

    public MultiValueMap<String, Object> asHeaders() {
        MultiValueMap<String, Object> headers = new Headers();

        List codes = new ArrayList();
        List messages = new ArrayList();
        List routes = new ArrayList();
        codes.add(this.code);
        messages.add(this.message);
        routes.add(this.callback);

        headers.put("responseCode", codes);
        headers.put("message", messages);
        headers.put("callback", routes);
        return headers;
    }
}
