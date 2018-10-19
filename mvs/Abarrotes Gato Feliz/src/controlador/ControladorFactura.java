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
public class ControladorFactura implements ActionListener {
    private vdlgFactura vistaFactura;
    private Factura nFactura;
    private Perecedero producto;
   
    
    public ControladorFactura(vdlgFactura vistaFactura, Factura nFactura, Perecedero producto){
        this.vistaFactura = vistaFactura;
        this.nFactura = nFactura;
        this.producto = producto;
        
        vistaFactura.btnGuardar.addActionListener(this);
        vistaFactura.btnSalir.addActionListener(this);
        vistaFactura.setTitle("Registrar Factura");
        vistaFactura.setVisible(true);
    }

    /**
     * @return the vistaFactura
     */
    public vdlgFactura getVistaFactura() {
        return vistaFactura;
    }

    /**
     * @param vistaFactura the vistaFactura to set
     */
    public void setVistaFactura(vdlgFactura vistaFactura) {
        this.vistaFactura = vistaFactura;
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
        vistaFactura.txtProducto.setText(producto.getNombreProducto());
        if(e.getSource() == vistaFactura.btnGuardar){
            nFactura.setNumero(Integer.parseInt(vistaFactura.txtId.getText()));
            nFactura.setFecha(vistaFactura.txtFecha.getText());
            nFactura.setConcepto(vistaFactura.txtConcepto.getText());
            nFactura.setProducto(producto);
            nFactura.setCantidad(Float.parseFloat(vistaFactura.txtCantidad.getText()));
            switch(vistaFactura.cbTipoPago.getSelectedItem().toString()){
                case "1 - Contado":
                    nFactura.setTipoPago(1);
                    break;
                case "2 - Credito":
                    nFactura.setTipoPago(2);
                    break;
            }
            nFactura.setRfc(vistaFactura.txtRfc.getText());
            nFactura.setNombreCliente(vistaFactura.txtNombreCliente.getText());
            nFactura.setDomicilioFiscal(vistaFactura.txtDomicilioFiscal.getText());
            nFactura.setFechaFactura(vistaFactura.txtFechaFactura.getText());
            nFactura.setIva(Float.parseFloat(vistaFactura.txtIva.getText()));
            JOptionPane.showMessageDialog(null, "Se ha guardado exitosamente");
        }
        else if(e.getSource() == vistaFactura.btnSalir){
            vistaFactura.dispose();
            vdlgMenu ventana = new vdlgMenu(null, true);
            ControladorMenu control = new ControladorMenu(ventana, nFactura, producto);
        }
        else if(e.getSource() == vistaFactura.btnCargarProducto){
            vistaFactura.txtProducto.setText(producto.getNombreProducto());
        }
    }
}
