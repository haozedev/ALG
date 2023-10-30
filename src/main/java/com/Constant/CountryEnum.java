package com.Constant;

import lombok.Getter;

/**
 * @ClassName CountryEnum
 * @Description TODO
 * @Author ty-ChaiHaoZe
 * @Date 2022/5/28
 * @Version TODO
 * @History TODO
 **/
public enum CountryEnum {

    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏"),SEVEN(7,"秦");
    @Getter
    private Integer redCode;
    @Getter
    private String retMsg;

    CountryEnum(Integer redCode, String retMsg) {
        this.redCode = redCode;
        this.retMsg = retMsg;
    }

    public static CountryEnum forEach_CountryEnum(int index){

        CountryEnum[] myArray = CountryEnum.values();

        for (CountryEnum element : myArray) {
            if (index== element.getRedCode()){
                return element;
            }
        }
        return null;
    }
}
