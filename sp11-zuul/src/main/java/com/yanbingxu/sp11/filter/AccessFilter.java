package com.yanbingxu.sp11.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.yanbingxu.web.util.JsonResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yuanzhibx
 * @Date 2020-08-05
 */
@Component
public class AccessFilter extends ZuulFilter {

    /**
     * 过滤器的类型:
     * 前置, 后置, 路由, 错误
     *
     * @return
     */
    @Override
    public String filterType() {
        // 前置过滤器
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器添加的顺序号
     *
     * @return 6 加到第六个位置
     */
    @Override
    public int filterOrder() {
        return 6;
    }

    /**
     * 针对当前请求进行判断
     * 判断当前请求是否要执行过滤器的过滤代码
     * 如果访问 item-service 要检查权限
     * 如果访问其他服务, 则不检查权限, 直接访问
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext c = RequestContext.getCurrentContext();
        // 获得当前请求的服务 id
        String serviceId = (String) c.get(FilterConstants.SERVICE_ID_KEY);
        String itemServiceId = "item-service";
        if (serviceId.equals(itemServiceId)) {
            // 执行权限过滤
            return true;
        }
        // 跳过过滤代码不执行
        return false;
    }

    /**
     * 过滤代码
     * 对用户权限进行检查
     *
     * @return zuul 过度设计, 返回值在现在的版本中没有使用
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext c = RequestContext.getCurrentContext();
        HttpServletRequest request = c.getRequest();
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            // 没有 token, 阻止继续调用
            c.setSendZuulResponse(false);

            // 发送提示, 提醒用户没有登录
            c.setResponseStatusCode(JsonResult.NOT_LOGIN);
            c.setResponseBody(JsonResult.err().code(JsonResult.NOT_LOGIN).msg("NOT_LOGIN!!!").toString());
        }
        return null;
    }

}
