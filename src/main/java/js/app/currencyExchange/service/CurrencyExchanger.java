package js.app.currencyExchange.service;

import js.app.currencyExchange.dto.Request;
import js.app.currencyExchange.dto.Response;
import js.app.currencyExchange.exception.NoSuchCurrencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CurrencyExchanger implements Exchanger {

    private NbpData nbpData;

    @Autowired
    public CurrencyExchanger(NbpData nbpData) {
        this.nbpData = nbpData;
    }

    @Override
    public Response exchange(Request request) {

        String sourceCode = request.getSourceCurrencyCode().toUpperCase();
        String targetCode = request.getTargetCurrencyCode().toUpperCase();

        if (nbpData.getRate(sourceCode) == null) throw new NoSuchCurrencyException();
        if (nbpData.getRate(targetCode) == null) throw new NoSuchCurrencyException();

        BigDecimal amount = new BigDecimal(request.getAmount());

        BigDecimal sourceMid = nbpData.getRate(sourceCode);
        BigDecimal targetMid = nbpData.getRate(targetCode);

        BigDecimal targetAmount = amount.multiply(sourceMid).divide(targetMid, 2, RoundingMode.HALF_UP);

        return new Response(targetAmount.toString(), targetCode, amount.toString(), sourceCode);
    }
}
