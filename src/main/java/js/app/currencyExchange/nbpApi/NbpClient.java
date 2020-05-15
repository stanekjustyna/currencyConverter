package js.app.currencyExchange.nbpApi;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class NbpClient {

    private final WebClient client = WebClient.create("https://api.nbp.pl/api/exchangerates/tables");

    public Map<String, BigDecimal> getNbpData() {

        Collection<NbpTable> tableA = client
                .method(HttpMethod.GET)
                .uri("/A").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(NbpTable.class).collectList().block();

        Collection<NbpTable> tableB = client
                .method(HttpMethod.GET)
                .uri("/B").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(NbpTable.class).collectList().block();

        List<NbpRate> ratesA = tableA.stream().findAny().get().getRates();
        List<NbpRate> ratesB = tableB.stream().findAny().get().getRates();

        Map<String, BigDecimal> exchangeRates = Stream.concat(ratesA.stream(), ratesB.stream())
                                                .collect(Collectors.toMap(
                                                        NbpRate::getCode,
                                                        NbpRate::getMid
                                                ));
        exchangeRates.put("PLN", BigDecimal.valueOf(1).setScale(2));
        return exchangeRates;

    }
}
