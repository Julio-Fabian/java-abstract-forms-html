package org.fabdev.pooclasesabstractas.form.elementos.select;

public class Opcion {
    private String valor;
    private String nombre;
    private boolean isSelected;

    public Opcion() {
        // some code here...
    }

    public Opcion(String valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
    }

    // get-set methods.

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    // para establecerlo desde la instancia del option.
    public Opcion setSelected() {
        isSelected = true;
        return this;
    }
}
