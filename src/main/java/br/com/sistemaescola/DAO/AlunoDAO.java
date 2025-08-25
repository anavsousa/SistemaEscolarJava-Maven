package br.com.sistemaescola.DAO;

import br.com.sistemaescola.Model.Aluno;
import br.com.sistemaescola.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class AlunoDAO {
    public void salvar(Aluno aluno) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();
    }
    public Aluno buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Aluno aluno = em.find(Aluno.class, id);
        em.close();
        return aluno;
    }
    public List<Aluno> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Aluno> alunos = em.createQuery("from Aluno", Aluno.class).getResultList();
        em.close();
        return alunos;
    }
    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Aluno aluno = em.find(Aluno.class, id);
        if (aluno != null) {
            em.getTransaction().begin();
            em.remove(aluno);
            em.getTransaction().commit();
        }
        em.close();
    }
}
