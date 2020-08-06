package com.yanbingxu.sp11.fallback;

import com.yanbingxu.web.util.JsonResult;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Yuanzhibx
 * @Date 2020-08-06
 */
@Component
public class ItemFallback implements FallbackProvider {

    /**
     * 当前降级类, 对那个服务有效
     *
     * @return 返回 "item-service" 对商品服务有效, 返回 "*" 或 null 对所有服务有效
     */
    @Override
    public String getRoute() {
        return "item-service";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return response();
    }

    private ClientHttpResponse response() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }
            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }
            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }
            @Override
            public void close() {

            }
            @Override
            public InputStream getBody() throws IOException {
                // JsonResult: {code:401, msg:"获取商品列表失败", data:null}
                String r = JsonResult.err().msg("获取商品列表失败").toString();
                ByteArrayInputStream in = new ByteArrayInputStream(r.getBytes());
                return in;
            }
            @Override
            public HttpHeaders getHeaders() {
                // Content-Type: application/json
                HttpHeaders h = new HttpHeaders();
                h.setContentType(MediaType.APPLICATION_JSON);
                return h;
            }
        };
    }

}
