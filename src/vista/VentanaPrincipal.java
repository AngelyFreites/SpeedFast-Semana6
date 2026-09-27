package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        setTitle("SpeedFast - Gestión de Entregas");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnRegistrar = new JButton("Registrar pedido");
        JButton btnListar = new JButton("Listar pedidos");
        JButton btnAsignar = new JButton("Asignar repartidor / Iniciar entrega");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        panel.add(btnRegistrar);
        panel.add(btnListar);
        panel.add(btnAsignar);

        add(panel, BorderLayout.CENTER);

        btnRegistrar.addActionListener(e -> {
            new VentanaRegistroPedido().setVisible(true);
        });

        btnListar.addActionListener(e -> {
            new VentanaListaPedidos().setVisible(true);
        });

        btnAsignar.addActionListener(e -> {
            new VentanaAsignarRepartidor().setVisible(true);
        });
    }
}