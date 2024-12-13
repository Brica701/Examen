package jsp_servlet_jdbc.model;

import java.util.Objects;

public class pedido {
    private int pedidoId;
    private int cantidad;
    private int fecha;
    private int cliente;
    private String comercial;

    public pedido(){

    }

    public pedido (int pedidoId, int cantidad, int fecha, int cliente, String comercial){
        this.pedidoId =pedidoId;
        this.cantidad=cantidad;
        this.fecha = fecha;
        this.cliente = cliente;
        this.comercial = comercial;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getComercial() {
        return comercial;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pedido socio = (pedido) o;
        return pedidoId == socio.pedidoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidoId);
    }

    @Override
    public String toString(){
        return "Pedido{" +
                "pedidoID=" + pedidoId +
                ", cantidad='" +cantidad + '\'' +
                ", fecha='" +fecha + '\'' +
                ", cliente='" +cliente + '\'' +
                ", comercial='" +comercial + '\'' +
                '}';
    }
}
