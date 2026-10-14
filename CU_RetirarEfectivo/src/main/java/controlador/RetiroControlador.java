package controlador;

import modelo.CuentaModelo;
import vista.RetiroVista;

    public class RetiroControlador {
    private CuentaModelo modelo;
    private RetiroVista vista;

    //conecta los datos de la cuenta con lo que se muestra en pantalla
    public RetiroControlador(CuentaModelo modelo, RetiroVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    //organiza todos los pasos en orden segun lo que responde el cliente
    public void procesarRetiro() {
        //paso 1 muestra las opciones de montos y lee la opcion seleccionada
        int opcion = vista.mostrarMenuMontos();
        double monto = obtenerMonto(opcion);

        //si elige una opcion no valida detiene el proceso
        if (monto == 0.0) {
            vista.mostrarMensaje("Opcion no valida. Operacion cancelada.");
            return;
        }

        //paso 2 calcula comisiones y muestra el resumen del estado de cuenta
        double comision = modelo.getComision();
        double montoFinal = modelo.calcularMontoFinal(monto);

        vista.mostrarEstadoCuenta(
            modelo.getNombreCliente(),
            modelo.getSaldoActual(),
            monto,
            comision,
            montoFinal
        );

        //paso 3 pide confirmacion para continuar con la operacion
        boolean confirmado = vista.solicitarConfirmacion();

        if (confirmado) {
            //paso 4 si todo esta bien descuenta el dinero e imprime el recibo
            boolean exito = modelo.debitarMonto(monto);
            if (exito) {
                vista.mostrarRecibo(
                    modelo.getUltimosDigitosCuenta(),
                    modelo.getNombreCliente(),
                    monto,
                    comision
                );
            } else {
                vista.mostrarMensaje("Saldo insuficiente para realizar el retiro.");
            }
        } else {
            vista.mostrarMensaje("Operacion cancelada por el usuario.");
        }
    }

    //convierte el numero del menu en la cantidad real de dinero en pesos
    private double obtenerMonto(int opcion) {
        switch (opcion) {
            case 1: return 200.00;
            case 2: return 400.00;
            case 3: return 600.00;
            case 4: return 800.00;
            case 5: return 1000.00;
            case 6: return 1200.00;
            default: return 0.00;
        }
        
        
        
    }
    
}


