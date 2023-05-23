package pages.demoqa.book_store.api.factory;

import pages.demoqa.book_store.api.model.LoginViewDto;

public class LoginViewModelFactory implements BookStoreFactory{
    @Override
    public LoginViewDto getObject() {
        return LoginViewDto.builder()
                .userName("admin22")
                .password("Qwerty@12345")
                .build();
    }

    public LoginViewDto getObject(String userName, String password) {
        return LoginViewDto.builder()
                .userName(userName)
                .password(password)
                .build();
    }

}
