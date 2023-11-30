package orm.actions;

import orm.modelo.Aluno;

import javax.persistence.EntityManager;
import java.util.List;

public class ListarAluno {

    public List<Aluno> findAll() {
        return EntityManager.createQuery("select a from Aluno as a");
    }
}
