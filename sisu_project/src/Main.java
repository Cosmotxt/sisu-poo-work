import Classes.Administrador;
import Classes.Estudante;
import Classes.User;
import Exceptions.AplicationException;
import Exceptions.AutenticationException;
import Exceptions.ManagerException;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SimpleTimeZone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Administrador.carregarCursos();

        int sairMenu = 1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Você é Estudante(1) ou Administrador(2)?");
        int option = sc.nextInt();
        sc.nextLine();

        if(option == 1) {
            Estudante estudante = null;
            boolean verify = false;
            String user;
            String pass;
            while (!verify) {
                System.out.println("Digite seu e-mail do .gov: (E-AMAILS USADOS NO .GOV POSSUEM O ENDERÇO @gov.com)");
                user = sc.nextLine();

                System.out.println("Digite sua senha: (SENHAS DO .GOV POSSUEM PELO MENOS UMA LETRA MAIÚSCULA E UM NÚMERO)");
                pass = sc.nextLine();

                try {
                    estudante = new Estudante(user, pass);
                    verify = estudante.autenticarLogin(user, pass);
                } catch (AutenticationException e) {
                    System.err.println(e.getMessage());
                }
            }
            System.out.println("----------------------------------------");
            System.out.println("Logado com sucesso!.");

            verify = true;

            while (verify) {
                System.out.println("Você quer aplicar(1) para um curso ou remover uma aplicação?(2)");
                int aplicarOuRetirar = sc.nextInt();
                sc.nextLine();

                System.out.println("Qual curso?:");
                String curso = sc.nextLine();

                System.out.println("Agora, informe sua nota do ENEM:");
                float notaEnem = sc.nextFloat();
                sc.nextLine();

                estudante.setNotaEnem(notaEnem);

                if(!estudante.validar()) {
                    System.out.println("Nota inválida. A nota do ENEM vai até mil, apenas");
                    continue;
                }

                try {
                    verify = estudante.Autenticar(curso, notaEnem, aplicarOuRetirar);

                    if (aplicarOuRetirar == 1) {
                        if (verify) {
                            System.out.println("Parabens! Você tem nota suficiente para passar. Aplicação bem sucedida.");
                            System.out.println("Suas aplicações:\n" + estudante.getCursosAplicados());
                        } else {
                            System.out.println("Infelizmente você não tem nota suficiente para aplicar para este curso. Nota necessária: " + Administrador.getCursoNotas().get(curso));
                        }
                    } else {
                        if (!verify) {
                            System.out.println("Aplicação retirada");
                        }
                    }
                } catch (AutenticationException | AplicationException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Você quer continuar a aplicar ou remover aplicações?? (1 - sim, 2 - não)");
                option = sc.nextInt();
                if(option == 2) {
                    verify = false;
                }

                sc.nextLine();
            }
        } else {
            Administrador admin = null;
            boolean verifyAdmin = false;
            String adminUser;
            String adminPass;
            while (!verifyAdmin) {
                System.out.println("Digite seu e-mail do admin:");
                adminUser = sc.nextLine();

                System.out.println("Digite sua senha do admin:");
                adminPass = sc.nextLine();

                try {
                    admin = new Administrador(adminUser, adminPass);
                    verifyAdmin = admin.autenticarLogin(adminUser, adminPass);
                } catch (AutenticationException e) {
                    System.err.println(e.getMessage());
                }
            }
            System.out.println("----------------------------------------");
            System.out.println("Logado com sucesso!.");

            verifyAdmin = false;

            while (!verifyAdmin) {
                System.out.println("Você quer adicionar(1) ou remover(2) um curso?");
                int adicionarOuRemover = sc.nextInt();
                sc.nextLine();

                if (adicionarOuRemover == 1) {
                    System.out.println("Digite o nome do curso que você quer adicionar:");
                    String curso = sc.nextLine();

                    System.out.println("Digite a nota necessária para o curso:");
                    float nota = sc.nextFloat();
                    sc.nextLine();

                    admin.addCurso(curso, nota);
                    Administrador.salvarCursos();
                    System.out.println("Curso adicionado com sucesso!");

                } else if (adicionarOuRemover == 2) {
                    System.out.println("Digite o nome do curso que você quer remover:");
                    String curso = sc.nextLine();

                    try {
                        admin.removeCurso(curso);
                        Administrador.salvarCursos();
                    }catch (ManagerException e) {
                        System.err.println(e.getMessage());
                    }
                }

                System.out.println("Você quer continuar a adicionar ou remover cursos? (1 - sim, 2 - não)");
                int resposta = sc.nextInt();
                sc.nextLine();

                if (resposta == 2) {
                    verifyAdmin = true;
                }
            }
        }

    }
}
