package jsp_servlet_jdbc.model;
import java.util.Date;
import java.util.Objects;
public class Pedido {
    private int id;
    private double total;
    private Date fecha;
    private int idCliente;
    private int idComercial;

    private Cliente cliente;       // para mostrar info asociada en JSP
    private Comercial comercial;   // idem

    public Pedido() {}

    public Pedido(int id, double total, Date fecha, int idCliente, int idComercial) {
        this.id = id;
        this.total = total;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idComercial = idComercial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdComercial() {
        return idComercial;
    }

    public void setIdComercial(int idComercial) {
        this.idComercial = idComercial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Comercial getComercial() {
        return comercial;
    }

    public void setComercial(Comercial comercial) {
        this.comercial = comercial;
    }
}

