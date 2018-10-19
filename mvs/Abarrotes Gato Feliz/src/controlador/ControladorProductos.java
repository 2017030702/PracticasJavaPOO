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
public class ControladorProductos implements ActionListener {
    private vdlgProductos vistaProductos;
    private Factura nFactura;
    private Perecedero producto;
    
    public ControladorProductos(vdlgProductos vistaProductos, Factura nFactura, Perecedero producto){
        this.nFactura = nFactura;
        this.producto = producto;
        this.vistaProductos = vistaProductos;
        
        vistaProductos.btnGuardar.addActionListener(this);
        vistaProductos.btnSalir.addActionListener(this);
        vistaProductos.setTitle("Registrar Producto");
        vistaProductos.setVisible(true);
    }

    /**
     * @return the vistaProductos
     */
    public vdlgProductos getVistaProductos() {
        return vistaProductos;
    }

    /**
     * @param vistaProductos the vistaProductos to set
     */
    public void setVistaProductos(vdlgProductos vistaProductos) {
        this.vistaProductos = vistaProductos;
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
        if(e.getSource() == vistaProductos.btnGuardar){
            producto.setIdProducto(Integer.parseInt(vistaProductos.txtIdProducto.getText()));
            producto.setNombreProducto(vistaProductos.txtNombreProducto.getText());
            switch(vistaProductos.cbUnidad.getSelectedItem().toString()){
                case "1 - Kg":
                    producto.setUnidadProducto(1);
                    break;
                case "2 - Litros":
                    producto.setUnidadProducto(2);
                    break;
                case "3 - Pieza":
                    producto.setUnidadProducto(3);
                    break;
            }
            producto.setPrecioUnitario(Float.parseFloat(vistaProductos.txtPrecioUnitario.getText()));
            producto.setFechaCaducidad(vistaProductos.txtCaducidad.getText());
            producto.setTemperatura(Float.parseFloat(vistaProductos.txtTemperatura.getText()));
            JOptionPane.showMessageDialog(null, "Se ha guardado exitosamente");
        }
        else if(e.getSource() == vistaProductos.btnSalir){
            vistaProductos.dispose();
            vdlgMenu ventana = new vdlgMenu(null, true);
            ControladorMenu control = new ControladorMenu(ventana, nFactura, producto);
        }
    }
}