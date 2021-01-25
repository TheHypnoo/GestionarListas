package Clases;

public class Maritimo extends Vehiculo {

    private int Longitud;
    private int Anchura;
    private int fechaFlotacion;
    private Data fechaConstruccion;

    public Maritimo(Double consumoMinimo, Double consumoActual, Double capacidadMaxima, Double consumoKilometro, char tipoVehiculo, String id, Double velocidadMedia, String idTripulante, int longitud, int anchura, int fechaFlotacion, Data fechaConstruccion) {
        super(consumoMinimo, consumoActual, capacidadMaxima, consumoKilometro, tipoVehiculo, id, velocidadMedia, idTripulante);
        Longitud = longitud;
        Anchura = anchura;
        this.fechaFlotacion = fechaFlotacion;
        this.fechaConstruccion = fechaConstruccion;
    }

    public void setLongitud(int longitud) {
        Longitud = longitud;
    }

    public int getLongitud() {
        return Longitud;
    }

    public void setAnchura(int anchura) {
        Anchura = anchura;
    }

    public int getAnchura() {
        return Anchura;
    }

    public void setFechaFlotacion(int fechaFlotacion) {
        this.fechaFlotacion = fechaFlotacion;
    }

    public int getFechaFlotacion() {
        return fechaFlotacion;
    }

    public void setFechaConstruccion(Data fechaConstruccion) {
        this.fechaConstruccion = fechaConstruccion;
    }

    public Data getFechaConstruccion() {
        return fechaConstruccion;
    }


    @Override
    public Double calculoConsumo() {
        return getConsumoMinimo() +((getConsumoActual() / getCapacidadMaxima()) * getConsumoKilometro()) * (getLongitud() + getAnchura() + getFechaFlotacion()) - (getFechaConstruccion().getDia() + getFechaConstruccion().getMes() + getFechaConstruccion().getAny());
    }

    public String mostrarInfo() {
        return super.mostrarInfo() + "\n" +
                "Longitud: " +getLongitud() + "\n" +
                "Anchura: " +getAnchura() + "\n" +
                "Fecha de Flotación: " +getFechaFlotacion() + "\n" +
                "Fecha de Construcción: " +getFechaConstruccion().getDia() + "/" +getFechaConstruccion().getMes() + "/" + +getFechaConstruccion().getAny() + "\n" +
                "Consumo medio: " +calculoConsumo() + "\n" +
                "+---------------------------------------+";
    }

}
