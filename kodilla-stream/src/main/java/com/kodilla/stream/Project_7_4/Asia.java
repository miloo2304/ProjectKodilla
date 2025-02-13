package com.kodilla.stream.Project_7_4;

import java.math.BigDecimal;

public final class Asia implements SandStorage {

    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("98765432101234567890");
        return sandQuantity;
    }
}