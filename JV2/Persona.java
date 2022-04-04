public class Persona {
    private String name, city, age;


    Persona(String nombre, String poblacion, String edad){
        this.name = nombre;
        this.city = poblacion;
        this.age = edad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }



}
