package centralpacientes;

public class ListaPacientes {
    private NodoPaciente cabeza;
    private int siguienteId;

    public ListaPacientes() {
        this.cabeza = null;
        this.siguienteId = 1;
    }

    public Paciente agregarPaciente(String nombre, int edad, String clinica) {
        Paciente nuevoPaciente = new Paciente(siguienteId++, nombre, edad, clinica);
        NodoPaciente nuevoNodo = new NodoPaciente(nuevoPaciente);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoPaciente actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        return nuevoPaciente;
    }

    public Paciente buscarPacientePorId(int id) {
        NodoPaciente actual = cabeza;
        while (actual != null) {
            if (actual.paciente.getId() == id) {
                return actual.paciente;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public boolean eliminarPacientePorId(int id) {
        if (cabeza == null) return false;

        if (cabeza.paciente.getId() == id) {
            cabeza = cabeza.siguiente;
            return true;
        }

        NodoPaciente anterior = cabeza;
        NodoPaciente actual = cabeza.siguiente;

        while (actual != null) {
            if (actual.paciente.getId() == id) {
                anterior.siguiente = actual.siguiente;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }

    public void mostrarTodosPacientes() {
        if (cabeza == null) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        System.out.println("\n--- Lista de pacientes ---");
        NodoPaciente actual = cabeza;
        while (actual != null) {
            System.out.println(actual.paciente);
            actual = actual.siguiente;
        }
    }
}
