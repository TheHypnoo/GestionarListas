package Clases;


public abstract class Vehiculo {

    private Double consumoMinimo;
    private Double consumoActual;
    private Double capacidadMaxima;
    private Double consumoKilometro;
    private char tipoVehiculo;
    private String id;
    private Double velocidadMedia;
    private String idTripulante;

    public Vehiculo(Double consumoMinimo, Double consumoActual, Double capacidadMaxima, Double consumoKilometro, char tipoVehiculo, String id, Double velocidadMedia, String idTripulante) {
        this.consumoMinimo = consumoMinimo;
        this.consumoActual = consumoActual;
        this.capacidadMaxima = capacidadMaxima;
        this.consumoKilometro = consumoKilometro;
        this.tipoVehiculo = tipoVehiculo;
        this.id = id;
        this.velocidadMedia = velocidadMedia;
        this.idTripulante = idTripulante;
    }

    public void setConsumoMinimo(Double consumoMinimo) {
        this.consumoMinimo = consumoMinimo;
    }

    public Double getConsumoMinimo() {
        return consumoMinimo;
    }

    public void setConsumoActual(Double consumoActual) {
        this.consumoActual = consumoActual;
    }

    public Double getConsumoActual() {
        return consumoActual;
    }

    public void setCapacidadMaxima(Double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setConsumoKilometro(Double consumoKilometro) {
        this.consumoKilometro = consumoKilometro;
    }

    public Double getConsumoKilometro() {
        return consumoKilometro;
    }

    public void setTipoVehiculo(char tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public char getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setVelocidadMedia(Double velocidadMedia) {
        this.velocidadMedia = velocidadMedia;
    }

    public Double getVelocidadMedia() {
        return velocidadMedia;
    }

    public void setIdTripulante(String idTripulante) {
        this.idTripulante = idTripulante;
    }

    public String getIdTripulante() {
        return idTripulante;
    }

    public abstract Double calculoConsumo();

    public String mostrarInfo(){
        return "+---------------------------------------+" + "\n" +
                "ID del Vehiculo: "+getId() + "\n" +
                "Tipo de vehiculo: "+getTipoVehiculo() + "\n" +
                "ID del Personal: " +getIdTripulante() + "\n" +
                "Consumo minimo: " +getConsumoMinimo() + "\n" +
                "Consumo actual: " +getConsumoActual() + "\n" +
                "Capacidad Maxima: " +getCapacidadMaxima() + "\n" +
                "Consumo por Kilometro: " +getConsumoKilometro() + "\n" +
                "Velocidad Media: " +getVelocidadMedia();
    }

}
