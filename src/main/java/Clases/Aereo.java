package Clases;

public class Aereo extends Vehiculo {

    private int numeroMotores;
    private int tiempoFuncionamiento;

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
