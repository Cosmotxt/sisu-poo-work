package Interfaces;

import Exceptions.AplicationException;
import Exceptions.AutenticationException;

public interface Aplicavel {
    public boolean Autenticar(String nomeCurso, float notaEnem, int AplicarRetirar) throws AutenticationException, AplicationException;
}
