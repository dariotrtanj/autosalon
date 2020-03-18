/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.controller;

import hr.autosalon.autosalon.model.Prodavac;
import hr.autosalon.autosalon.util.AutosalonException;
import java.util.List;


/**
 *
 * @author TRTANJ
 */
public class ObradaProdavac extends Obrada<Prodavac>{

    private Object IBANValidator;
    
    public ObradaProdavac(Prodavac entitet) {
        super(entitet);
    }

    public ObradaProdavac() {
        super();
    }

   
    protected void kontrolaCreate() throws AutosalonException {
        super.kontrolaCreate();
        kontrolaIban();
        
    }

    @Override
    protected void kontrolaUpdate() throws AutosalonException {
        
    }

    @Override
    protected void kontrolaDelete() throws AutosalonException {
        
    }
    
    private void kontrolaIban()throws AutosalonException{
        
        
    }

    @Override
    public List<Prodavac> getPodaci() {
        return session.createQuery("from Prodavac").list();
        
    }

    @Override
    protected void nakonSpremanja() throws AutosalonException {
        
    }
    
    
    
}
