package orm.MainTestes;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;

public class AlterarDados {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Informe a (ID)entificação do Aluno: ");
		int idAluno = scanner.nextInt();
		scanner.nextLine();
        
        Aluno aluno = manager.find(Aluno.class, idAluno);

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
		
		manager.getTransaction().begin();
		manager.merge(aluno);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		scanner.close();
	}
}
