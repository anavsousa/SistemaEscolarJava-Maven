package br.com.sistemaescola.DAO;

import br.com.sistemaescola.Model.Professor;
import br.com.sistemaescola.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class ProfessorDAO {
    public void salvar(Professor professor) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(professor);
        em.getTransaction().commit();
        em.close();
    }
    public Professor buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Professor professor = em.find(Professor.class, id);
        em.close();
        return professor;
    }
    public List<Professor> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Professor> professores = em.createQuery("from Professor", Professor.class).getResultList();
        em.close();
        return professores;
    }
    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Professor professor = em.find(Professor.class, id);
        if (professor != null) {
            em.getTransaction().begin();
            em.remove(professor);
            em.getTransaction().commit();
        }
        em.close();
    }
}
