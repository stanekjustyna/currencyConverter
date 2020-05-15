package js.app.currencyExchange.controller;

import js.app.currencyExchange.exception.NoSuchCurrencyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ExchangeExceptionHandler {

    private static final String NO_SUCH_CURRENCY = "No such currency found in NBP data table.";

    @ExceptionHandler(NoSuchCurrencyException.class)
    public HashMap<String, String> handleNoSuchCurrencyException(NoSuchCurrencyException e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", NO_SUCH_CURRENCY);
        response.put("error", e.getClass().getSimpleName());
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HashMap<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", e.getMessage());
        response.put("error", e.getClass().getSimpleName());
        return response;
    }
}
