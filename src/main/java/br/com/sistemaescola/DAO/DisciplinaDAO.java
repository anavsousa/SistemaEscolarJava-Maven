package br.com.sistemaescola.DAO;

import br.com.sistemaescola.Model.Disciplina;
import br.com.sistemaescola.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class DisciplinaDAO {
    public void salvar(Disciplina disciplina) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(disciplina);
        em.getTransaction().commit();
        em.close();
    }
    public Disciplina buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Disciplina disciplina = em.find(Disciplina.class, id);
        em.close();
        return disciplina;
    }
    public List<Disciplina> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Disciplina> disciplinas = em.createQuery("from Disciplina", Disciplina.class).getResultList();
        em.close();
        return disciplinas;
    }
    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Disciplina disciplina = em.find(Disciplina.class, id);
        if (disciplina != null) {
            em.getTransaction().begin();
            em.remove(disciplina);
            em.getTransaction().commit();
        }
        em.close();
    }
}
