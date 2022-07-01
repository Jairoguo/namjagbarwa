package com.jairoguo.handler.response;

import com.jairoguo.common.result.Result;
import com.jairoguo.common.result.ResultBody;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.LinkedHashMap;

/**
 * @author Jairo Guo
 */

@RestControllerAdvice
public class ControllerResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        if (request.getHeaders().containsKey("type")) {
            return body;
        }

        if (body instanceof LinkedHashMap) {
            return body;
        }

        if (body instanceof ResultBody<?>) {
            return body;
        }

        if (returnType.getParameterType().isAssignableFrom(void.class)) {
            return Result.success();
        }

        if (body instanceof String) {
            return body;
        }

        return Result.success(body);
    }
}
