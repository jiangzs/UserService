package com.jzs.user.domain;

/**
 * Created by jiangzs@gmail.com on 2017/4/7.
 */
public enum Currency {
    USD, EUR, RUB;

    public static Currency getDefault() {
        return USD;
    }
}
