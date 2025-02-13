package com.kodilla.stream.Project_7_4.invoice.simple;

import java.util.Objects;

public final class SimpleProduct {
    private final String productName;
    private final double productPrice;

    public SimpleProduct(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SimpleProduct that)) return false;
        return Double.compare(productPrice, that.productPrice) == 0 && Objects.equals(productName, that.productName);
    }
}
