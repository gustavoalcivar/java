/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos;

public class ElementoMochila {
    public int elemento;
public double beneficio;
public double peso;

    public ElementoMochila() {
    }

    public ElementoMochila(int elemento, double beneficio, double peso) {
        this.elemento = elemento;
        this.beneficio = beneficio;
        this.peso = peso;
    }
    
    public double getElemento() {
        return elemento;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }
    
    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
