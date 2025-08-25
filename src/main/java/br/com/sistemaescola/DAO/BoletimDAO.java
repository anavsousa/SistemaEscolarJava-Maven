package br.com.sistemaescola.DAO;

import br.com.sistemaescola.Model.Boletim;
import br.com.sistemaescola.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class BoletimDAO {
    public void salvar(Boletim boletim) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(boletim);
        em.getTransaction().commit();
        em.close();
    }
    public Boletim buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Boletim boletim = em.find(Boletim.class, id);
        em.close();
        return boletim;
    }
    public List<Boletim> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Boletim> boletins = em.createQuery("from Boletim", Boletim.class).getResultList();
        em.close();
        return boletins;
    }
    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Boletim boletim = em.find(Boletim.class, id);
        if (boletim != null) {
            em.getTransaction().begin();
            em.remove(boletim);
            em.getTransaction().commit();
        }
        em.close();
    }
}
