import Clases.Personal;
import Clases.Terrestre;
import Clases.Vehiculo;
import com.google.gson.*;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    //private static final Gson gson = new Gson();
    private static final ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    private static final ArrayList<Personal> listaPersonal = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Main Start = new Main();
        //Start.menuPrincipal();
        Start.creacionVehiculos();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //System.out.println("Prueba: "+gson.toJson(listaPersonal));

        Writer writer = new FileWriter("volcado.json");
        writer.write(gson.toJson(listaVehiculos));
        writer.close();

        Reader reader = new FileReader("volcado.json");



    }

    public void menuPrincipal() {
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println(Ansi.CYAN + "+---------------------------------------+");
            System.out.println(Ansi.GREEN + "+-------    Gestion de Listas  --------+");
            System.out.println(Ansi.HIGH_INTENSITY+Ansi.YELLOW + "1."+Ansi.WHITE+"CACA1");
            System.out.println(Ansi.YELLOW +"2."+Ansi.WHITE+"CACA2");
            System.out.println(Ansi.YELLOW +"3."+Ansi.WHITE+"CACA3");
            System.out.println(Ansi.YELLOW +"4."+Ansi.WHITE+"CACA4");
            System.out.println(Ansi.YELLOW +"5."+Ansi.WHITE+"CACA5");
            System.out.println(Ansi.YELLOW +"6."+Ansi.WHITE+"Salir");
            System.out.println(Ansi.CYAN + "+---------------------------------------+");
            try {
                System.out.println(Ansi.WHITE + "Escribe una de las opciones");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> System.out.println("A");
                    case 2 -> System.out.println("Sw");
                    case 3 -> System.out.println("Be");
                    case 4 -> System.out.println("Pa");
                    case 5 -> System.out.println("Poh");
                    case 6 -> {
                        salir = true;
                        System.out.println("Has salido.");
                        return;
                    }
                    default -> System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Error, vuelve a introducir el modo nuevamente.");

                }
            } catch (InputMismatchException e) {
                System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Debes insertar un número correspondiente al que se te indica.");
                sc.next();
            }
        }
    }


    public ArrayList<Vehiculo> creacionVehiculos(){
        String id = "Prueba";
        String idTripulante = "Prueba";
        int numeroCV;
        int numeroAverias;
        int costeAverias;
        DecimalFormat df2 = new DecimalFormat("#.##");
        for(int x = 0; x < 25; x++) {
            //consumoMinimo, consumoActual, capacidadMaxima, consumoKilometro, tipoVehiculo, id, velocidadMedia, idTripulante
            //Debo crear los consumos Minimo,Actual y su capacidadMaxima. Además de contabilizar el Consumo por kilometro (maybe 1l/12km)
            int queVehiculo = (int) (Math.random() * 3 + 1);
            Random r = new Random();
            double consumoMinimo = 4 + (15 - 4) * r.nextDouble();
            consumoMinimo = Double.parseDouble(df2.format(consumoMinimo).replaceAll(",","."));

            double capacidadMaxima = 50 + (100 - 50) *  r.nextDouble();
            capacidadMaxima = Double.parseDouble(df2.format(capacidadMaxima).replaceAll(",","."));
            double consumoKilometro = 100/capacidadMaxima;
            consumoKilometro = Double.parseDouble(df2.format(consumoKilometro).replaceAll(",","."));
            double velocidadMedia = consumoKilometro * 100;
            velocidadMedia = Double.parseDouble(df2.format(velocidadMedia).replaceAll(",","."));
            double litrosConsumidos = capacidadMaxima / 2;
            litrosConsumidos = Double.parseDouble(df2.format(litrosConsumidos).replaceAll(",","."));
            //Rectificar el consumoActual que sea diferenciado por la velocidadMedia
            double consumoActual = litrosConsumidos * 100 / 100;
            consumoActual = Double.parseDouble(df2.format(consumoActual).replaceAll(",","."));

            //if (queVehiculo == 1) {
                char tipoVehiculo = 'T';
                if(velocidadMedia > 120) {
                    numeroCV = (int) (110 + (velocidadMedia - 110) * r.nextDouble());
                    numeroAverias = (int) (10 + (30 - 10) * r.nextDouble());
                    costeAverias = (int) ((450 + (numeroAverias * 450) - 450) * r.nextDouble());
                } else {
                    numeroCV = (int) (60 + (velocidadMedia - 60) * r.nextDouble());
                    numeroAverias = (int) (1 + (10 - 1) * r.nextDouble());
                    costeAverias = (int) ((100 + (numeroAverias * 100) - 100) * r.nextDouble());
                }
                Terrestre terrestre = new Terrestre(consumoMinimo, consumoActual, capacidadMaxima, consumoKilometro, tipoVehiculo, id, velocidadMedia, idTripulante, numeroCV, numeroAverias,costeAverias);
                listaVehiculos.add(terrestre);
                //Es terrestre
            /*} else if (queVehiculo == 2) {
                char tipoVehiculo = 'M';
                //Es Maritimo
            } else if (queVehiculo == 3) {
                char tipoVehiculo = 'A';
                //Es aereo
            }
             */
        }

        return listaVehiculos;
    }

    public ArrayList<Personal> creacionPersonal(){

        Random r = new Random();
        //Generar DNI

        return listaPersonal;
    }



}
