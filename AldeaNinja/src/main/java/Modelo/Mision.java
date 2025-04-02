package Modelo;

public class Mision {

    private int id;
    private String descripcion;
    private String rango;
    private long recompensa;

    public Mision() {}

    public Mision(int id, String descripcion, String rango, long recompensa) {
        this.id = id;
        this.descripcion = descripcion;
        this.rango = rango;
        this.recompensa = recompensa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public long getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(long recompensa) {
        this.recompensa = recompensa;
    }
}
