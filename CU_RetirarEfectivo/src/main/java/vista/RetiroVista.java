package vista;

import java.util.Scanner;

public class RetiroVista {
    private Scanner scanner;

    public RetiroVista() {
        this.scanner = new Scanner(System.in);
    }

    //muestra en pantalla las opciones de dinero que el cliente puede elegir
    public int mostrarMenuMontos() {
        System.out.println("\n==========================================");
        System.out.println("      SELECCIONE EL MONTO A RETIRAR       ");
        System.out.println("==========================================");
        System.out.println("1. $200.00");
        System.out.println("2. $400.00");
        System.out.println("3. $600.00");
        System.out.println("4. $800.00");
        System.out.println("5. $1,000.00");
        System.out.println("6. $1,200.00");
        System.out.print("Seleccione una opcion (1-6): ");
        return scanner.nextInt();
    }

    //muestra en pantalla el desglose del saldo y el dinero a retirar
    public void mostrarEstadoCuenta(String nombre, double saldoActual, double monto, double comision, double montoFinal) {
        System.out.println("\n==========================================");
        System.out.println("             ESTADO DE CUENTA             ");
        System.out.println("==========================================");
        System.out.printf("Nombre:          %s\n", nombre);
        System.out.printf("Saldo Actual:    $%.2f\n", saldoActual);
        System.out.printf("Monto a Retirar: $%.2f\n", monto);
        System.out.printf("Comision:        $%.2f\n", comision);
        System.out.printf("Monto Final:     $%.2f\n", montoFinal);
        System.out.println("==========================================");
    }

    //pregunta al cliente si esta seguro de querer sacar el dinero
    public boolean solicitarConfirmacion() {
        System.out.println("\nDesea confirmar el retiro de efectivo?");
        System.out.println("1. [ Retirar Efectivo ]");
        System.out.println("2. [ Cancelar ]");
        System.out.print("Opcion: ");
        int opc = scanner.nextInt();
        return opc == 1;
    }

    //muestra la pantalla final con el ticket impreso del retiro
    public void mostrarRecibo(String ultimosDigitos, String nombre, double monto, double comision) {
        System.out.println("\n******************************************");
        System.out.println("            RECIBO DE RETIRO              ");
        System.out.println("******************************************");
        System.out.printf("Cuenta:           (...%s)\n", ultimosDigitos);
        System.out.printf("Nombre:           %s\n", nombre);
        System.out.printf("Cantidad Retirada:$%.2f\n", monto);
        System.out.printf("Comision:         $%.2f\n", comision);
        System.out.println("******************************************");
        System.out.println("    Por favor tome su dinero y recibo.   ");
        System.out.println("******************************************\n");
    }

    // muestra mensajes del sistema como errores o avisos de operacion cancelada
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n[SISTEMA]: " + mensaje);
    }
}