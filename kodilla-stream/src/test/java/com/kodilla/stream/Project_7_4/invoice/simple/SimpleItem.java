package com.kodilla.stream.Project_7_4.invoice.simple;

public final class SimpleItem {
    private final SimpleProduct product;
    private final double quantity;

    public SimpleItem(SimpleProduct product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public SimpleProduct getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }
    public double getValue() {
        return product.getProductPrice() * quantity;
    }
}
