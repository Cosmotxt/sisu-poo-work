package Interfaces;

import Exceptions.AutenticationException;

public abstract interface Autentication {
    public abstract boolean autenticarLogin(String usuario, String senha) throws AutenticationException;
}
