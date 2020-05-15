package js.app.currencyExchange.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class Request {
    @Pattern(regexp = "[0-9]+[,.]?[0-9]{0,2}", message = "Provided amount is not valid.")
    private String amount;
    @Pattern(regexp = "[A-Za-z]{3}", message = "Source currency code should consist of 3 characters.")
    private String sourceCurrencyCode;
    @Pattern(regexp = "[A-Za-z]{3}", message = "Target currency code should consist of 3 characters.")
    private String targetCurrencyCode;

    public Request() {
    }

    public Request(String amount, String sourceCurrencyCode, String targetCurrencyCode) {
        this.amount = amount;
        this.sourceCurrencyCode = sourceCurrencyCode;
        this.targetCurrencyCode = targetCurrencyCode;
    }

}
