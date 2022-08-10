package com.jairoguo.gateway.config;

import com.jairoguo.auth.api.AuthApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Jairo Guo
 */
@FeignClient(name = "auth-server")
public interface RoleApiService extends AuthApi {
}
