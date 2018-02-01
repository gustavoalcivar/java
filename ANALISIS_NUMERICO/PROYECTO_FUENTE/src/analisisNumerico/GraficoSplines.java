

package analisisNumerico;




import java.awt.Color;
import java.awt.FlowLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 *
 * 
 */
public class GraficoSplines {
    private final double variacion=0.001;
    public void GraficaFinal(double x[],double a[],double b[],double c[],double d[],JPanel jgrafica){
        XYDataset xydataset=generaDatos(x,a,b,c,d);
        JFreeChart chart=generaGrafico(xydataset);
        jgrafica.removeAll();
        ChartPanel grafico = new ChartPanel(chart);
        jgrafica.setLayout(new FlowLayout());
        jgrafica.add(grafico);
        jgrafica.updateUI();
    }
    private XYDataset generaDatos(double x[],double a[],double b[],double c[],double d[]) {
        XYSeries serie1=new XYSeries("Unión de puntos");
        XYSeries serie2=new XYSeries("Polinomios");
        for(int j=0;j<x.length;j++){
            serie1.add(x[j],a[j]);
        }
        int n=x.length;
        double inicio=x[0];
        double fin=x[n-1];
        while(inicio<=fin){
            serie2.add(inicio,Metodos.evaluarSpines(inicio,x,a,b,c,d));
            inicio+=variacion;
        }
        XYSeriesCollection xyseriescollection=new XYSeriesCollection();
        xyseriescollection.addSeries(serie1);
        xyseriescollection.addSeries(serie2);
        return xyseriescollection;
    }
    private static JFreeChart generaGrafico(XYDataset xydataset){
        JFreeChart jfreechart=ChartFactory.createXYLineChart("Gráfico","x","y",
                xydataset, PlotOrientation.VERTICAL,true,false,false);
        XYPlot xyplot=(XYPlot) jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.white);
        xyplot.setDomainGridlinePaint(Color.black);
        xyplot.setRangeGridlinePaint(Color.black);
        XYLineAndShapeRenderer xylineandshaperenderer=(XYLineAndShapeRenderer) xyplot.getRenderer();
        xylineandshaperenderer.setBaseShapesVisible(false);
        return jfreechart;
    }
}
