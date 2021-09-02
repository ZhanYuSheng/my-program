package com.zys;

import java.util.regex.Pattern;

public class PatternTest {

    public static void main(String[] args) {
        Pattern p = Pattern.compile(CommonConstants.PHONE_PATTERN);
        if(!p.matcher("aaa").find()){
//                throw new IllegalArgumentException("请填写正确的办理电话呦");
            System.out.println("请填写正确的办理电话呦");
        }
    }

}
