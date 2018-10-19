/*
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
public class ControladorImprimir implements ActionListener {
    private vdlgImprimir vistaImprimir;
    private Factura nFactura;
    private Perecedero producto;
    
    public ControladorImprimir(vdlgImprimir vistaImprimir, Factura nFactura, Perecedero producto){
        this.vistaImprimir = vistaImprimir;
        this.producto = producto;
        this.nFactura = nFactura;
        
        vistaImprimir.btnCargar.addActionListener(this);
        vistaImprimir.btnSalir.addActionListener(this);
        vistaImprimir.setTitle("Imprimir");
        vistaImprimir.setVisible(true);
    }

    /**
     * @return the vistaImprimir
     */
    public vdlgImprimir getVistaImprimir() {
        return vistaImprimir;
    }

    /**
     * @param vistaImprimir the vistaImprimir to set
     */
    public void setVistaImprimir(vdlgImprimir vistaImprimir) {
        this.vistaImprimir = vistaImprimir;
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
        if(e.getSource() == vistaImprimir.btnCargar){
            vistaImprimir.txtId.setText(nFactura.getNumero() + "");
            vistaImprimir.txtFecha.setText(nFactura.getFecha());
            vistaImprimir.txtConcepto.setText(nFactura.getConcepto());
            vistaImprimir.txtProducto.setText(nFactura.getProducto().getNombreProducto());
            vistaImprimir.txtCantidad.setText("" + nFactura.getCantidad());
            vistaImprimir.txtTipoPago.setText("" + nFactura.getTipoPago());
            vistaImprimir.txtPrecioUnitario.setText("" + nFactura.getProducto().getPrecioUnitario());
            vistaImprimir.txtPrecioVenta.setText("" + nFactura.getProducto().calcularPrecio());
            vistaImprimir.txtSubtotal.setText("" + nFactura.calcularPago());
            vistaImprimir.txtRfc.setText(nFactura.getRfc());
            vistaImprimir.txtNombreCliente.setText(nFactura.getNombreCliente());
            vistaImprimir.txtDomicilioFiscal.setText(nFactura.getDomicilioFiscal());
            vistaImprimir.txtFechaFactura.setText(nFactura.getFechaFactura());
            vistaImprimir.txtIva.setText("" + nFactura.getIva() + "%");
            vistaImprimir.txtImpuestos.setText(nFactura.calcularImpuesto() + "");
            vistaImprimir.txtPagoTotal.setText(nFactura.calcularTotal() + "");
            
        }
        else if(e.getSource() == vistaImprimir.btnSalir){
            vistaImprimir.dispose();
            vdlgMenu ventana = new vdlgMenu(null, true);
            ControladorMenu control = new ControladorMenu(ventana, nFactura, producto);
        }
    }
}