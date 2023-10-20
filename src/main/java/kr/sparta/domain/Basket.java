package kr.sparta.domain;

import java.util.List;

public class Basket {
    private List<Product> basket;
    private int totalBasketPrice;

    public Basket(List<Product> basket) {
        this.basket = basket;
    }

    //객체들끼리 비교할 땐 equals메소드가 있지만 상품 자체에 오더 카운트 필드를 선언해버려서
    //같은 객체로 보여도 필드값이 다르기 때문에 같은 객체가 아니게 되어버린다.
    //그래서 오더카운트가 2가 넘어가면 새로운 객체로 보기 때문에 중복인 걸 인식을 못한다는 문제가생김.
    //생각해본 방법은 오더 카운트를 다른 방법으로 카운팅하는 것.
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
