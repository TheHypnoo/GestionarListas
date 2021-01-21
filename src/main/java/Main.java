import Clases.Personal;
import Clases.Terrestre;
import Clases.Vehiculo;
import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    //private static final Gson gson = new Gson();
    private static final ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    private static final ArrayList<Personal> listaPersonal = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Main Start = new Main();
        //Start.menuPrincipal();

        Terrestre terrestre = new Terrestre();
        terrestre.setId("1");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(listaPersonal);
        System.out.println("Prueba: "+gson.toJson(listaPersonal));

        Writer writer = new FileWriter("volcado.json");
        writer.write(gson.toJson(terrestre));
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





}
