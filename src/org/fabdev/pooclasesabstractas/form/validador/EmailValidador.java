package org.fabdev.pooclasesabstractas.form.validador;

public class EmailValidador extends Validador {

    protected String mensaje = "El campo %s tiene un formato de correo invalido";
    private final static String EMAIL_REGEX = "^(.+)@(.+)$"; // expresion regular
    // [^(principio) analizamos desde el principio multiples caracteres]@[analizamos multiple caracter $(final)]

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return (valor.matches(EMAIL_REGEX));
    }
}
