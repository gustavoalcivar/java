/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetoProyecto;

/**
 *
 * @author Gustavo
 */
public class Cliente {
    private  String codigoCliente;
    private  String nombres;
    private  String apellidos;
    private  String direccion;
    private  String email;
    private  String telefono;
    private  String cedula;
    public Cliente(){

    }
    public Cliente(String codigoCliente, String nombres, String apellidos,String direccion,String email,String telefono,String cedula){
        this.codigoCliente=codigoCliente;
        this.nombres= nombres;
        this.apellidos=apellidos;
        this.direccion=direccion;
        this.email=email;
        this.telefono=telefono;
        this.cedula=cedula;
    }
    @Override
    public String toString(){
        return codigoCliente+nombres+apellidos+direccion+email+telefono+cedula;
    }
    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
