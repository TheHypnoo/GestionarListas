package Clases;

public class Maritimo extends Vehiculo {

    private int Longitud;
    private int Anchura;
    private int fechaFlotacion;
    private Data fechaConstruccion;


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

    //A falta de añadir La data...
    @Override
    public Double calculoConsumo() {
        Double Consumo;
        Consumo = getConsumoMinimo() +((getConsumoActual() / getCapacidadMaxima()) * getConsumoKilometro()) * (getLongitud() + getAnchura() + getFechaFlotacion());
        return Consumo;
    }

}
