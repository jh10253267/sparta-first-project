package kr.sparta.domain;

import java.util.List;

public class Basket {
    private List<Product> basket;
    private int totalBasketPrice;

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
        System.out.println("장바구니에 추가되었습니다.");
    }

    public List<Product> getBasket() {
        return basket;
    }

    public void clearBasket() {
        basket.clear();
    }

    public int getTotalBasketPrice() {
        totalBasketPrice = 0;
        for(Product p : basket) {
            totalBasketPrice += p.getPrice() * p.getOrderCount();
        }
        return totalBasketPrice;
    }
    public boolean isEmpty() {
        return basket.isEmpty();
    }
}
