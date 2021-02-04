package com.xu.optional;

import java.util.Optional;

/**
 * @author xudenghui
 * @create 2021-01-06 9:55
 **/
public class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance(){
        return insurance;
    }

}
