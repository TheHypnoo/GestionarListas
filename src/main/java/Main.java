import Clases.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    //List or ArrayList? Final or no? A la espera de saber como leer el json
    private static List<Vehiculo> listaVehiculos = new ArrayList<>();
    private static List<Personal> listaPersonal = new ArrayList<>();

    public static void main(String[] args) {
        Main Start = new Main();
        Start.menuPrincipal();

    }

    public void menuPrincipal() {
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println(Ansi.CYAN + "+---------------------------------------+");
            System.out.println(Ansi.GREEN + "+-------    Gestion de Listas  --------+");
            System.out.println(Ansi.HIGH_INTENSITY+Ansi.YELLOW + "1."+Ansi.WHITE+"Creacion de Vehiculos y Personal aleatoriamente");
            System.out.println(Ansi.YELLOW +"2."+Ansi.WHITE+"Carga de Vehiculos");
            System.out.println(Ansi.YELLOW +"3."+Ansi.WHITE+"Carga de Personal");
            System.out.println(Ansi.YELLOW +"4."+Ansi.WHITE+"Asignar personal disponible a los vehiculos");
            System.out.println(Ansi.YELLOW +"5."+Ansi.WHITE+"Mostrar información de los vehiculos");
            System.out.println(Ansi.YELLOW +"6."+Ansi.WHITE+"Salir");
            System.out.println(Ansi.CYAN + "+---------------------------------------+");
            try {
                System.out.println(Ansi.WHITE + "Escribe una de las opciones");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> {
                        creacionVehiculos();
                        creacionPersonal();
                        Writer writerPersonal = new FileWriter("listaPersonal.json");
                        writerPersonal.write(gson.toJson(listaPersonal));
                        writerPersonal.close();
                        Writer writerVehiculos = new FileWriter("listaVehiculos.json");
                        writerVehiculos.write(gson.toJson(listaVehiculos));
                        writerVehiculos.close();
                        System.out.println("La creacion de Vehiculos y personal se ha creado correctamente.");
                    }
                    case 2 ->  {
                        //Error al obtener el JSON(Hay que buscar por internet :C)
                        /*
                        JsonReader reader = new JsonReader(new FileReader("listaVehiculos.json"));
                        Type type = new TypeToken<Collection<Vehiculo>>() {
                        }.getType();
                        List<Vehiculo> result = gson.fromJson(reader, type);
                        listaVehiculos = result;

                         */
                    }
                    case 3 -> {
                    }
                    case 4, 5 -> System.out.println("No disponible actualmente");
                    case 6 -> {
                        salir = true;
                        System.out.println("Has salido.");
                        return;
                    }
                    default -> System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Error, vuelve a introducir el modo nuevamente.");

                }
            } catch (InputMismatchException | IOException e) {
                System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Debes insertar un número correspondiente al que se te indica.");
                sc.next();
            }
        }
    }

    public List<Vehiculo> creacionVehiculos(){
        String id = "Prueba";
        String idTripulante = "Prueba";
        int numeroCV;
        int numeroAverias;
        int costeAverias;
        DecimalFormat df2 = new DecimalFormat("#.##");
        for(int x = 0; x < 25; x++) {
            int queVehiculo = (int) (Math.random() * 3 + 1);
            Random r = new Random();
            //UTILIZAR ESTA FORMA PARA HACER RANDOM: r.nextInt((MAX - MIN) + 1) + MIN;
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

            if (queVehiculo == 1) {
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
            } else if (queVehiculo == 2) {
                char tipoVehiculo = 'M';
                int longitud = r.nextInt((300 - 10) + 1) + 10;
                int anchura = r.nextInt((50 - 5) + 1) + 5;
                Data fechaConstruccion = randomFecha(r);
                int fechaFlotacion = fechaConstruccion.getAny() + r.nextInt((50 - 10) + 1) + 10;
                Maritimo maritimo = new Maritimo(consumoMinimo, consumoActual, capacidadMaxima, consumoKilometro, tipoVehiculo, id , velocidadMedia, idTripulante,longitud,anchura,fechaFlotacion,fechaConstruccion);
                listaVehiculos.add(maritimo);
                //Es Maritimo
            } else if (queVehiculo == 3) {
                char tipoVehiculo = 'A';
                int tiempoFuncionamiento;
                int numeroMotores = r.nextInt((4 - 2) + 1) + 2;
                    if(numeroMotores > 2) {
                        tiempoFuncionamiento = r.nextInt((25 - 10) + 1) + 10;
                    } else {
                        tiempoFuncionamiento = r.nextInt((10 - 2) + 1) + 2;
                    }
                Aereo aereo = new Aereo(consumoMinimo, consumoActual, capacidadMaxima, consumoKilometro, tipoVehiculo, id, velocidadMedia, idTripulante,numeroMotores,tiempoFuncionamiento);
                listaVehiculos.add(aereo);
                //Es aereo
            }

        }

        return listaVehiculos;
    }

    @org.jetbrains.annotations.NotNull
    public Data randomFecha(Random r) {
        int dia = r.nextInt((30 - 1) + 1) + 1;
        int mes = r.nextInt((12 - 1) + 1) + 1;
        int anyo = r.nextInt((2021 - 1950) + 1) + 1950;
        return new Data(dia,mes,anyo);
    }

    public List<Personal> creacionPersonal(){

        Random r = new Random();
        String dniCompleto;
        for(int x = 0; x < 25; x++) {
            //Generar DNI
            int dniAleatorio = r.nextInt((99999999 - 10000000) + 1) + 10000000;
            dniCompleto = calculaLetraDNI(dniAleatorio);
            String nombre = generarNombresAleatorios();
            Data fechaAleatoria = randomFecha(r);
            Personal personal = new Personal(dniCompleto,nombre,fechaAleatoria,' ', false);
            listaPersonal.add(personal);
        }

        return listaPersonal;
    }

    public String calculaLetraDNI(int dni){
        //El string de letras es fijo y deberían de ir en este orden
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        //La letra correspondiente será el resto de la división del número del DNI entre las 23 posibilidades que hay
        char letra = letras.charAt(dni % letras.length());
        String dniEntero = "" + dni + letra;
        return dniEntero;
    }

    public static String generarNombresAleatorios() {

        String nombre = null;
        //buscar nombres con json o api
        String[] nombres = { "Andrea", "David", "Martin", "Sergio", "Yaiza", "Jose", "Addison", "Kameron",
                "Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
                "Caritina", "Carlota", "Dennis"};

        for(int x = 0; x < 1; x++) {
            nombre = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))];
        }

        return nombre;
    }

}
