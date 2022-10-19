package org.fabdev.pooclasesabstractas.form.elementos;

public class InputForm extends ElementoForm {
    // variables de la clase.
    private String tipo = "text";

    // constructor.
    public InputForm(String nombre) {
        super(nombre);
    }

    public InputForm(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    // metodos de la clase.

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // metodo abstracto implementado de la clase padre ElementoForm.java
    @Override
    public String dibujarHtml() {
        // elemento del html...
        return "<input type=\"" + this.tipo + "\" name=\"" + this.nombre + "\" value=\"" + this.valor + "\">";
    }
}
