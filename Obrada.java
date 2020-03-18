/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.autosalon.autosalon.controller;

import hr.autosalon.autosalon.model.Entitet;
import hr.autosalon.autosalon.util.AutosalonException;
import hr.autosalon.autosalon.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author TRTANJ
 */
public abstract class Obrada<T>{
    
    protected T entitet;
    protected Session session;
    protected abstract void kontrolaCreate()throws AutosalonException;
    protected abstract void kontrolaUpdate()throws AutosalonException;
    protected abstract void kontrolaDelete()throws AutosalonException;
    public abstract List<T> getPodaci();
    protected abstract void nakonSpremanja()throws AutosalonException;
    
    public Obrada(T entitet){
        this();
        this.entitet=entitet;
    }

    public Obrada() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    
    
    public T create() throws AutosalonException{
        kontrolaCreate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
    public void createAll(List<T> lista) throws AutosalonException{
    
        session.beginTransaction();
        for(T sl : lista){
            this.entitet=sl;
            kontrolaCreate();
            session.save(sl);
            nakonSpremanja();
        }
        session.getTransaction().commit();
        
        
    }
    
    public T update() throws AutosalonException{
        kontrolaUpdate();
        save();
        nakonSpremanja();
        return entitet;
    }
    
    public boolean delete() throws AutosalonException{
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
        //provjeriti da li je obrisano. Vjerojatno će entitet.getSifra biti null
        return true;
    }
    
    private void save(){
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
    }

   

    
}

    
    
    

  
        
    
            
    
    

