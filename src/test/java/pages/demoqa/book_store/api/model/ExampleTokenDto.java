package pages.demoqa.book_store.api.model;


import lombok.Data;

import java.util.Date;

@Data
public class ExampleTokenDto {
    public String token;
    public Date expires;
    public String status;
    public String result;
}
