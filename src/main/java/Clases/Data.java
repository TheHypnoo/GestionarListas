package Clases;

public class Data {
    private int dia;
    private int mes;

    public Data(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    private int any;


    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getDia() {
        return dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getMes() {
        return mes;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public int getAny() {
        return any;
    }
}
