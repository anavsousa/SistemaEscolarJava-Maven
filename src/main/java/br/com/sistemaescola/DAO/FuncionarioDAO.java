package br.com.sistemaescola.DAO;

import br.com.sistemaescola.Model.Funcionario;
import br.com.sistemaescola.JPAUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class FuncionarioDAO {
    public void salvar(Funcionario funcionario) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        em.close();
    }
    public Funcionario buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, id);
        em.close();
        return funcionario;
    }
    public List<Funcionario> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Funcionario> funcionarios = em.createQuery("from Funcionario", Funcionario.class).getResultList();
        em.close();
        return funcionarios;
    }
    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Funcionario funcionario = em.find(Funcionario.class, id);
        if (funcionario != null) {
            em.getTransaction().begin();
            em.remove(funcionario);
            em.getTransaction().commit();
        }
        em.close();
    }
}
