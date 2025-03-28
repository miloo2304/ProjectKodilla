package com.kodilla.stream.Project_7_4.invoice.simple;

public final class SimpleItem {
    private final SimpleProduct product;
    private final double quantity;
    public double result = 0;

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
        result =  product.getProductPrice() * quantity;
        System.out.println(result);
        return result;
    }
}
