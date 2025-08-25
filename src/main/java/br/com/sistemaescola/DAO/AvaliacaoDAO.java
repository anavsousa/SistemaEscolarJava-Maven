package br.com.sistemaescola.DAO;

import br.com.sistemaescola.Model.Avaliacao;
import br.com.sistemaescola.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class AvaliacaoDAO {
    public void salvar(Avaliacao avaliacao) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(avaliacao);
        em.getTransaction().commit();
        em.close();
    }
    public Avaliacao buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Avaliacao avaliacao = em.find(Avaliacao.class, id);
        em.close();
        return avaliacao;
    }
    public List<Avaliacao> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Avaliacao> avaliacoes = em.createQuery("from Avaliacao", Avaliacao.class).getResultList();
        em.close();
        return avaliacoes;
    }
    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Avaliacao avaliacao = em.find(Avaliacao.class, id);
        if (avaliacao != null) {
            em.getTransaction().begin();
            em.remove(avaliacao);
            em.getTransaction().commit();
        }
        em.close();
    }
}
