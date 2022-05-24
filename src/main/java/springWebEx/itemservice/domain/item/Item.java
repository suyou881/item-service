package springWebEx.itemservice.domain.item;

import lombok.Data;

@Data
//Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
//핵심 도메인 모델에 사용하기에는 @Data 는 굉장히 위험하다.
//그러나 예제니까 써본다.
//웬만하면 하나씩 찍어서 사용하는게 좋다. ex) @Getter, @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
