/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.controller;

import hr.autosalon.autosalon.model.Kupac;
import hr.autosalon.autosalon.util.AutosalonException;
import java.util.List;


/**
 *
 * @author TRTANJ
 */
public abstract class ObradaKupac extends Obrada<Kupac>{
    
    public ObradaKupac(Kupac entitet){
        super(entitet);
    }
    
    public ObradaKupac(){
        super();
    }
    
    
    
    protected void kontrolaCreate() throws AutosalonException {
        super.kontrolaCreate();
        kontrolaBrojUgovora();
        
    }

    @Override
    protected void kontrolaUpdate() throws AutosalonException {
        
    }

    @Override
    protected void kontrolaDelete() throws AutosalonException {
        
    }
    
    private void kontrolaBrojUgovora() throws AutosalonException{
        
    }

    @Override
    public List<Kupac> getPodaci() {
        return session.createQuery("from Kupac").list();
        
    }

    @Override
    protected void nakonSpremanja() throws AutosalonException {
        
    }

    
}

    
        
    
    
   
    

