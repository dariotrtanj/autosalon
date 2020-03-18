/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.controller;

import hr.autosalon.autosalon.model.Prodaja;
import hr.autosalon.autosalon.util.AutosalonException;
import java.util.List;

/**
 *
 * @author TRTANJ
 */
public class ObradaProdaja extends Obrada<Prodaja>{
    
    public ObradaProdaja(Prodaja entitet){
        super(entitet);
    }
    
    public ObradaProdaja(){
        super();
    }
    
    @Override
    public Prodaja create() throws AutosalonException{
        kontrolaCreate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
    @Override
    public Prodaja update() throws AutosalonException{
        kontrolaCreate();
        save();
        nakonSpremanja();
        return entitet;
    }    
    
     private void save() {
        session.beginTransaction();
        session.save(entitet);
        entitet.getProdaje();
        session.save();
        session.getTransaction().commit();
    }
    
    

    @Override
    protected void kontrolaCreate() throws AutosalonException {
        
    }

    @Override
    protected void kontrolaUpdate() throws AutosalonException {
        
    }

    @Override
    protected void kontrolaDelete() throws AutosalonException {
        
    }

    @Override
    public List<Prodaja> getPodaci() {
       return session.createQuery("from Prodaja").list(); 
    }

    @Override
    protected void nakonSpremanja() throws AutosalonException {
        
    }

   

   
}

   
        
    
    
   
    

