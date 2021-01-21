package Clases;

public class Aereo extends Vehiculo {

    private int numeroMotores;
    private int tiempoFuncionamiento;

    public Aereo(Double consumoMinimo, Double consumoActual, Double capacidadMaxima, Double consumoKilometro, char tipoVehiculo, String id, Double velocidadMedia, String idTripulante, int numeroMotores, int tiempoFuncionamiento) {
        super(consumoMinimo, consumoActual, capacidadMaxima, consumoKilometro, tipoVehiculo, id, velocidadMedia, idTripulante);
        this.numeroMotores = numeroMotores;
        this.tiempoFuncionamiento = tiempoFuncionamiento;
    }

    public void setNumeroMotores(int numeroMotores) {
        this.numeroMotores = numeroMotores;
    }

    public int getNumeroMotores() {
        return numeroMotores;
    }

    public void setTiempoFuncionamiento(int tiempoFuncionamiento) {
        this.tiempoFuncionamiento = tiempoFuncionamiento;
    }

    public int getTiempoFuncionamiento() {
        return tiempoFuncionamiento;
    }

    @Override
    public Double calculoConsumo() {
        Double Consumo;
        Consumo = getConsumoMinimo() + ((getConsumoActual() / getCapacidadMaxima()) * getConsumoKilometro()) + (getNumeroMotores() * getTiempoFuncionamiento());
        return Consumo;
    }
}
