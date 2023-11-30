package orm.MainTestes;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.modelo.Aluno;

public class ListarAlunosByLetter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Digite a primeira Letra do nome do Aluno: ");
		String letter = scanner.nextLine();

		Query query = manager.createQuery("select a from Aluno a where substring(a.nome, 1, 1) = :paramFirstLetter");
		query.setParameter("paramFirstLetter", letter);
		
		List<Aluno> lista = query.getResultList();
		
		for (Aluno a : lista) {
			System.out.println("Id: "+a.getId());
			System.out.println("Nome: " +a.getNome());
			System.out.println("E-Mail: "+a.getEmail());
			System.out.println("CPF: "+a.getCpf());
			System.out.println("Data de Nascimento: "+a.getDataNascimento());
			System.out.println("Naturalidade: "+a.getNaturalidade());
			System.out.println("Endereço: "+a.getEndereco());
		}
		
		manager.close();
		factory.close();
		scanner.close();
	}
}
