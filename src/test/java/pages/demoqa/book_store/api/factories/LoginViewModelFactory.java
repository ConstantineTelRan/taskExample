package pages.demoqa.book_store.api.factories;

import pages.demoqa.book_store.api.model.LoginViewModelDto;

public class LoginViewModelFactory {

    public LoginViewModelDto getObject(String userName, String password) {
        return LoginViewModelDto.builder()
                .userName(userName)
                .password(password)
                .build();
    }

    public LoginViewModelDto getObjectWithAdmin() {
        return LoginViewModelDto.builder()
                .userName("admin22")
                .password("Qwerty@12345")
                .build();
    }

}
