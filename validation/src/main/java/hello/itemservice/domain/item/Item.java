package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >=10000", message = "총 합이 10000원 넘게 입력해주세요.") 권장 하지 않는다 기능이 약하다.
public class Item {


//    @NotNull(groups = UpdateCheck.class)
    private Long id;

//    @NotBlank(message = "공백x", groups = {SaveCheck.class, UpdateCheck.class})
    private String itemName;

//    @NotNull(groups = {UpdateCheck.class, SaveCheck.class})
//    @Range(min = 1_000, max=1_000_000, groups = {SaveCheck.class, UpdateCheck.class})
    private Integer price;

//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Max(value = 9_999, groups = {SaveCheck.class})
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
