package org.fabdev.pooclasesabstractas.form.elementos;

import org.fabdev.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.List;

public class SelectForm extends ElementoForm {
    // posee una lista de opciones
    private List<Opcion> opciones;

    // constructores
    public SelectForm(String nombre) {
        super(nombre);
        opciones = new ArrayList<Opcion>(); // inicializamos la lista de opciones.
    }

    public SelectForm(String nombre, List<Opcion> opciones) {
        super(nombre);
        this.opciones = opciones;
    }

    // metodo add, agrega elementos a la lista desplegable.
    public SelectForm addOpcion(Opcion opcion) {
        this.opciones.add(opcion);
        return this; // se retorna a si mismo, permite encadenar opciones.
    }

    // metodo heredado...
    @Override
    public String dibujarHtml() {
        // usaremos StringBuilder para concatenar la lista de opciones al HTML.
        StringBuilder sb = new StringBuilder("<select "); // iniciamos etiqueta...
        sb.append("name='")
                .append(this.nombre)
                .append("'>"); // html: <select name='nombre'> ...

        for (Opcion opcion: this.opciones) {
            // agregamos cada elemento de la lista de opciones.
            // <option value='valor'> "nombre opcion" </option>
            sb.append("\n<option value='")
                    .append(opcion.getValor())
                    .append("'");

            if (opcion.isSelected()) {
                sb.append(" selected");
                this.valor = opcion.getValor();
            }

            sb.append(">")
                    .append(opcion.getNombre())
                    .append("</option>");
        }
        sb.append("</select>"); // ... </select>

        return sb.toString();
    }
}
