package org.fabdev.pooclasesabstractas.form;

import org.fabdev.pooclasesabstractas.form.elementos.*;
import org.fabdev.pooclasesabstractas.form.elementos.select.Opcion;
import org.fabdev.pooclasesabstractas.form.validador.*;

import java.util.ArrayList;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        // instanciamos cada uno de los elementos.
        InputForm username = new InputForm("username");
        InputForm password = new InputForm("clave", "password");
        InputForm email = new InputForm("email", "email");
        InputForm edad = new InputForm("edad", "number");
        TextareaForm experiencia = new TextareaForm("exp", 20, 10);


        SelectForm lenguaje = new SelectForm("lenguaje");
        // instanciado fuera para que sea la seleccion por defecto.
        lenguaje.addOpcion(new Opcion("1", "Java").setSelected()) // valor por defecto.
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "C#"))
                .addOpcion(new Opcion("4", "GO"))
                .addOpcion(new Opcion("5", "TypeScript"));

        // implementamos los validadores del html y el formulario.
        // para usuario.
        username.addValidador(new RequeridoValidador());
        // para contrasena.
        password.addValidador(new RequeridoValidador());
        password.addValidador(new LargoValidador(6, 12)); // contrasena de 6 a 12 caracteres.
        // para correo electronico.
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador()); // podemos encadenar porque retornan la misma instancia.
        // Select Lenguaje.
        lenguaje.addValidador(new NoNuloValidador());

        // agregamos valores a los input form.
        username.setValor("John.Doe");
        password.setValor("selfpassword");
        email.setValor("john.doe@correo.com");
        edad.setValor("22");
        experiencia.setValor("Ingrese su experiencia laboral...");
        // en el SelectForm seleccionamos un valor por defecto.
        //java.setSelected(true);

        // usamos una clase anonima para instanciar un objeto que solo se usa una vez.
        ElementoForm saludo = new ElementoForm("saludar") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='"+this.nombre+"' value='"+ this.valor +"'>";
            }
        };

        saludo.setValor("Hola! este campo esta inhabilidato");


        // generamos lista para llamar dibujar los forms.
        List<ElementoForm> elementos = new ArrayList<>();
        elementos.add(username);
        elementos.add(password);
        elementos.add(edad);
        elementos.add(email);
        elementos.add(experiencia);
        elementos.add(lenguaje);
        elementos.add(saludo);


        // imprimimos html
        for (ElementoForm htmlElement : elementos) {
            System.out.println(htmlElement.dibujarHtml());
            System.out.println("<br>");
        }

        // verificamos el formulario revisando los errores.
        // Usamos una expresion lambda para ejecutar un forEach.
        // e --> cada elemento de la lista.
        elementos.forEach(e -> {
            // si un elemento no es valido entramos al if...
            if(!e.esValido()) {
                // obtenemos los errores y con una expresion lambda imprimimos el error on el toString().
                // err --> son la lista de errores.
                e.getErrores().forEach(err -> System.out.println(e.getNombre() + " >> " + err));
            }
        });
    }
}
