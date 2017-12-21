package com.valensi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class CurrencyMain {

    public static void main(String[] args) {
        String url ="https://openexchangerates.org/api/currencies.json"; //ambil data
        RestTemplate resttemplate = new RestTemplate();
        List<Currency> cList = new ArrayList<>();
        Map<String,String> currencies =
                resttemplate.getForObject(url, Map.class);
        
        for (Map.Entry<String, String> entry : currencies.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+":"+value);
            Currency cur = new Currency(key, value);
            cList.add(cur);
        }
        System.out.println("Jumlah mata uang dunia :"+cList.size());
    }
    
}
