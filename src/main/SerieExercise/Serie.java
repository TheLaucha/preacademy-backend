package main.SerieExercise;

import java.util.List;

public class Serie {
    private String titulo;
    private String descripcion;
    private String creador;
    private String genero;
    private List<Temporada> temporadas;

    public Serie(String titulo, String descripcion, String creador, String genero, List<Temporada> temporadas){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.creador = creador;
        this.genero = genero;
        this.temporadas = temporadas;
    }

    public int totalEpisodiosVistos(){
        return this.temporadas
                .stream()
                .mapToInt(temp -> temp.totalDeEpisodiosVistos())
                .sum();
    }

    public double calificacionPromedioSerie(){
        return this.temporadas.stream()
                .mapToDouble(temp -> temp.calificacionPromedio())
                .average()
                .orElse(0);
    }

    public boolean vioTodo(){
        return this.totalEpisodiosVistos() == this.cantEpisodiosTotales();
    }

    private int cantEpisodiosTotales(){
        return this.temporadas
                .stream()
                .mapToInt(temp -> temp.getCantEpisodios())
                .sum();
    }
}
