import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class main {

    public static void main(String[] args){
        BufferedReader br = null;
        Stream<Persona> menores = null;
        List<Persona> personas = new ArrayList<>();

        try{
            br = new BufferedReader(new FileReader("fichero.txt"));
            String line;

            while((line = br.readLine())!=null){
                String name = getDataOptional(line.split(":"), 0).orElse("Desconocido");
                String city = getDataOptional(line.split(":"), 1).orElse("Desconocida");
                String age = getDataOptional(line.split(":"), 2).orElse("Desconocida");
                Persona p = new Persona(name, city, age);
                personas.add(p);
                System.out.println("Nombre: "+p.getName()+". Poblacion: "+p.getCity()+". Edad: "+p.getAge());
            }
            System.out.println("\nMenores de 25 años:");
            personas.stream().filter(e -> parseInt(e.getAge()) < 25).forEach(e-> System.out.println("Nombre: "+e.getName()));


        } catch (FileNotFoundException e){
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        }
    }

    public static Optional<String> getDataOptional(String[] data, int index){
        try{
            if(data[index].isEmpty()) return Optional.empty();
            return Optional.of(data[index]);
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }
}
