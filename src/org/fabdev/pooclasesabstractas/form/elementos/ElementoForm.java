package org.fabdev.pooclasesabstractas.form.elementos;

import org.fabdev.pooclasesabstractas.form.validador.Validador;
import org.fabdev.pooclasesabstractas.form.validador.mensaje.MensajeFormateable;

import java.util.ArrayList;
import java.util.List;

// Clase abstracta de la que eredan los elementos del Formulario.
abstract public class ElementoForm {

    protected String valor;
    protected String nombre;
    private List<Validador> validadores;
    private List<String> errores;


    public ElementoForm() {
        // inicializara algunas cosas...
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    // metodos set.
    public void setValor(String valor) {
        this.valor = valor;
    }

    // metodo get.
    public String getNombre() {
        return nombre;
    }

    public List<String> getErrores() {
        return errores;
    }

    public ElementoForm addValidador(Validador validador) {
        this.validadores.add(validador);
        return this;
    }

    public boolean esValido() {
        // iteramos la lista de validadores.
        for (Validador v: validadores) {
            // si no se cumple una validacion ingresamos en el if ...
            if(!v.esValido(this.valor)) {
                // agregamos el error en la lista de errores.
                if (v instanceof MensajeFormateable) {
                    // hacemos casting.
                    this.errores.add(((MensajeFormateable) v).getMensajeFormateado(this.nombre));
                } else {
                    // generico.
                    this.errores.add(String.format(v.getMensaje(), this.nombre));
                }
            }
        }
        // si la lista esta vacia retorna un 'true' <-- la operacion es valida.
        // si la lista contiene al menos un elemento retorna 'false' <-- por ende no es valido.
        return (this.errores.isEmpty());
    }

    abstract public String dibujarHtml(); // metodo abstracto. (No se define)
}
