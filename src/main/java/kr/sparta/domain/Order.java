package kr.sparta.domain;

import java.util.List;

//일급컬렉션 써보기.
public class Order {

    private final List<Product> order;

    public Order(List<Product> order) {
        this.order = order;
    }

    public void addProduct(Product product) {
        this.order.add(product);
    }

    public List<Product> getOrder() {
        return order;
    }
    public void clear() {
        order.clear();
    }
}
