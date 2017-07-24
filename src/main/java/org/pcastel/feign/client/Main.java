package org.pcastel.feign.client;

public class Main {

    public static void main(String[] args) {

        final CatService catService = new CatService();
        catService.playWithCats();
        
    }

    

}
