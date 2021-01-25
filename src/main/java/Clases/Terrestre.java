package Clases;

public class Terrestre extends Vehiculo {

    private int numeroCV;
    private int numeroAveries;
    private int costeAverias;

    public Terrestre(Double consumoMinimo, Double consumoActual, Double capacidadMaxima, Double consumoKilometro, char tipoVehiculo, String id, Double velocidadMedia, String idTripulante,int numeroCV, int numeroAveries, int costeAverias) {
        super(consumoMinimo, consumoActual, capacidadMaxima, consumoKilometro, tipoVehiculo, id, velocidadMedia, idTripulante);
        this.numeroCV = numeroCV;
        this.numeroAveries = numeroAveries;
        this.costeAverias = costeAverias;
    }


    public void setNumeroCV(int numeroCV) {
        this.numeroCV = numeroCV;
    }

    public int getNumeroCV() {
        return numeroCV;
    }

    public void setNumeroAveries(int numeroAveries) {
        this.numeroAveries = numeroAveries;
    }

    public int getNumeroAveries() {
        return numeroAveries;
    }

    public void setCosteAverias(int costeAverias) {
        this.costeAverias = costeAverias;
    }

    public int getCosteAverias() {
        return costeAverias;
    }

    @Override
    public Double calculoConsumo() {
        return getConsumoMinimo() + ((getConsumoActual() / getCapacidadMaxima()) * getConsumoKilometro()) + getNumeroAveries() * getCosteAverias();
    }

    public String mostrarInfo(){

        return super.mostrarInfo() + "\n" +
                "Numero de CV del Vehiculo: " +getNumeroCV() + "\n" +
                "Numero de Averias: " +getNumeroAveries() + "\n" +
                "Coste de las Averias: " +getCosteAverias() + "\n" +
                "Consumo medio: " +calculoConsumo() + "\n" +
                "+---------------------------------------+";
    }
}
