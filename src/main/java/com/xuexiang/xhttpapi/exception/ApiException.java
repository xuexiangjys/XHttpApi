package com.xuexiang.xhttpapi.exception;

/**
 * @author xuexiang
 * @since 2018/8/6 下午3:11
 */
public class ApiException extends Exception {

    /**
     * 错误的code码
     */
    private int mCode;

    public ApiException(String message, int code) {
        super(message);
        mCode = code;
    }

    public ApiException(Throwable e, int code) {
        super(e);
        mCode = code;
    }

    public int getCode() {
        return mCode;
    }

    /**
     * 约定异常
     */
    public static class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = 5000;

        /**
         * 文件存储失败
         */
        public static final int FILE_STORE_ERROR = UNKNOWN + 1;
    }
}
