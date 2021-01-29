import Clases.*;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    private static final ArrayList<Personal> listaPersonal = new ArrayList<>();
    private static final ArrayList<String> historial = new ArrayList<>();
    private static boolean cargadosVehiculos = false;
    private static boolean cargadosPersonal = false;
    private final int NUMERO_CREACION = 4;

    public static void main(String[] args) {
        Main Start = new Main();
        Start.menuPrincipal();

    }

    public void menuPrincipal() {

        int opcion;
        boolean salir = false;
        while (!salir) {
            if(historial.size() != 0) {
                System.out.println("+------------Gestor de Historial------------+");
                muestraHistorial();
                System.out.println("+---------------------------------------+");
            }
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
                        System.out.println("La creacion de Vehiculos y personal se ha creado correctamente.");
                    }
                    case 2 ->  {
                            if(!cargadosVehiculos) {
                                JsonReader leerTerrestre = new JsonReader(new FileReader("listaTerrestre.json"));
                                JsonReader leerMaritimo = new JsonReader(new FileReader("listaMaritimo.json"));
                                JsonReader leerAereo = new JsonReader(new FileReader("listaAereo.json"));

                                Terrestre[] auxTerrestre = gson.fromJson(leerTerrestre, Terrestre[].class);

                                Maritimo[] auxMaritimo = gson.fromJson(leerMaritimo, Maritimo[].class);

                                Aereo[] auxAereo = gson.fromJson(leerAereo, Aereo[].class);

                                listaVehiculos.addAll(Arrays.asList(auxTerrestre));
                                listaVehiculos.addAll(Arrays.asList(auxMaritimo));
                                listaVehiculos.addAll(Arrays.asList(auxAereo));
                                cargadosVehiculos = true;

                                System.out.println("Ya has importado todos los vehiculos");
                            } else {
                                System.out.println("Para que quieres cargarlos de nuevo si ya estan cargados?!");
                            }
                    }
                    case 3 -> {
                        if(!cargadosPersonal) {
                            JsonReader leerPersonal = new JsonReader(new FileReader("listaPersonal.json"));
                            Personal[]  auxPersonal = gson.fromJson(leerPersonal, Personal[].class);
                            listaPersonal.addAll(Arrays.asList(auxPersonal));
                            System.out.println("Ya has importado todos el Personal");
                            cargadosPersonal = true;
                        } else {
                            System.out.println("Para que quieres cargarlo de nuevo si ya estan cargados?!");
                        }

                    }
                    case 4 -> {
                        if(cargadosPersonal && cargadosVehiculos) {
                            muestraPersonalnoAsignado();
                        } else {
                            System.out.println("No esta cargado el Personal o el Vehiculo, entonces como vas a asignar el personal?");
                        }
                    }
                    case 5 -> {
                        if(cargadosPersonal && cargadosVehiculos) {
                            muestraVehiculos();
                        } else {
                            System.out.println("No esta cargado el Personal o el Vehiculo, entonces como vas a mostrar los vehiculos?");
                        }
                    }
                    case 6 -> {
                        salir = true;
                        System.out.println("Has salido.");
                        return;
                    }
                    default -> System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Error, vuelve a introducir el modo nuevamente."+ Ansi.WHITE);

                }
            } catch (InputMismatchException | IOException e) {
                System.out.println(Ansi.RED + Ansi.HIGH_INTENSITY + "Debes insertar un número correspondiente al que se te indica."+ Ansi.WHITE);
                sc.next();
            }
        }
    }

    public void creacionVehiculos() throws IOException {

        ArrayList<Vehiculo> auxTerrestre = new ArrayList<>();
        ArrayList<Vehiculo> auxMaritimo = new ArrayList<>();
        ArrayList<Vehiculo> auxAereo = new ArrayList<>();
        String id;
        String idTripulante = "";
        int numeroCV;
        int numeroAverias;
        int costeAverias;
        DecimalFormat df2 = new DecimalFormat("#.##");
        for(int x = 0; x < NUMERO_CREACION; x++) {
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
                id = generarMatricula();
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
                auxTerrestre.add(terrestre);
                //Es terrestre
            } else if (queVehiculo == 2) {
                id = generarMatricula();
                char tipoVehiculo = 'M';
                int longitud = r.nextInt((300 - 10) + 1) + 10;
                int anchura = r.nextInt((50 - 5) + 1) + 5;
                Data fechaConstruccion = randomFecha(r);
                int fechaFlotacion = fechaConstruccion.getAny() + r.nextInt((50 - 10) + 1) + 10;
                Maritimo maritimo = new Maritimo(consumoMinimo, consumoActual, capacidadMaxima, consumoKilometro, tipoVehiculo, id , velocidadMedia, idTripulante,longitud,anchura,fechaFlotacion,fechaConstruccion);
                auxMaritimo.add(maritimo);
                //Es Maritimo
            } else if (queVehiculo == 3) {
                id = generarMatricula();
                char tipoVehiculo = 'A';
                int tiempoFuncionamiento;
                int numeroMotores = r.nextInt((4 - 2) + 1) + 2;
                    if(numeroMotores > 2) {
                        tiempoFuncionamiento = r.nextInt((25 - 10) + 1) + 10;
                    } else {
                        tiempoFuncionamiento = r.nextInt((10 - 2) + 1) + 2;
                    }
                Aereo aereo = new Aereo(consumoMinimo, consumoActual, capacidadMaxima, consumoKilometro, tipoVehiculo, id, velocidadMedia, idTripulante,numeroMotores,tiempoFuncionamiento);
                auxAereo.add(aereo);
                //Es aereo
            }

        }

        Writer writerTerrestre = new FileWriter("listaTerrestre.json");

        writerTerrestre.write(gson.toJson(auxTerrestre));
        writerTerrestre.close();

        Writer writerMaritimo = new FileWriter("listaMaritimo.json");
        writerMaritimo.write(gson.toJson(auxMaritimo));
        writerMaritimo.close();

        Writer writerAereo = new FileWriter("listaAereo.json");
        writerAereo.write(gson.toJson(auxAereo));
        writerAereo.close();
    }

    public String generarMatricula() {
        StringBuilder matricula = new StringBuilder();
        int a;
        String CaracteresNoDeseados = "AEIOU";
        for (int i = 0; i < 7; i++) {
            if (i < 4) {    // 0,1,2,3 posiciones de numeros
                matricula.insert(0, (int) (Math.random() * 9) + "");

            } else {       // 4,5,6 posiciones de letras
                do {
                    a = (int) (Math.random() * 26 + 65);///
                } while (CaracteresNoDeseados.indexOf(a) >= 0);

                char letra = (char) a;
                if (i == 4) {
                    matricula.append("-").append(letra);
                } else {
                    matricula.append(letra);
                }
            }
        }
        System.out.println("Matricula: "+matricula.toString());
        return matricula.toString();
    }

    @org.jetbrains.annotations.NotNull
    public Data randomFecha(Random r) {
        int dia = r.nextInt((30 - 1) + 1) + 1;
        int mes = r.nextInt((12 - 1) + 1) + 1;
        int anyo = r.nextInt((2021 - 1950) + 1) + 1950;
        return new Data(dia,mes,anyo);
    }

    public void creacionPersonal() throws IOException {

        Random r = new Random();
        String dniCompleto;
        char especialidad = ' ';
        for(int x = 0; x < NUMERO_CREACION; x++) {
            int especialidadVehiculoPersonal = r.nextInt((3 - 1) + 1) + 1;
            //Generar DNI
            int dniAleatorio = r.nextInt((99999999 - 10000000) + 1) + 10000000;
            dniCompleto = calculaLetraDNI(dniAleatorio);
            String nombre = generarNombresAleatorios();
            Data fechaAleatoria = randomFecha(r);
            if(especialidadVehiculoPersonal == 1) {
                especialidad = 'T';
            } else if(especialidadVehiculoPersonal == 2) {
                especialidad = 'M';
            } else if(especialidadVehiculoPersonal == 3) {
                especialidad = 'A';
            }
            Personal personal = new Personal(dniCompleto,nombre,fechaAleatoria,especialidad, false);
            listaPersonal.add(personal);
        }

        Writer writerPersonal = new FileWriter("listaPersonal.json");
        writerPersonal.write(gson.toJson(listaPersonal));
        writerPersonal.close();

    }

    public String calculaLetraDNI(int dni){
        //El string de letras es fijo y deberían de ir en este orden
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        //La letra correspondiente será el resto de la división del número del DNI entre las 23 posibilidades que hay
        char letra = letras.charAt(dni % letras.length());
        return "" + dni + letra;
    }

    public static String generarNombresAleatorios() {

        String nombre = null;
        //buscar nombres con json o api
        String[] nombres = { "Andrea", "David", "Martin", "Sergio", "Yaiza", "Jose", "Addison", "Kameron",
                "Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
                "Caritina", "Carlota", "Dennis"};

        for(int x = 0; x < 1; x++) {
            nombre = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) + 1) + 0))];
        }

        return nombre;
    }

    public static void muestraPersonalnoAsignado() {


        for (Personal value : listaPersonal) {
            if (!value.getAsignado()) {
                System.out.println(value.mostrarInfo());
            }
        }

        System.out.println("Escribe el NIF de la persona para escogerla");
        String decidePersona = sc.next();

        for (Personal personal : listaPersonal) {
            if (decidePersona.equalsIgnoreCase(personal.getNif())) {
                if (personal.getAsignado()) {
                    System.out.println(Ansi.RED+"Esa persona ya esta asignada a un vehiculo");
                    break;
                } else {
                    muestraVehiculos();
                    System.out.println("Escribeme la matricula del vehiculo(Recuerda que la especialidad debe ser la misma que la persona escogida)");
                    String matricula = sc.next();
                    for (Vehiculo vehiculos : listaVehiculos) {
                        if (matricula.equalsIgnoreCase(vehiculos.getId())) {
                            if (personal.getEspecialidadVehiculo() == vehiculos.getTipoVehiculo()) {
                                personal.setAsignado(true);
                                vehiculos.setIdTripulante(personal.getNif());
                                historial.add("Nombre: "+personal.getNombre() + " con NIF: "+personal.getNif() + " Esta asignado al vehiculo con matricula: " +vehiculos.getId());
                                System.out.println("Ya se ha asignado la persona al vehiculo");
                            } else {
                                System.out.println(Ansi.RED+"La especialidad del vehiculo no es igual a la de la persona."+ Ansi.WHITE);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void muestraVehiculos(){
        for (Vehiculo listaVehiculo : listaVehiculos) {
            System.out.println(listaVehiculo.mostrarInfo());
        }
    }

    public static void muestraHistorial(){
        for (String s : historial) {
            System.out.println(Ansi.YELLOW + s + Ansi.WHITE);
        }
    }



}
