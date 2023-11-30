package orm.MainTestes;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;

public class RemoverAluno {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		System.out.println("Informe o número de (ID)entificção do Aluno: ");
		int idAluno = scanner.nextInt();
		scanner.nextLine();

        Aluno aluno = manager.find(Aluno.class, idAluno);
		manager.getTransaction().begin();
		manager.remove(aluno);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		scanner.close();
	}
}
