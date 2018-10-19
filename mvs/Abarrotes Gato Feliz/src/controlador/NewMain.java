/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JFrame;
import modelo.Factura;
import modelo.Perecedero;
import vista.vdlgMenu;

/**
 *
 * @author Konakun
 */
public class NewMain {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Factura nuevaFactura = new Factura();
        Perecedero nuevoProducto = new Perecedero();
        vdlgMenu vista = new vdlgMenu(new JFrame(), true);
        ControladorMenu controlador = new ControladorMenu(vista, nuevaFactura, nuevoProducto);
    }
}
