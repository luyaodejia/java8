package com.xu;

import java.util.Optional;

/**
 * @author xudenghui
 * @create 2021-02-04 9:26
 **/
public class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance(){
        return  insurance;
    }
}
