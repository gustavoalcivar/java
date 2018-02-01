/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisNumerico;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author gustavo
 */
public class FuncionEuler {
    private String operacion;
    private String  resultadoConversion;
    private String  resultadoOperacion;
    private String valorX;
    private String valorY;
    public FuncionEuler() {
        
    }
    public String evaluar( String operacion, String valorX, String valorY){
        this.operacion=operacion;
        this.valorX=valorX;
        this.valorX=valorY;
        this.resultadoConversion=analizaCadena(this.operacion);
        return this.resultadoOperacion=calculo(this.resultadoConversion);
    }
    private String analizaCadena(String cadena){
        cadena=cadena.replaceAll("x", this.valorX);
        cadena=cadena.replaceAll("y", this.valorY);
        cadena=quitarEspacios(cadena);
        return cadena;
    }
    public String getResultadoOperacion() {
        return resultadoOperacion;
    }

    private String  quitarEspacios(String sTexto){
        String sCadenaSinBlancos="";
        for (int x=0; x < sTexto.length(); x++) {
            if (sTexto.charAt(x) != ' ')
                sCadenaSinBlancos += sTexto.charAt(x);
        }
        return sCadenaSinBlancos;
    }
    private String calculo(String cadena) {
        ScriptEngineManager script = new ScriptEngineManager();
        ScriptEngine js = script.getEngineByName("JavaScript");
        try{
            return js.eval(cadena).toString();
        }catch(Exception e){
            return e.toString();
        }
    }
}
