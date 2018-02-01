/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisNumerico;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author HP
 */
public class ValorEuler {
    private String operacion;
    private String  resultadoConversion;
    private String  resultadoOperacion;
    private String valorx;
    private String valory;
    
    public String evaluarFuncion( String funcion, String valorx,String valory){
        this.operacion=funcion;
        this.valorx=valorx;
        this.valory=valory;
        this.resultadoConversion=analizaFuncion(this.operacion);
        return this.resultadoOperacion=calculo(this.resultadoConversion);
    }
    private String analizaFuncion(String cadena){
        cadena=cadena.replaceAll("x", this.valorx);
        cadena=cadena.replaceAll("y", this.valory);
        cadena=quitaEspaciosBlancos(cadena);
        return cadena;
    }


    private String  quitaEspaciosBlancos(String sTexto){
        String sCadenaSinBlancos="";
        for (int x=0; x < sTexto.length(); x++) {
            if (sTexto.charAt(x) != ' ')
                sCadenaSinBlancos =sCadenaSinBlancos+ sTexto.charAt(x);
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
    public String Resultado() {
        return resultadoOperacion;
    }
}
