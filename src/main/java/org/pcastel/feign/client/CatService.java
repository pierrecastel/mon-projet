/*
 * Copyright (c) 2012, vsc-technologies - www.voyages-sncf.com
 * All rights reserved.
 * 
 * Les presents codes sources sont proteges par le droit d'auteur et 
 * sont la propriete exclusive de VSC Technologies.
 * Toute representation, reproduction, utilisation, exploitation, modification, 
 * adaptation de ces codes sources sont strictement interdits en dehors 
 * des autorisations formulees expressement par VSC Technologies, 
 * sous peine de poursuites penales. 
 * 
 * Usage of this software, in source or binary form, partly or in full, and of
 * any application developed with this software, is restricted to the
 * customer.s employees in accordance with the terms of the agreement signed
 * with VSC-technologies.
 */
package org.pcastel.feign.client;

import static java.time.Instant.now;
import java.util.List;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;

/**
 */
public class CatService {
    
    
    private String url;
    private CatClient client;

    public CatService() {

        url = "http://localhost:8080";

        // Get Client
        client = Feign.builder()
                // Transform response body
                .decoder(new GsonDecoder())
                        // Create request body
                .encoder(new GsonEncoder())
                        // Add custom header
                .requestInterceptor(template -> template.header("Date", now().toString()))
                        // Tips debug lite
                .requestInterceptor(System.out::println)
                        // Tips debug logger
                .logLevel(Logger.Level.FULL)
                .logger(new Slf4jLogger())
                        // Create instance
                .target(CatClient.class, url);
    }

    public void playWithCats() {

        // Find All
        List<Cat> cats = client.findAll();
        cats.forEach(System.out::println);
        System.out.println();

        
    }
}
