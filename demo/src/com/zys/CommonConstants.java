package com.zys;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dinkfamily
 * @date 5/7/2021 2:14 PM
 * @description:
 */
public class CommonConstants {
    public static final List<String> PROVINCE_CODE_LIST= Arrays.asList(ProvinceEnum.values()).stream().filter(s->!s.equals(ProvinceEnum.ZONGBU)).map(s->s.getCode()).collect(Collectors.toList());
    public static final String SKIP_ENVIRONMENT = "dev" /*",test"*/;
    public static final String GATEWAY_INTERFACE_SKIP_ENVIRONMENT = "dev,test";
    public static final String L_CHANNEL_NAME = "一级电渠";
    public static final String VERSION ="1";
    public static final String environmentProfileKey = "spring.profiles.active";
    public static final String PHONE_PATTERN = "^[1][3-9][0-9]{9}$";//手机号校验正则

}
