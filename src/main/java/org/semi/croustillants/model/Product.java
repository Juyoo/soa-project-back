package org.semi.croustillants.model;

/**
 * Created by raymo on 05/02/2017.
 */
public class Product {

    private String id;
    private String name;
    private String description;
    private Integer price;
    private Long quantity;
    private String image;
    private boolean available;

    public Product() {
    }

    public Product(final String id, final String name, final String description, final Integer price, final Long quantity, final String image, final boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }

    public boolean isAvailable() {
        return available;
    }
}
