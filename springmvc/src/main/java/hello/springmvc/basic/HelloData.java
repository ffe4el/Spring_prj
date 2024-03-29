package hello.springmvc.basic;

import lombok.Data;

@Data
public class HelloData {
    /**
     * 롬복 @Data
     * @Getter , @Setter , @ToString , @EqualsAndHashCode , @RequiredArgsConstructor 를
     * 자동으로 적용해준다.
     */
    private String username;
    private int age;
}
