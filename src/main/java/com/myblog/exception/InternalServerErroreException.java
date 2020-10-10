package com.myblog.exception;

        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)////自定义服务器错误处理异常,会跳转到500页面
public class InternalServerErroreException extends RuntimeException {
    public InternalServerErroreException() {
        super();
    }

    public InternalServerErroreException(String message) {
        super(message);
    }

    public InternalServerErroreException(String message, Throwable cause) {
        super(message, cause);
    }

}
