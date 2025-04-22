package main.models;

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
        }
    }

    protected double mostrarSaldo(){
        return this.saldo;
    }

    // CONSIGNA 5:
    // Crear un método estático llamado transferir(Cuenta origen, Cuenta destino, double monto)
    // que reste el dinero de la cuenta origen y lo deposite en la cuenta destino.
    // Si no hay saldo suficiente, debe mostrar un mensaje de error.
    public static void transferir(Cuenta origen, Cuenta destino, double monto){
        if(origen.getSaldo() >= monto){
            origen.retirar(monto);
            destino.depositar(monto);
        }else{
            System.out.println("Error... No hay saldo suficiente...");
        }
    }
}
