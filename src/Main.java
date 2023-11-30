import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();
        productSet.add(new Product("pencil", 1000));
        productSet.add(new Product("book", 3000));
        productSet.add(new Product("computer", 10000));
        productSet.add(new Product("pencil", 1000));

        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for(Product product : productSet){
            System.out.println(product.getName() +" : "+ product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart();

        // 장바구니에 추가
        System.out.println("추가할 상품의 이름과 개수를 입력하세요");
        System.out.println("0 0 입력시 끝, 1 1 입력시 장바구니 조회");
        while(true) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            if(name.equals("0") && count == 0) break;
            if(name.equals("1") && count == 1) myCart.showItems();

            myCart.addProduct(productSet, name, count);
        }

        // 장바구니 출력
        myCart.showItems();


        // 장바구니에서 제거
        System.out.println("제거할 상품의 이름과 개수를 입력하세요");
        System.out.println("0 0 입력시 끝, 1 1 입력시 장바구니 조회");
        while(true) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            if(name.equals("0") && count == 0) break;
            if(name.equals("1") && count == 1) myCart.showItems();

            myCart.removeProduct(name, count);
        }

        // 장바구니 출력
        myCart.showItems();

    }
}