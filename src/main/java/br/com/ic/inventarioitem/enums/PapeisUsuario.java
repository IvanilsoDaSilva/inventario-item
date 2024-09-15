package br.com.ic.inventarioitem.enums;

public enum PapeisUsuario {
    ADMINISTRADOR("administrador"),
    USUARIO("usuario");

    String papel;

    PapeisUsuario(String papel) {
        this.papel = papel;
    }

    public String TipoUsuario(){
        return this.papel;
    }
}
