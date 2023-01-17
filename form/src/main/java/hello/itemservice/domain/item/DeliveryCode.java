package hello.itemservice.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * FAST: 빠른배송
 * NOrMAL: 일반 배송
 * SLOW: 느리 배송
 */
@Data
@AllArgsConstructor
public class DeliveryCode {

    private String code;
    private String displayName;
}
