package modelo;

public class Pedido {

    private int id;
    private String direccion;
    private String tipo;
    private String repartidor;
    private String estado;

    public Pedido(int id, String direccion, String tipo) {
        this.id = id;
        this.direccion = direccion;
        this.tipo = tipo;
        this.repartidor = "Sin asignar";
        this.estado = "Pendiente";
    }

    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRepartidor() {
        return repartidor;
    }

    public String getEstado() {
        return estado;
    }

    public void setRepartidor(String repartidor) {
        this.repartidor = repartidor;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
