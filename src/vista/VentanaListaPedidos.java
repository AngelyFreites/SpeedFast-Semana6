package vista;

import modelo.GestorPedidos;
import modelo.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaListaPedidos extends JFrame {

    private DefaultTableModel modeloTabla;
    private JTable tablaPedidos;

    public VentanaListaPedidos() {

        setTitle("Lista de Pedidos");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnas = {
                "ID",
                "Dirección",
                "Tipo",
                "Repartidor",
                "Estado"
        };

        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaPedidos = new JTable(modeloTabla);

        JScrollPane scrollPane = new JScrollPane(tablaPedidos);

        JButton btnRefrescar = new JButton("Refrescar");

        JPanel panelInferior = new JPanel();
        panelInferior.add(btnRefrescar);

        add(scrollPane, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        btnRefrescar.addActionListener(e -> cargarPedidos());

        cargarPedidos();
    }

    private void cargarPedidos() {

        modeloTabla.setRowCount(0);

        for (Pedido pedido : GestorPedidos.obtenerPedidos()) {

            Object[] fila = {
                    pedido.getId(),
                    pedido.getDireccion(),
                    pedido.getTipo(),
                    pedido.getRepartidor(),
                    pedido.getEstado()
            };

            modeloTabla.addRow(fila);
        }
    }
}