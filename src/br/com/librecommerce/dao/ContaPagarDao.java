/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.dao;

import br.com.librecommerce.modelo.ContaPagar;
import br.com.librecommerce.modelo.StatusConta;
import br.com.librecommerce.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Clovis
 */
public class ContaPagarDao {

    public boolean salvarConta(ContaPagar contaPagar) {
        EntityManager em = EntityManagerUtil.getInstance();
        try {
            em.getTransaction().begin();
            em.persist(contaPagar);
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

    public boolean pagarConta(ContaPagar contaPagar) {
        EntityManager em = EntityManagerUtil.getInstance();
        try {
            em.getTransaction().begin();
            em.merge(contaPagar);
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

    public boolean pagarTodasContas(List<ContaPagar> contasPagar) {
        EntityManager em = EntityManagerUtil.getInstance();
        try {
            em.getTransaction().begin();

            for (ContaPagar contaPagar : contasPagar) {
                em.merge(contaPagar);
            }

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

    public List<ContaPagar> consultarTodas() {
        EntityManager em = EntityManagerUtil.getInstance();
        List<ContaPagar> contasPagar = null;
        try {
            contasPagar = em.createQuery("SELECT cp FROM ContaPagar cp WHERE cp.statusConta = :statusConta")
                    .setParameter("statusConta", StatusConta.ABERTA)
                    .getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return contasPagar;
    }

    public List<ContaPagar> consultarPorDescricao(String descricao) {
        EntityManager em = EntityManagerUtil.getInstance();
        List<ContaPagar> contasPagar = null;
        try {
            contasPagar = em.createQuery("SELECT cp FROM ContaPagar cp "
                    + "WHERE cp.descricao LIKE :descricao AND cp.statusConta = :statusConta")
                    .setParameter("descricao", "%" + descricao + "%")
                    .setParameter("statusConta", StatusConta.ABERTA)
                    .getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return contasPagar;
    }

}
