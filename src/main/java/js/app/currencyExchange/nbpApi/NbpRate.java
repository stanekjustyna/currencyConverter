package js.app.currencyExchange.nbpApi;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NbpRate {

    private String currency;
    private String code;
    private BigDecimal mid;
}
