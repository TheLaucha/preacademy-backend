package main.BankExercise;

public abstract class Cuenta {
    private double saldo;
    private String numeroCuenta;

    public Cuenta(double saldo, String numeroCuenta){
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        if (this.saldo <= 0){
            System.out.println("No tiene saldo disponible...");
        }
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double monto){
        this.saldo += monto;
    }

    public void retirar(double monto){
        if (this.saldo >= monto){
            this.saldo -= monto;
        }else{
            throw new IllegalArgumentException("Saldo insuficente");
        }
    }

    protected double mostrarSaldo(){
        return this.saldo;
    }

    // CONSIGNA 5:
    // ?? Consultar si esta bien que el metodo static este aca.
    public static void transferir(Cuenta origen, Cuenta destino, double monto){
        if(origen.getSaldo() >= monto){
            origen.retirar(monto);
            destino.depositar(monto);
        }else{
            throw new IllegalArgumentException("No hay saldo suficiente");
        }
    }
}
