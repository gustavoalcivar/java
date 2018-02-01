package objetoServicio;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
public class Reloj extends Observable
{
    /**
      * Lanza un timer cada segundo.
      */
     public Reloj()
     {
         Timer timer = new Timer();
         timer.scheduleAtFixedRate(timerTask, 5, 1000);
     }

    public static void main(String[] args) {
     Reloj modelo = new Reloj();
         modelo.addObserver (new Observer()
         {
             public void update (Observable unObservabl, Object dato)
             {
                 System.out.println (dato);
             }
         });
     }

     /**
      * Clase que se mete en Timer, para que se le avise cada segundo.
      */
     TimerTask timerTask = new TimerTask()
     {
         /**
          * Método al que Timer llamará cada segundo. Se encarga de avisar
          * a los observadores de este modelo.
          */
         public void run()
         {
             setChanged();
             notifyObservers(new Date());
         }
     };

}
