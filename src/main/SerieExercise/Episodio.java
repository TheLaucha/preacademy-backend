package main.SerieExercise;

public class Episodio {
    private String titulo;
    private String descripcion;
    private boolean fueVisto;
    private double calificacion = -1;

    public Episodio(String titulo, String descripcion){
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public boolean getFueVisto(){
        return this.fueVisto;
    }

    public void setFueVisto(boolean fueVisto){
        this.fueVisto = fueVisto;
    }

    public void setCalificacion(double calificacion) {
        if (calificacion < 0 || calificacion > 10){
            System.out.println("La calificacion debe ser un valor entre 0 y 10 inclusive...");
        }else{
            this.calificacion = calificacion;
        }
    }

    public double getCalificacion(){
        return this.calificacion;
    }
}
