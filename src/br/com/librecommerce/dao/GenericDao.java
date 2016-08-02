/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.dao;

import br.com.librecommerce.util.EntityManagerUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Clovis
 */
public class GenericDao<T> {

    public boolean salvar(T t) {
        EntityManager em = EntityManagerUtil.getInstance();
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }

    }

    public boolean atualizar(T t) {
        EntityManager em = EntityManagerUtil.getInstance();
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            return true;
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } 
        finally {
            em.close();
        }

    }

    public T buscarPorId(Class<T> clazz, int id) {
        EntityManager em = EntityManagerUtil.getInstance();
        T t = null;
        try {
            t = em.find(clazz, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return t;
    }

}
