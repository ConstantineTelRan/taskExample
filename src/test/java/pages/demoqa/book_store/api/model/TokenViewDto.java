package pages.demoqa.book_store.api.model;

import lombok.Data;

@Data
public class TokenViewDto {
    public String token;
    public String expires;
    public String status;
    public String result;
}
