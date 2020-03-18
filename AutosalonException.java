/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.util;

/**
 *
 * @author TRTANJ
 */
public class AutosalonException extends Exception{
    
    private String poruka;

    public AutosalonException(String poruka) {
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }

    

  
    
}
