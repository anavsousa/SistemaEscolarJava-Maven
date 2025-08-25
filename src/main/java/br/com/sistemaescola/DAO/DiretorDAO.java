package br.com.sistemaescola.DAO;

import br.com.sistemaescola.Model.Diretor;
import br.com.sistemaescola.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class DiretorDAO {
    public void salvar(Diretor diretor) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(diretor);
        em.getTransaction().commit();
        em.close();
    }
    public Diretor buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Diretor diretor = em.find(Diretor.class, id);
        em.close();
        return diretor;
    }
    public List<Diretor> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Diretor> diretores = em.createQuery("from Diretor", Diretor.class).getResultList();
        em.close();
        return diretores;
    }
    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Diretor diretor = em.find(Diretor.class, id);
        if (diretor != null) {
            em.getTransaction().begin();
            em.remove(diretor);
            em.getTransaction().commit();
        }
        em.close();
    }
}
