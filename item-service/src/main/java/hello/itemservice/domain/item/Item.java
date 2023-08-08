package hello.itemservice.domain.item;

import lombok.Data;

@Data //큰 프로젝트에서는 이렇게 롬복 데이터 애노테이션으로 붙여 사용하면 안된다...
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
