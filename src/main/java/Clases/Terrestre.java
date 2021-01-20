package Clases;

public class Terrestre extends Vehiculo {

    private int numeroCV;
    private int numeroAveries;
    private int costeAverias;

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
        Double Consumo;
        Consumo = getConsumoMinimo() + ((getConsumoActual() / getCapacidadMaxima()) * getConsumoKilometro()) + getNumeroAveries() * getCosteAverias();
        return Consumo;
    }
}
