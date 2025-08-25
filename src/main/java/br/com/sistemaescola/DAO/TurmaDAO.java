package br.com.sistemaescola.DAO;

import br.com.sistemaescola.Model.Turma;
import br.com.sistemaescola.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class TurmaDAO {
    public void salvar(Turma turma) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(turma);
        em.getTransaction().commit();
        em.close();
    }
    public Turma buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Turma turma = em.find(Turma.class, id);
        em.close();
        return turma;
    }
    public List<Turma> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Turma> turmas = em.createQuery("from Turma", Turma.class).getResultList();
        em.close();
        return turmas;
    }
    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Turma turma = em.find(Turma.class, id);
        if (turma != null) {
            em.getTransaction().begin();
            em.remove(turma);
            em.getTransaction().commit();
        }
        em.close();
    }
}
