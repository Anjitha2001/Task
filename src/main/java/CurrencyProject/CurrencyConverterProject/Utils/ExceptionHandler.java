package CurrencyProject.CurrencyConverterProject.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import CurrencyProject.CurrencyConverterProject.Exception.CurrencyNotFoundException;
import CurrencyProject.CurrencyConverterProject.Exception.ExternalApiException;

@RestControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<String> handleCurrencyNotFound(CurrencyNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ExternalApiException.class)
    public ResponseEntity<String> handleExternalApiError(ExternalApiException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(ex.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + ex.getMessage());
    }
}




