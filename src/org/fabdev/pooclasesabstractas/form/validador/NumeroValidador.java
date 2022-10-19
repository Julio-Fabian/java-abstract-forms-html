package org.fabdev.pooclasesabstractas.form.validador;

public class NumeroValidador extends Validador {

    protected String mensaje = "El campo debe ser un numero.";

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

        try {
            Integer.parseInt(valor);
            return true;
        } catch (Exception e) {
            System.err.println(e + "/ El campo no es un numero.");
            return false;
        }
    }
}
