package js.app.currencyExchange.nbpApi;

import lombok.Data;

import java.util.List;

@Data
public class NbpTable {

    private String table;
    private String no;
    private String effectiveDate;
    private List<NbpRate> rates;
}
