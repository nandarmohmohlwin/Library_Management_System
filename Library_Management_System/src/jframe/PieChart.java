package jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.BorderLayout;
import java.awt.Color;
@SuppressWarnings("serial")
public class PieChart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PieChart frame = new PieChart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PieChart() {
		init();
		showPieChart();
	}
	
	public void init () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	@SuppressWarnings("removal")
	public void showPieChart(){  
	      DefaultPieDataset barDataset = new DefaultPieDataset( );
	      barDataset.setValue( "IPhone 5s" , new Double( 20 ) );  
	      barDataset.setValue( "SamSung Grand" , new Double( 20 ) );   
	      barDataset.setValue( "MotoG" , new Double( 40 ) );    
	      barDataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
	      
	      //create chart
	       JFreeChart piechart = ChartFactory.createPieChart("mobile sales",barDataset, false,true,false);//explain
	      
	        PiePlot piePlot =(PiePlot) piechart.getPlot();
	      
	       //changing pie chart blocks colors
	       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
	        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
	        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
	        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
	      
	       
	        piePlot.setBackgroundPaint(Color.white);
	        JPanel panel = new JPanel();
			panel.setBounds(35, 11, 450, 302);
			
	        
	        //create chartPanel to display chart(graph)
	        ChartPanel barChartPanel = new ChartPanel(piechart);
	        panel.removeAll();
	        panel.add(barChartPanel, BorderLayout.CENTER);
	        panel.validate();
	        contentPane.add(panel);
	    }
}
