package js.app.currencyExchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NoSuchCurrencyException extends RuntimeException {
}
