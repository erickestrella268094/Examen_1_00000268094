package main;

import modelo.CuentaModelo;
import vista.RetiroVista;
import controlador.RetiroControlador;

public class Main {
    // punto de inicio para ejecutar el programa en netbeans
    public static void main(String[] args) {
        // crea un usuario simulado que ya inicio sesion con su saldo inicial
        CuentaModelo modelo = new CuentaModelo("Juan Perez", "1234", 5300.00, 15.00);
        RetiroVista vista = new RetiroVista();
        
        // inicia la ejecucion del caso de uso
        RetiroControlador controlador = new RetiroControlador(modelo, vista);
        controlador.procesarRetiro();
    }
}

