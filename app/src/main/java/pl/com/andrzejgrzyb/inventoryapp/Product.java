package pl.com.andrzejgrzyb.inventoryapp;

/**
 * Created by Andrzej on 24.07.2017.
 */

public class Product {

    private String name;
    private String price;
    private int quantity;
    private String supplierName;
    private String supplierPhone;
    private String supplierEmail;
    private String image;

    public Product(String name, String price, int quantity, String supplierName, String supplierPhone, String supplierEmail, String image) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.supplierPhone = supplierPhone;
        this.supplierEmail = supplierEmail;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public String getImage() {
        return image;
    }
}
