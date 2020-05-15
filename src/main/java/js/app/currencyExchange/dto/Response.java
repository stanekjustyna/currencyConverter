package js.app.currencyExchange.dto;

import lombok.Data;

@Data
public class Response {

    private String targetAmount;
    private String targetCurrency;
    private String sourceAmount;
    private String sourceCurrency;

    public Response() {
    }

    public Response(String targetAmount, String targetCurrency, String sourceAmount, String sourceCurrency) {
        this.targetAmount = targetAmount;
        this.targetCurrency = targetCurrency;
        this.sourceAmount = sourceAmount;
        this.sourceCurrency = sourceCurrency;
    }
}
