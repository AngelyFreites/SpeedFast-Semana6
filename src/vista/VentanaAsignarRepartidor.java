package vista;

import modelo.GestorPedidos;
import modelo.Pedido;

import javax.swing.*;
import java.awt.*;

public class VentanaAsignarRepartidor extends JFrame {

    private JTextField txtId;
    private JTextField txtRepartidor;

    public VentanaAsignarRepartidor() {

        setTitle("Asignar Repartidor / Iniciar Entrega");
        setSize(450, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblId = new JLabel("ID del pedido:");
        JLabel lblRepartidor = new JLabel("Nombre del repartidor:");

        txtId = new JTextField();
        txtRepartidor = new JTextField();

        JButton btnAsignar = new JButton("Asignar e iniciar entrega");

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(lblId);
        panel.add(txtId);

        panel.add(lblRepartidor);
        panel.add(txtRepartidor);

        panel.add(new JLabel(""));
        panel.add(btnAsignar);

        add(panel);

        btnAsignar.addActionListener(e -> asignarRepartidor());
    }

    private void asignarRepartidor() {

        String idTexto = txtId.getText().trim();
        String nombreRepartidor = txtRepartidor.getText().trim();

        if (idTexto.isEmpty() || nombreRepartidor.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debes completar todos los campos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {

            int id = Integer.parseInt(idTexto);
            Pedido pedidoEncontrado = null;

            for (Pedido pedido : GestorPedidos.obtenerPedidos()) {
                if (pedido.getId() == id) {
                    pedidoEncontrado = pedido;
                    break;
                }
            }

            if (pedidoEncontrado == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "No existe un pedido con ese ID.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            pedidoEncontrado.setRepartidor(nombreRepartidor);
            pedidoEncontrado.setEstado("En reparto");

            JOptionPane.showMessageDialog(
                    this,
                    "Repartidor asignado y entrega iniciada correctamente."
            );

            txtId.setText("");
            txtRepartidor.setText("");

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "El ID debe ser un número entero.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}