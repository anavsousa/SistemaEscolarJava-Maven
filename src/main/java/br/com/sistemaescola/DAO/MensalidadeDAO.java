package br.com.sistemaescola.DAO;

import br.com.sistemaescola.Model.Mensalidade;
import br.com.sistemaescola.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class MensalidadeDAO {
    public void salvar(Mensalidade mensalidade) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(mensalidade);
        em.getTransaction().commit();
        em.close();
    }
    public Mensalidade buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Mensalidade mensalidade = em.find(Mensalidade.class, id);
        em.close();
        return mensalidade;
    }
    public List<Mensalidade> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Mensalidade> mensalidades = em.createQuery("from Mensalidade", Mensalidade.class).getResultList();
        em.close();
        return mensalidades;
    }
    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Mensalidade mensalidade = em.find(Mensalidade.class, id);
        if (mensalidade != null) {
            em.getTransaction().begin();
            em.remove(mensalidade);
            em.getTransaction().commit();
        }
        em.close();
    }
}
