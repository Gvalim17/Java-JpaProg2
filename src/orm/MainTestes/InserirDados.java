package orm.MainTestes;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;

public class InserirDados {
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite seu Nome: ");
		aluno.setNome(scanner.nextLine());
		System.out.println("Digite seu E-mail: ");
		aluno.setEmail(scanner.nextLine());
		System.out.println("Digite seu CPF: ");
		aluno.setCpf(scanner.nextLine());
		System.out.println("Digite sua Data de Nascimento: ");
		aluno.setDataNascimento(scanner.nextLine());
		System.out.println("Digite sua Naturalidade: ");
		aluno.setNaturalidade(scanner.nextLine());
		System.out.println("Digite seu Endereço: ");
		aluno.setEndereco(scanner.nextLine());

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		scanner.close();
	}
}
