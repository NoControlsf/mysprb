package com.mysprb.mysprb.api.feign;

import com.mysprb.mysprb.logic.feign.FeignFallback;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "open",url = "${my.host}",fallback = FeignFallback.class)
public interface FeignService {

}
