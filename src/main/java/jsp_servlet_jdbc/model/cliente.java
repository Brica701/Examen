package jsp_servlet_jdbc.model;

import java.util.Objects;

public class cliente {
    private int clienteId;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String ciudad;
    private String categoria;

public cliente(){
}

public cliente(int clienteId, String nombre,String apellido1, String apellido2, String ciudad, String categoria){
    this.clienteId = clienteId;
    this.nombre = nombre;
    this.apellido1 = apellido1;
    this.apellido2 = apellido2;
    this.ciudad = ciudad;
    this.categoria = categoria;
}

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        cliente socio = (cliente) o;
        return clienteId == socio.clienteId;
    }
    @Override
    public int hashCode() {
        return Objects.hash(clienteId);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "clienteId=" + clienteId +
                ", nombre='" + nombre + '\'' +
                ", apellido1=" + apellido1 +
                ", apellido2=" + apellido2 +
                ", ciudad='" + ciudad + '\'' +
                ", categoría='" + categoria + '\'' +
                '}';
    }
}


