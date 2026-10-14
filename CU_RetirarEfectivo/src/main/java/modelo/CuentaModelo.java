package modelo;

public class CuentaModelo {
    

    //datos del cliente y de su cuenta
    private String nombreCliente;
    private String ultimosDigitosCuenta;
    private double saldoActual;
    private double comision;

    //constructor para inicializar la cuenta del usuario
    public CuentaModelo(String nombreCliente, String ultimosDigitosCuenta, double saldoActual, double comision) {
        this.nombreCliente = nombreCliente;
        this.ultimosDigitosCuenta = ultimosDigitosCuenta;
        this.saldoActual = saldoActual;
        this.comision = comision;
    }

    //metodos para obtener la informacion guardada
    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getUltimosDigitosCuenta() {
        return ultimosDigitosCuenta;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public double getComision() {
        return comision;
    }

    //calcula cuanto dinero queda antes de hacer el retiro
    public double calcularMontoFinal(double monto) {
        return saldoActual - (monto + comision);
    }

    //resta el dinero y la comision del saldo disponible si hay suficiente dinero
    public boolean debitarMonto(double monto) {
        double totalADebitar = monto + comision;
        if (saldoActual >= totalADebitar) {
            saldoActual -= totalADebitar;
            return true;
        }
        return false;
    }
}


