import java.util.*;

public class Cart  {
    Map<String, Integer> items = new HashMap<>();

    void showItems() {
        System.out.println("장바구니 리스트 :");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue()+"개");
        }

    }

    void addProduct(Set<Product> productSet, String name, int count) {
        Optional<Product> product = productSet.stream()
                .filter(p -> p.getName().equals(name))
                .findAny();

        if(product.isEmpty()){
            System.out.println("상품 목록에서 선택하세요");
            return;
        }

        items.put(name, count);
    }

    void removeProduct(String name, int count) {
        Optional<String> product = items.keySet().stream()
                .filter(p -> p.equals(name))
                .findAny();

        if(product.isEmpty()){
            System.out.println("장바구니에서 선택하세요");
            return;
        }

        if(items.get(name) > count) {
            items.replace(name, items.get(name) - count);
        } else {
            items.remove(name);
        }
    }
}
