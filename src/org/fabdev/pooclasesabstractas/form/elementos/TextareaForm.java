package org.fabdev.pooclasesabstractas.form.elementos;

public class TextareaForm extends ElementoForm {

    // variables de la clase.
    private int filas;
    private int columnas;

    // constructores.
    public TextareaForm(String nombre) {
        super(nombre);
    }

    public TextareaForm(String nombre, int filas, int columnas) {
        super(nombre);
        this.filas = filas;
        this.columnas = columnas;
    }

    // metodos get-set
    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    // metodo heredado.
    @Override
    public String dibujarHtml() {
        // es muy similar a las consultas SQL
        return  "<textarea name='" + this.nombre + "' cols='" + this.columnas + "' rows='" + this.filas + "'>"
                + this.valor +
                "</textarea>";
    }
}
