package Modelo;

public class Ninja {

    private int id;
    private String nombre;
    private String rango;
    private int id_aldea;

    public Ninja() {
    }

    public Ninja(int id, String nombre, String rango, int id_aldea) {
        this.id = id;
        this.nombre = nombre;
        this.rango = rango;
        this.id_aldea = id_aldea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public int getId_aldea() {
        return id_aldea;
    }

    public void setId_aldea(int id_aldea) {
        this.id_aldea = id_aldea;
    }
}
