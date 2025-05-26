package jsp_servlet_jdbc.model;

import java.time.LocalDate;
import java.util.Date;

public class Pedido {
    private int id;
    private double total;
    private LocalDate fecha;
    private int idCliente;
    private int idComercial;

    // Nuevos atributos para acceso a objetos
    private Cliente cliente;
    private Comercial comercial;

    // Para mostrar en el listado
    private String nombreCliente;
    private String apellido1Cliente;
    private String apellido2Cliente;
    private String nombreComercial;
    private String apellido1Comercial;
    private String apellido2Comercial;

    public Pedido() {
    }

    public Pedido(int id, double total, Date fecha, int idCliente, int idComercial) {
        this.id = id;
        this.total = total;
        this.fecha = fecha.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        this.idCliente = idCliente;
        this.idComercial = idComercial;
    }

    public Pedido(int id, double total, LocalDate fecha, Cliente cliente, Comercial comercial) {
        this.id = id;
        this.total = total;
        this.fecha = fecha;
        this.cliente = cliente;
        this.comercial = comercial;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellido1Cliente() {
        return apellido1Cliente;
    }

    public void setApellido1Cliente(String apellido1Cliente) {
        this.apellido1Cliente = apellido1Cliente;
    }

    public String getApellido2Cliente() {
        return apellido2Cliente;
    }

    public void setApellido2Cliente(String apellido2Cliente) {
        this.apellido2Cliente = apellido2Cliente;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getApellido1Comercial() {
        return apellido1Comercial;
    }

    public void setApellido1Comercial(String apellido1Comercial) {
        this.apellido1Comercial = apellido1Comercial;
    }

    public String getApellido2Comercial() {
        return apellido2Comercial;
    }

    public void setApellido2Comercial(String apellido2Comercial) {
        this.apellido2Comercial = apellido2Comercial;
    }
}
