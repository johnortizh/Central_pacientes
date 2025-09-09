package centralpacientes;

public class Paciente {
    private int id;
    private String nombre;
    private int edad;
    private String clinica;

    public Paciente(int id, String nombre, int edad, String clinica) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.clinica = clinica;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getClinica() {
        return clinica;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Nombre: %s | Edad: %d | Clínica: %s", id, nombre, edad, clinica);
    }
}
