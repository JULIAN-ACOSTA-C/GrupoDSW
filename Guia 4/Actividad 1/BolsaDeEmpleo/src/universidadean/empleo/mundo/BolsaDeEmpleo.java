/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�a de la Informaci�n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Basado en un Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: Bolsa de Empleo
 * Fecha: 11 de marzo de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.empleo.mundo;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Es la clase que se encarga de manejar y organizar los aspirantes <br>
 * <b>inv: </b> <br>
 * aspirantes != null <br>
 * En el vector de aspirantes no hay dos o m�s con el mismo nombre
 */
public class BolsaDeEmpleo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la lista que contiene todos los aspirantes
     */
    private ArrayList<Aspirante> aspirantes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva bolsa de emplea sin aspirantes.
     */
    public BolsaDeEmpleo() {
        aspirantes = new ArrayList<>();
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de aspirantes. La lista retornada no es la misma que la almacenada en esta clase, pero si tiene el mismo orden.
     *
     * @return lista de aspirantes
     */
    public ArrayList<Aspirante> darAspirantes() {
        ArrayList<Aspirante> copia = new ArrayList<>(aspirantes);
        return copia;
    }

    /**
     * Agrega un nuevo aspirante a la bolsa
     *
     * @param nombreA           El nombre del aspirante - nombreA != null
     * @param profesionA        La profesi�n del aspirante - profesionA es uno de estos { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA }
     * @param aniosExperienciaA A�os de experiencia del aspirante - aniosExperienciaA > 0
     * @param edadA             La edad del aspirante - edadA > 0
     * @param telefonoA         El tel�fono del aspirante - telefonoA != null
     * @param imagenA           La ruta a la imagen del aspirante - imagenA != null
     * @return Se retorn� true si el aspirante fue adicionado o false de lo contrario
     */

    public boolean agregarAspirante(String nombreA, String profesionA, int aniosExperienciaA, int edadA, String telefonoA, String imagenA) {
        int aspiranteBuscado = buscarAspirante(nombreA);
        boolean agregado = false;
        if (aspiranteBuscado == -1) {
            Aspirante nuevoAspirante = new Aspirante(nombreA, profesionA, aniosExperienciaA, edadA, telefonoA, imagenA);
            aspirantes.add(nuevoAspirante);
            agregado = true;
        }

        return agregado;
    }

    /**
     * Organiza la lista de aspirantes por nombre usando el algoritmo de burbuja. <br>
     * <b>post: </b>La lista de aspirantes est� ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre() {
        boolean ordenado = false;
        while (!ordenado) {
            ordenado = true;
            for (int i = 1; i < aspirantes.size(); i++) {
                String asp1 = aspirantes.get(i).darNombre(); // i
                String asp2 = aspirantes.get(i - 1).darNombre(); // i-1

                if (asp1.compareTo(asp2) < 0) {
                    Aspirante aux = aspirantes.get(i);
                    aspirantes.remove(i);
                    aspirantes.add(i - 1, aux);
                    ordenado = false;
                }
            }
        }
        // TODO: Realizar el ejercicio correspondiente
    }

    /**
     * Organiza la lista de aspirantes por edad usando el algoritmo de selecci�n <br>
     * <b>post: </b>La lista de aspirantes est� ordenada por edad
     */
    public void ordenarPorEdad() {
        int lowestIndex;

        for(int i=0;i<aspirantes.size();i++){

            lowestIndex = i;

            for(int j=i+1;j<aspirantes.size();j++){
                if(aspirantes.get(j).darEdad() < aspirantes.get(lowestIndex).darEdad()){
                    lowestIndex = j;
                }
            }

            if(lowestIndex != i){
                aspirantes.add(i,aspirantes.get(lowestIndex));
                aspirantes.remove(lowestIndex+1);
                aspirantes.add(lowestIndex,aspirantes.get(i+1));
                aspirantes.remove(i+1);
            }

        }

        // TODO: Realizar el ejercicio correspondiente
    }

    /**
     * Organiza la lista de aspirantes por profesi�n usando el algoritmo de burbuja <br>
     * <b>post: </b>El conjunto de aspirantes esta ordenado por profesi�n
     */
    public void ordenarPorProfesion() {
        boolean ordenado = false;
        while(!ordenado) {

            ordenado = true;
            for (int i = 1; i < aspirantes.size(); i++) {
                if ((int) aspirantes.get(i).darProfesion().charAt(0) < (int) aspirantes.get(i-1).darProfesion().charAt(0)) {
                    Aspirante aux = aspirantes.get(i);
                    aspirantes.remove(i);
                    aspirantes.add(i - 1, aux);
                    ordenado = false;
                }
            }

        }
        // TODO: Realizar el ejercicio correspondiente
    }

    /**
     * Organiza la lista de aspirantes por a�os de experiencia usando el algoritmo de inserci�n <br>
     * <b>post: </b>La lista de aspirantes est� ordenada por a�os de experiencia
     */
    public void ordenarPorAniosDeExperiencia() {
        for(int i=1;i<aspirantes.size();i++){
            Aspirante temp_value = aspirantes.get(i);
            int pos = i;
            while(pos > 0 && aspirantes.get(pos-1).darAniosExperiencia() > aspirantes.get(pos).darAniosExperiencia()){
                aspirantes.remove(pos);
                aspirantes.add(pos-1,temp_value);
                --pos;
            }
        }
        // TODO: Realizar el ejercicio correspondiente
    }

    /**
     * Busca un Aspirante seg�n su nombre y retorna la posici�n en la que se encuentra. <br>
     *
     * @param nombre El nombre del aspirante buscado - nombre!=null
     * @return Se retorn� la posici�n donde se encuentra un aspirante con el nombre dado. Si no se encuentra ning�n aspirante con ese nombre se retorn� -1.
     */
    public int buscarAspirante(String nombre) {
        if(aspirantes.size() > 0) {
            for (int i=aspirantes.size()-1;i>=0;i--) {
                if (aspirantes.get(i).darNombre().equalsIgnoreCase(nombre)) {
                    return i;
                }
            }
        }

        // TODO: Realizar el ejercicio correspondiente

        return -1;
    }

    /**
     * Busca un aspirante utilizando una b�squeda binaria. <br>
     * <b>pre: </b> La lista de aspirantes se encuentra ordenada por nombre. <br>
     *
     * @param nombre es el nombre del aspirante que se va a buscar - nombre!=null
     * @return Se retorn� la posici�n del aspirante con el nombre dado. Si el aspirante no existe se retorn� -1.
     */
    public int buscarBinarioPorNombre(String nombre) {
        int l = 0, r = aspirantes.size()- 1;

        ordenarPorNombre();

        while (l <= r) {
            int m = l + (r - l) / 2;
            int res = nombre.toLowerCase().compareTo(aspirantes.get(m).darNombre().toLowerCase());

            if (res == 0)
                return m;


            if (res > 0)
                l = m + 1;


            else
                r = m - 1;
        }

        return -1;
    }

    /**
     * Busca el aspirante que tenga la menor edad en la bolsa.
     *
     * @return Se retorn� la posici�n donde se encuentra el aspirante m�s joven. Si no hay aspirantes en la bolsa se retorn� -1
     */
    public int buscarAspiranteMasJoven() {
        int masJoven = 999;
        int pos = 0;
        if(aspirantes.size() > 0) {
            for (int i=aspirantes.size()-1;i>=0;i--) {
                if (aspirantes.get(i).darEdad() < masJoven) {
                    masJoven = aspirantes.get(i).darEdad();
                    pos = i;
                }

            }
            return pos;
        }

        // TODO: Realizar el ejercicio correspondiente

        return -1;
    }

    /**
     * Busca el aspirante que tenga la mayor edad en la bolsa.
     *
     * @return Se retorn� la posici�n donde se encuentra el aspirante con m�s edad. Si no hay aspirantes en la bolsa se retorn� -1
     */
    public int buscarAspiranteMayorEdad() {
        int mayorEdad = 0;
        int pos = 0;
        if(aspirantes.size() > 0) {
            for (int i=aspirantes.size()-1;i>=0;i--) {
                if (aspirantes.get(i).darEdad() > mayorEdad) {
                    mayorEdad = aspirantes.get(i).darEdad();
                    pos = i;
                }

            }
            return pos;
        }

        // TODO: Realizar el ejercicio correspondiente

        return -1;
    }

    /**
     * Busca el aspirante con m�s a�os de experiencia en la bolsa.
     *
     * @return Se retorn� la posici�n donde se encuentra el aspirante con mayor experiencia. Si no hay aspirantes en la bolsa se retorn� -1
     */
    public int buscarAspiranteMayorExperiencia() {
        int mayorExperiencia = 0;
        int pos = 0;
        if(aspirantes.size() > 0) {
            for (int i=aspirantes.size()-1;i>=0;i--) {
                if (aspirantes.get(i).darAniosExperiencia() > mayorExperiencia) {
                    mayorExperiencia = aspirantes.get(i).darAniosExperiencia();
                    pos = i;
                }

            }
            return pos;
        }

        // TODO: Realizar el ejercicio correspondiente

        return -1;
    }

    /**
     * Contrata a un aspirante.<br>
     * <b>post: </b>Se elimin� el aspirante de la lista de aspirantes.
     *
     * @param nombre El nombre del aspirante a contratar - nombre!=null
     * @return Se retorn� true si el aspirante estaba registrado en la bolsa o false de lo contrario
     */
    public boolean contratarAspirante(String nombre) {
        boolean contratado = false;
        for(int i=0;i<aspirantes.size();i++){
            if(aspirantes.get(i).darNombre().equalsIgnoreCase(nombre)){
                aspirantes.remove(i);
                return true;
            }
        }
        // TODO: Realizar el ejercicio correspondiente

        return contratado;
    }

    /**
     * Elimina todos los aspirantes de la bolsa cuyos a�os de experiencia <br>
     * son menores a la cantidad de a�os especificada <br>
     *
     * @param aniosExperiencia La cantidad de a�os con relaci�n a la cual se van a eliminar los aspirantes. aniosExperiencia>=0
     * @return La cantidad de aspirantes que fueron eliminados
     */
    public int eliminarAspirantesPorExperiencia(int aniosExperiencia) {
        int eliminados = 0;
        for(int i=aspirantes.size()-1;i>=0;i--){
                if (aspirantes.get(i).darAniosExperiencia() < aniosExperiencia) {
                    aspirantes.remove(i);
                    ++eliminados;
                }
            }
        // TODO: Realizar el ejercicio correspondiente
        return eliminados;
    }
}

