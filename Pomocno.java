/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.util;

import hr.autosalon.autosalon.controller.ObradaKupac;
import hr.autosalon.autosalon.controller.ObradaProdavac;
import hr.autosalon.autosalon.controller.ObradaVozilo;
import hr.autosalon.autosalon.model.Kupac;
import hr.autosalon.autosalon.model.Prodaja;
import hr.autosalon.autosalon.model.Prodavac;
import hr.autosalon.autosalon.model.Vozilo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author TRTANJ
 */
public class Pomocno {

    private static Kupac kupac;
    private static Prodavac prodavac;

   
    
    public static void pocetniInsert(){
        
        
        
        Kupac kupac = new Kupac();
        kupac.setIme("Dario");
        kupac.setPrezime("Trtanj");
        kupac.setOib("63612978880");
        kupac.setEmail("trtanjd@gmail.com");
        kupac.setBrojTelefona("098683861");
        kupac.setBrojUgovora("369");
        
        ObradaKupac obradaKupac = new ObradaKupac(kupac) {};
        try {
            obradaKupac.create();
            } catch (AutosalonException ex) {
                System.out.println(ex.getPoruka());
        }
    
        
        Prodavac prodavac = new Prodavac();
        prodavac.setIme("Ivan");
        prodavac.setPrezime("Ivanov");
        prodavac.setOib("77995289480");
        prodavac.setEmail("ivanov@gmail.com");
        prodavac.setIban("HR5523600003222222223");
        
        ObradaProdavac obradaProdavac = new ObradaProdavac();
        try {
            obradaProdavac.create();
            } catch (AutosalonException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
        
        Vozilo vozilo = new Vozilo();
        vozilo.setMarka("Volkswagen");
        vozilo.setModel("Golf");
        vozilo.setGodiste("godište");
        vozilo.setKilometraza("kilometraza");
        vozilo.setCijena(new BigDecimal(10000));
        vozilo.setUvoz("true");
        
        Prodaja prodaja = new Prodaja();
        prodaja.setKupac(kupac);
        prodaja.setProdavac(prodavac);
        prodaja.setVozilo(vozilo);
        
        /*   vozilo.getProdaje().add(prodaja);*/
        
        
        ObradaVozilo obradaVozilo = new ObradaVozilo(vozilo);
        try {
            obradaVozilo.create();
        } catch (AutosalonException ex) {
        }
        
        
        
        
        }
        
        
        
    public static boolean isOibValjan(String oib) {
        
        if(oib==null){
            return false;
        }
            
            

        if (oib.length() != 11)
            return false;

        try {
            Long.parseLong(oib);
        } catch (NumberFormatException e) {
            return false;
        }

        int a = 10;
        for (int i = 0; i < 10; i++) {
            a = a + Integer.parseInt(oib.substring(i, i+1));
            a = a % 10;
            if (a == 0)
                a = 10;
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        if (kontrolni == 10)
            kontrolni = 0;

        return kontrolni == Integer.parseInt(oib.substring(10));
    }
    
}
         
        
    
        
   

    

