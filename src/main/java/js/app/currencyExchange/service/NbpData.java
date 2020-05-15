package js.app.currencyExchange.service;

import js.app.currencyExchange.nbpApi.NbpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class NbpData {

    private NbpClient nbpClient;
    private Map<String, BigDecimal> nbpData;

    @Autowired
    public NbpData(NbpClient nbpClient) {
        this.nbpClient = nbpClient;
        this.nbpData = nbpClient.getNbpData();
    }

    public BigDecimal getRate(String code) {
        return nbpData.get(code);
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void updateCurrencyRates() {
        this.nbpData = nbpClient.getNbpData();
    }
}

