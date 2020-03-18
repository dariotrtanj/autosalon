/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.controller;


import hr.autosalon.autosalon.model.Vozilo;
import hr.autosalon.autosalon.util.AutosalonException;
import java.util.List;

/**
 *
 * @author TRTANJ
 */
public class ObradaVozilo extends Obrada<Vozilo>{

    public ObradaVozilo(Vozilo entitet) {
        super(entitet);
    }

    public ObradaVozilo() {
        
    }
    
    
    
    @Override
    public Vozilo create() throws AutosalonException{
        kontrolaCreate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
    @Override
    public Vozilo update() throws AutosalonException{
        kontrolaUpdate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
     private void save() {
        session.getTransaction();
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
    public List<Vozilo> getPodaci() {
        return session.createQuery("from Vozilo").list();
        
    }

    @Override
    protected void nakonSpremanja() throws AutosalonException {
        
    }

    

    
}
    

       
    

    

