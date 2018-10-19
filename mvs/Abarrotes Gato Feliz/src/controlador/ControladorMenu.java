/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.Factura;
import modelo.Perecedero;

import vista.vdlgFactura;
import vista.vdlgImprimir;
import vista.vdlgMenu;
import vista.vdlgProductos;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Konakun
 */
public class ControladorMenu implements ActionListener {
    private vdlgMenu vistaMenu;
    private Factura nFactura;
    private Perecedero producto;
    
    public ControladorMenu(vdlgMenu vistaMenu, Factura nFactura, Perecedero producto){
        this.vistaMenu = vistaMenu;
        this.nFactura = nFactura;
        this.producto = producto;
        
        vistaMenu.btnImprimir.addActionListener(this);
        vistaMenu.btnNuevaFactura.addActionListener(this);
        vistaMenu.btnNuevoProducto.addActionListener(this);
        vistaMenu.btnSalir.addActionListener(this);
        vistaMenu.setTitle("Ventas");
        vistaMenu.setVisible(true);
    }

    /**
     * @return the vistaMenu
     */
    public vdlgMenu getVistaMenu() {
        return vistaMenu;
    }

    /**
     * @param vistaMenu the vistaMenu to set
     */
    public void setVistaMenu(vdlgMenu vistaMenu) {
        this.vistaMenu = vistaMenu;
    }

    /**
     * @return the nFactura
     */
    public Factura getnFactura() {
        return nFactura;
    }

    /**
     * @param nFactura the nFactura to set
     */
    public void setnFactura(Factura nFactura) {
        this.nFactura = nFactura;
    }

    /**
     * @return the producto
     */
    public Perecedero getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Perecedero producto) {
        this.producto = producto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaMenu.btnNuevaFactura){
            vistaMenu.dispose();
            vdlgFactura ventana = new vdlgFactura(null, true);
            ControladorFactura control = new ControladorFactura(ventana, nFactura, producto);
        }
        else if(e.getSource() == vistaMenu.btnNuevoProducto){
            vistaMenu.dispose();
             vdlgProductos ventana = new vdlgProductos(null, true);
            ControladorProductos control = new ControladorProductos(ventana, nFactura, producto);
        }
        else if(e.getSource() == vistaMenu.btnImprimir){
            vistaMenu.dispose();
            vdlgImprimir ventana = new vdlgImprimir(null, true);
            ControladorImprimir control = new ControladorImprimir(ventana, nFactura, producto);
        }
        else if(e.getSource() == vistaMenu.btnSalir){
            vistaMenu.dispose();
            JOptionPane.showMessageDialog(null, "Gracias por usar este programa");
            System.exit(0);
        }
    }
}