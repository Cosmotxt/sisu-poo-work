package Classes;

import Exceptions.AplicationException;
import Exceptions.AutenticationException;
import Interfaces.Validavel;

import java.util.List;
import java.util.ArrayList;
public class Estudante extends User implements Interfaces.Aplicavel, Interfaces.Validavel{
    private float notaEnem;
    private List<String> cursosAplicados;


    public void setNotaEnem(float notaEnem) {
        this.notaEnem = notaEnem;
    }

    public float getNotaEnem() {
        return notaEnem;
    }


    public void setCursosAplicados(List<String> cursosAplicados) {
        this.cursosAplicados = cursosAplicados;
    }

    public Estudante(String email, String senha) {
        super(email, senha);
        this.cursosAplicados = new ArrayList<>();
    }

    public List<String> getCursosAplicados() {
        return cursosAplicados;
    }

    @Override
    public boolean validar() {
        return notaEnem >= 0 && notaEnem <= 1000;
    }

    @Override
    public boolean Autenticar(String nomeCurso, float notaEnem, int aplicarRetirar) throws AutenticationException, AplicationException {
        boolean retorno = false;
        String nomeCursoLowerCase = nomeCurso.toLowerCase();
        if (!Administrador.getCursoNotas().containsKey(nomeCursoLowerCase)) {
            throw new AutenticationException("O curso " + nomeCurso + " não existe.");
        } else if (this.cursosAplicados.size() >= 3) {
            throw new AutenticationException("Você já aplicou para o máximo de 3 cursos.");
        }else {
            if (aplicarRetirar == 1) {
                float notaRequerida = Administrador.getCursoNotas().get(nomeCursoLowerCase);
                if (notaEnem >= notaRequerida) {
                    this.cursosAplicados.add(nomeCursoLowerCase);
                    retorno = true;
                } else {
                    retorno = false;
                }
            } else {
                if(cursosAplicados.contains(nomeCurso)) {
                    this.cursosAplicados.remove(nomeCursoLowerCase);
                }else {
                    throw new AplicationException("Não há nenhum curso aplicado com este nome");
                }
            }
        }
        return retorno;
    }


}
