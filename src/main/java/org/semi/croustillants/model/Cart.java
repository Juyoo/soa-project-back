package org.semi.croustillants.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by raymo on 05/02/2017.
 */
public class Cart {
    private List<ProductWithQty> productWithQties = new ArrayList<>();

    public Cart() {
    }

    public List<ProductWithQty> getProductWithQties() {
        return Collections.unmodifiableList(productWithQties);
    }

    public void addProductWithQty(final ProductWithQty productWithQty) {
        this.productWithQties.add(productWithQty);
    }

    public static class ProductWithQty {
        private Product product;
        private Integer quantity;

        public ProductWithQty() {
        }

        public ProductWithQty(final Product product, final Integer quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public Integer getQuantity() {
            return quantity;
        }
    }

}
