package pages.demoqa.book_store.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;


@Data
@Builder
public class LoginViewModelDto {
    private String userName;
    private String password;
}
