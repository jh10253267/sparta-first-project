package kr.sparta.domain;

import java.util.List;

public class Basket {
    private List<Product> basket;

    public Basket(List<Product> basket) {
        this.basket = basket;
    }

    public void addProduct(Product product) {
        boolean duplicated = false;
        for(Product p : basket) {
            if(p.getId() == product.getId()) {
                duplicated = true;
                p.plusOrderCount();
                break;
            }
        }
        if(!duplicated) {
            basket.add(product);
        }
    }

    public void initOrderCount() {
        for (Product p : basket) {
            p.initOrderCount();
        }
    }

    public List<Product> getBasket() {
        return basket;
    }

    public void printBasket() {
        for (Product p : basket) {
            System.out.println(p);
            System.out.println(p.getOrderCount());
        }
    }
}
