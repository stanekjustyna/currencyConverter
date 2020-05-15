package js.app.currencyExchange.controller;

import js.app.currencyExchange.dto.Request;
import js.app.currencyExchange.dto.Response;
import js.app.currencyExchange.service.CurrencyExchanger;
import js.app.currencyExchange.service.Exchanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ExchangeController {

    private Exchanger exchanger;

    @Autowired
    public ExchangeController(CurrencyExchanger exchanger) {
        this.exchanger = exchanger;
    }

    @PostMapping(path = "/exchange", consumes ="application/json", produces = "application/json")
    public Response exchangeCurrency(@RequestBody @Valid Request request) {
        return exchanger.exchange(request);
    }


}
