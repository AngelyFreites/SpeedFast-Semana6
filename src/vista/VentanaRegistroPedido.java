package vista;

import modelo.GestorPedidos;
import modelo.Pedido;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {

    private JTextField txtId;
    private JTextField txtDireccion;
    private JComboBox<String> cmbTipo;

    public VentanaRegistroPedido() {

        setTitle("Registrar Pedido");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblId = new JLabel("ID:");
        JLabel lblDireccion = new JLabel("Dirección:");
        JLabel lblTipo = new JLabel("Tipo:");

        txtId = new JTextField();
        txtDireccion = new JTextField();

        String[] tipos = {"Comida", "Encomienda", "Express"};
        cmbTipo = new JComboBox<>(tipos);

        JButton btnGuardar = new JButton("Guardar");

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(lblId);
        panel.add(txtId);

        panel.add(lblDireccion);
        panel.add(txtDireccion);

        panel.add(lblTipo);
        panel.add(cmbTipo);

        panel.add(new JLabel(""));
        panel.add(btnGuardar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarPedido());
    }

    private void guardarPedido() {

        String idTexto = txtId.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String tipo = cmbTipo.getSelectedItem().toString();

        if (idTexto.isEmpty() || direccion.isEmpty()) {
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

            if (id <= 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "El ID debe ser mayor que 0.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            if (GestorPedidos.existeId(id)) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ya existe un pedido con ese ID.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            Pedido nuevoPedido = new Pedido(id, direccion, tipo);
            GestorPedidos.agregarPedido(nuevoPedido);

            JOptionPane.showMessageDialog(
                    this,
                    "Pedido registrado correctamente."
            );

            txtId.setText("");
            txtDireccion.setText("");
            cmbTipo.setSelectedIndex(0);

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