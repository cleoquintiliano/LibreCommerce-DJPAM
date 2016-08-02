/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librecommerce.dao;

import br.com.librecommerce.modelo.ContaReceber;
import br.com.librecommerce.modelo.StatusConta;
import br.com.librecommerce.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Clovis
 */
public class ContaReceberDao {

    public boolean gerarContaReceber(ContaReceber contaReceber) {
        EntityManager em = EntityManagerUtil.getInstance();
        try {
            em.getTransaction().begin();
            em.persist(contaReceber);
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

    public List<ContaReceber> consultarTodas() {
        EntityManager em = EntityManagerUtil.getInstance();
        List<ContaReceber> contasReceber = null;
        try {
            contasReceber = em.createQuery("SELECT  cc FROM ContaReceber cc WHERE cc.statusConta = :statusConta")
                    .setParameter("statusConta", StatusConta.ABERTA)
                    .getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return contasReceber;
    }

    public List<ContaReceber> consultarPorCliente(String nomeCliente) {
        EntityManager em = EntityManagerUtil.getInstance();
        List<ContaReceber> contasReceber = null;
        try {
            contasReceber
                    = em.createQuery("SELECT cc FROM ContaReceber cc "
                            + "WHERE cc.venda.cliente.nome = :nomeCliente "
                            + "AND cc.statusConta = :statusConta")
                    .setParameter("nomeCliente", nomeCliente)
                    .setParameter("statusConta", StatusConta.ABERTA)
                    .getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return contasReceber;
    }

    public boolean receber(ContaReceber contaReceber) {
        EntityManager em = EntityManagerUtil.getInstance();
        try {
            em.getTransaction().begin();
            em.merge(contaReceber);
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

    public boolean receberTodas(List<ContaReceber> contasReceber) {
        EntityManager em = EntityManagerUtil.getInstance();
        try {
            em.getTransaction().begin();

            for (int i = 0; i < contasReceber.size(); i++) {
                em.merge(contasReceber.get(i));
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

}
