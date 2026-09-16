package arraylist;

public class PartidoFutbol {
    private String equipoLocal;
    private String equipoVisitante;
    private int golLocal;
    private int golVisitante;

    // Getters y Setters que usó el profesor
    public String getEquipoLocal() { return equipoLocal; }
    public void setEquipoLocal(String equipoLocal) { this.equipoLocal = equipoLocal; }

    public String getEquipoVisitante() { return equipoVisitante; }
    public void setEquipoVisitante(String equipoVisitante) { this.equipoVisitante = equipoVisitante; }

    public int getGolLocal() { return golLocal; }
    public void setGolLocal(int golLocal) { this.golLocal = golLocal; }

    public int getGolVisitante() { return golVisitante; }
    public void setGolVisitante(int golVisitante) { this.golVisitante = golVisitante; }

    // Métodos auxiliares para simplificar condiciones
    public boolean ganoVisitante() { return golVisitante > golLocal; }
    public boolean ganoLocal() { return golLocal > golVisitante; }
    public boolean esEmpate() { return golLocal == golVisitante; }

    @Override
    public String toString() {
        return equipoLocal + " " + golLocal + " - " + golVisitante + " " + equipoVisitante;
    }
}