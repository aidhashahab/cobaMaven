/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valensi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author user
 */
public class ConversionMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     String url ="https://openexchangerates.org/api/latest.json?app_id=31de5d956d1146f798d3b0bbf1890c67"; //ambil data
        RestTemplate resttemplate = new RestTemplate();
        LatestConversion latest = resttemplate.getForObject(url, LatestConversion.class);
        
        System.out.println("Base Currency: "+latest.getBase());
        System.out.println("Konversi tanggal: "+latest.getLatestDate());
        System.out.println("$1 USD = "+latest.getRates().get("IDR"));
        
    }
    
}
