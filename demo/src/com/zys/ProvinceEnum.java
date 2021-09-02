package com.zys;


/**
 * @author dinkfamily
 * @date 5/7/2021 11:11 AM
 * @description:
 */
public enum ProvinceEnum {
    ZONGBU("000","总部"),
    NEIMENGGU("471","内蒙古"),
    BEIJING("100","北京"),
    TIANJIN("220","天津"),
    SHANDONG("531","山东"),
    HEBEI("311","河北"),
    SHANXI("351","山西"),
    ANHUI("551","安徽"),
    SHANGHAI("210","上海"),
    JIANGSU("250","江苏"),
    ZHEJIANG("571","浙江"),
    FUJIAN("591","福建"),
    HAINAN("898","海南"),
    GUANGDONG("200","广东"),
    GUANGXI("771","广西"),
    QINGHAI("971","青海"),
    HUBEI("270","湖北"),
    HUNAN("731","湖南"),
    JIANGXI("791","江西"),
    HENAN("371","河南"),
    XIZANG("891","西藏"),
    SICHUAN("280","四川"),
    CHONGQING("230","重庆"),
    SHAANXI("290","陕西"),
    GUIZHOU("851","贵州"),
    YUNNAN("871","云南"),
    GANSU("931","甘肃"),
    NINGXIA("951","宁夏"),
    XINJIANG("991","新疆"),
    JILIN("431","吉林"),
    LIAONING("240","辽宁"),
    HEILONGJIANG("451","黑龙江");

    private String name;
    private String code;

    ProvinceEnum(String code, String name){
        this.code=code;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ProvinceEnum{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public static ProvinceEnum fromValue(String value) {
        for (ProvinceEnum provinceEnum : values()) {
            if (provinceEnum.getCode().equalsIgnoreCase(value)) {
                return provinceEnum;
            }
        }
        throw new IllegalArgumentException();
    }
}
