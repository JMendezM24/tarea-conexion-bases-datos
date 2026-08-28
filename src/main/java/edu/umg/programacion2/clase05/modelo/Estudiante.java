package edu.umg.programacion2.clase05.modelo;

/**
 * Representa un estudiante tal como se guarda en la tabla `estudiantes`.
 *
 * IMPORTANTE: esta es una clase de dominio simple: solo datos + encapsulamiento
 * (atributos privados + getters/setters). No sabe nada de SQL ni de conexiones a
 * base de datos - esa responsabilidad es de EstudianteDAO. Separar "que es un
 * estudiante" de "como se guarda un estudiante" es una idea que van a ver una y
 * otra vez en el curso.
 */
public class Estudiante {

    private int id;
    private String nombre;
    private String carnet;
    private boolean activo;
    private String tipo;
    private String email;

    // Constructor completo (para cuando leemos de la base de datos)
    public Estudiante(int id, String nombre, String carnet, boolean activo, String tipo, String email) {
        this.id = id;
        this.nombre = nombre;
        this.carnet = carnet;
        this.activo = activo;
        this.tipo = tipo;
        this.email = email;
    }

    // Constructor de conveniencia para cuando todavia no existe en la base de
    // datos (por eso id = 0: MySQL le va a asignar el id real al insertarlo).
    // Asigna valores por defecto para activo (true) y tipo ("Pregrado").
    public Estudiante(String nombre, String carnet, String email) {
        this(0, nombre, carnet, true, "Pregrado", email);
    }

    // Constructor base (sobrecarga para mantener compatibilidad)
    public Estudiante(int id, String nombre, String carnet) {
        this(id, nombre, carnet, true, "Pregrado", null);
    }

    public Estudiante(String nombre, String carnet) {
        this(0, nombre, carnet, true, "Pregrado", null);
    }

    // --- GETTERS Y SETTERS ---

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s - Carnet: %s | Estado: %s | Tipo: %s | Email: %s",
                id, 
                nombre, 
                carnet, 
                activo ? "Activo" : "Inactivo", 
                tipo, 
                email != null ? email : "Sin registrar");
    }
}