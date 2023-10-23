package kr.sparta.handler;

import kr.sparta.ui.AddToBasketConfirmUi;

public class BasketHandler {
    private AddToBasketConfirmUi addToBasketConfirmUi = AddToBasketConfirmUi.getInstance();
    public void handle(int choice) {
        //Product product = 서비스 그냥 만들자. 그리고 getProductById
        addToBasketConfirmUi.printPurchasePage(//product);
        int choice = addToBasketConfirmUi.getNumber();
        //여기서 바스켓 ui로 일시키기.
        while(true) {
            switch() {
                case 1 : //그러면 바스켓 ui의 add매소드 실행.

                case 2: //메인으로 돌아가기.
                //와일문 브레이크.
            }
        }
    }
    public void printMyBasket() {
        //바스켓 핸들러는 말그대로 장바구니와 관련된 작업, 데이터를 다루는 클래스이다.
        // 메인에서 장바구니보기 버튼을 눌렀을 때 호출시킬 메소드.
    }
}
