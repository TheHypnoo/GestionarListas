package Clases;

public class Personal {

    private String Nif;
    private String Nombre;
    private Data fechaNacimiento;
    private char especialidadVehiculo;
    private boolean Asignado;

    public Personal(String nif, String nombre, Data fechaNacimiento, char especialidadVehiculo, boolean asignado) {
        Nif = nif;
        Nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.especialidadVehiculo = especialidadVehiculo;
        Asignado = asignado;
    }


    public void setNif(String nif) {
        Nif = nif;
    }

    public String getNif() {
        return Nif;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setFechaNacimiento(Data fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Data getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setEspecialidadVehiculo(char especialidadVehiculo) {
        this.especialidadVehiculo = especialidadVehiculo;
    }

    public char getEspecialidadVehiculo() {
        return especialidadVehiculo;
    }

    public void setAsignado(boolean asignado) {
        Asignado = asignado;
    }

    public boolean getAsignado() {
        return Asignado;
    }

}
