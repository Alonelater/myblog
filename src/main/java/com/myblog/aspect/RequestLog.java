package com.myblog.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class RequestLog {


    private String url;//请求路径
    private String ip;//IP地址
    private String classMethod;//调用的方法
    private Object[] args;//传递的参数
}
