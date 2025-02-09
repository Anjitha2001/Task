package CurrencyProject.CurrencyConverterProject.Controller;

import java.util.Map;
import CurrencyProject.CurrencyConverterProject.Model.*;
import CurrencyProject.CurrencyConverterProject.Service.CurrencyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/rates")
    public ResponseEntity<Map<String, Double>> getRates(@RequestParam(defaultValue = "USD") String base) {
        return ResponseEntity.ok(currencyService.getExchangeRates(base));
    }

    @PostMapping("/convert")
    public ResponseEntity<ConversionResponse> convertCurrency(@RequestBody ConversionRequest request) {
        double convertedAmount = currencyService.convertCurrency(request.getFrom(), request.getTo(), request.getAmount());
        return ResponseEntity.ok(new ConversionResponse(request.getFrom(), request.getTo(), request.getAmount(), convertedAmount));
    }
}
