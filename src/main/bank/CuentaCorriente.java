package main.bank;

public class CuentaCorriente extends Cuenta{
    final private double saldoMaximoPermitido = -1000;

    public CuentaCorriente(double saldo, String numeroCuenta){
        super(saldo, numeroCuenta);
    }

    @Override
    public void retirar(double monto) {
        double saldoAct = this.getSaldo();

        if (saldoAct - monto >= saldoMaximoPermitido){
            this.setSaldo(saldoAct - monto);
        }else{
            throw new IllegalArgumentException("Saldo insuficente");
        }
    }
}
