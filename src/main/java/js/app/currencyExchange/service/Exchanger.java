package js.app.currencyExchange.service;

import js.app.currencyExchange.dto.Request;
import js.app.currencyExchange.dto.Response;

public interface Exchanger {

    public Response exchange(Request request);
}
