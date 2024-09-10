package br.com.ic.inventarioitem.enums;

public enum PapeisUsuario {
    USUARIO_ADMINISTRADOR("administrador"),
    USUARIO_OPERADOR("operador");

    String papel;

    PapeisUsuario(String papel) {
        this.papel = papel;
    }

    public String TipoUsuario(){
        return this.papel;
    }
}
