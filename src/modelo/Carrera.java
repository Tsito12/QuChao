package modelo;

public class Carrera {
    private int idcarrera;
    private int noParticpantes;
    private String fecha;
    private int noVueltas;
    private String hora;

    public Carrera(int idcarrera, int noParticpantes, String fecha, int noVueltas, String hora) {
        this.idcarrera = idcarrera;
        this.noParticpantes = noParticpantes;
        this.fecha = fecha;
        this.noVueltas = noVueltas;
        this.hora = hora;
    }
    public Carrera(){}

    public int getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }

    public int getNoParticpantes() {
        return noParticpantes;
    }

    public void setNoParticpantes(int noParticpantes) {
        this.noParticpantes = noParticpantes;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNoVueltas() {
        return noVueltas;
    }

    public void setNoVueltas(int noVueltas) {
        this.noVueltas = noVueltas;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
