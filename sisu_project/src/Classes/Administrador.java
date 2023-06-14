package Classes;

import Exceptions.ManagerException;
import Interfaces.Validavel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Administrador extends User  {


    public Administrador(String email, String senha) {
        super(email, senha);
    }


    static Map<String, Float> cursoNotas = new HashMap<>();

    public static Map<String, Float> getCursoNotas() {
        return cursoNotas;
    }

    public static void addCurso(String nomeCurso, float nota) {
        String nomeCursoLowerCase = nomeCurso.toLowerCase();
        cursoNotas.put(nomeCurso.toLowerCase(), nota);
        salvarCursos();
    }

    public static void salvarCursos() {
        try {
            FileWriter writer = new FileWriter("cursos.txt");
            for (String key : cursoNotas.keySet()) {
                writer.write(key + "," + cursoNotas.get(key) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarCursos() {
        try {
            File file = new File("cursos.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(",");
                String curso = data[0].trim().toLowerCase();;
                float nota = Float.parseFloat(data[1].trim());
                cursoNotas.put(curso, nota);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void removeCurso(String nomeCurso) throws ManagerException{
        if (cursoNotas.containsKey(nomeCurso)) {
            if(getCursoNotas().isEmpty()) {
                throw new ManagerException("Nenhum curso disponível para remoção");
            }else {
                cursoNotas.remove(nomeCurso);
                System.out.println("Sucesso");
            }
        }else {
            throw new ManagerException("Não existe esse curso na lista de cursos");
        }
    }

    public static void updateNota(String nomeCurso, float novaNota) {
        if (cursoNotas.containsKey(nomeCurso)) {
            cursoNotas.put(nomeCurso, novaNota);
        }
    }

}
