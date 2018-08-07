/*
 * Copyright (C) 2018 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xuexiang.xhttpapi.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xuexiang
 * @since 2018/8/7 下午5:23
 */
public class CustomApiResult<T> extends ApiResult<T> {

    @JsonProperty(value = "errorCode")
    private int errorCode;
    @JsonProperty(value = "errorInfo")
    private String errorInfo;
    @JsonProperty(value = "result")
    private T result;
    @JsonProperty(value = "timeStamp")
    private long timeStamp;

    @JsonIgnore
    public int getErrorCode() {
        return errorCode;
    }

    @JsonIgnore
    public CustomApiResult<T> setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    @JsonIgnore
    public String getErrorInfo() {
        return errorInfo;
    }

    @JsonIgnore
    public CustomApiResult<T> setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
        return this;
    }

    @JsonIgnore
    public T getResult() {
        return result;
    }

    @JsonIgnore
    public CustomApiResult<T> setResult(T result) {
        this.result = result;
        return this;
    }

    @JsonIgnore
    public long getTimeStamp() {
        return timeStamp;
    }

    @JsonIgnore
    public CustomApiResult<T> setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "errorCode='" + errorCode + '\'' +
                ", errorInfo='" + errorInfo + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", result=" + result +
                '}';
    }
}
