package main.serie;

import java.util.List;

public class Temporada {
    private List<Episodio> episodios;

    public Temporada(List<Episodio> episodios){
        this.episodios = episodios;
    }

    public int totalDeEpisodiosVistos(){
        return (int) this.episodios.stream()
                .filter(ep -> ep.getFueVisto())
                .count();
    }

    public double calificacionPromedio(){
        return this.episodios.stream()
                .filter(ep -> ep.getFueVisto() && ep.getCalificacion() >= 0)
                .mapToDouble(ep -> ep.getCalificacion())
                .average()
                .orElse(0);
    }

    public int getCantEpisodios(){
        return this.episodios.size();
    }
}
