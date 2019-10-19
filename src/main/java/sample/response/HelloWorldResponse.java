package sample.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HelloWorldResponse {
    private Integer status;
    private String message;
}
