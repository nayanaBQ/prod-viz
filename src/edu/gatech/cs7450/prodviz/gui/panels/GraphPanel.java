package edu.gatech.cs7450.prodviz.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import prefuse.data.Graph;
import prefuse.data.io.DataIOException;

import edu.gatech.cs7450.prodviz.ApplicationContext;
import edu.gatech.cs7450.prodviz.data.Product;
import edu.gatech.cs7450.prodviz.gui.AbstractAppPanel;
import edu.gatech.cs7450.prodviz.gui.ResizeablePanel;
import edu.gatech.cs7450.prodviz.gui.viz.TreeMap;
import edu.gatech.cs7450.prodviz.gui.viz.TreeMapGenerator;

public class GraphPanel extends AbstractAppPanel {

	private static final long serialVersionUID = 1L;
//	
//	private JPanel container;
//	private JScrollPane scrollPane;
	
	private TreeMap treeMap;
	
	public GraphPanel() {
		this.setBackground(Color.RED);
		this.setLayout(new BorderLayout());
//		this.container = new JPanel();
//		this.add(container, BorderLayout.CENTER);
		//this.container.setLayout(new BorderLayout());
		//this.container.setLayout(new BoxLayout(this.container, BoxLayout.PAGE_AXIS));
		//container.setPreferredSize(new Dimension(700,600));
		//this.scrollPane = new JScrollPane(this.container);
		//scrollPane.setPreferredSize(new Dimension(300, 250));
		//scrollPane.setViewportBorder(
         //       BorderFactory.createLineBorder(Color.black));
		//this.add(scrollPane, BorderLayout.CENTER);
		//this.setVisible(true);
		//this.add(scrollPane);
		
//		this.addComponentListener(new ComponentListener() {
//			
//			@Override
//			public void componentShown(ComponentEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void componentResized(ComponentEvent e) {
//				int width = e.getComponent().getWidth();
//				int height = e.getComponent().getHeight();
//				System.out.println("resized to " + width + " " + height);
//			}
//			
//			@Override
//			public void componentMoved(ComponentEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void componentHidden(ComponentEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
	}
	
	public void resize(Dimension dimension) {
//		if (this.treeMap != null) {
//			this.treeMap.setSize(dimension);
//		}
		this.swapPanel(dimension, null);
		System.out.println("resized to [" + dimension.getWidth() + " " + dimension.getHeight() + "]");
	}
	
	public void initComponents() {
		this.swapPanel(null, null);
	}
	
	public void swapPanel(Dimension dimension, String onlyThisFirstLevelClassifier) {
		this.removeAll();
		ApplicationContext appContext = ApplicationContext.getInstance();
		this.treeMap = (TreeMap)TreeMap.renderTreeMap(
				this,
				dimension,
				TreeMapGenerator.createTreeMap(
						appContext.getActiveProduct(),
						appContext.getActiveUser(),
						appContext.getActiveRecommender(),
						onlyThisFirstLevelClassifier),
						"name",
						false);
		JPanel container = new JPanel();
		container.add(treeMap);
		this.add(container, BorderLayout.CENTER);
		this.validate();
	}
	
	public void showInfo(Product product) {
		this.removeAll();
		InfoPanel panel = new InfoPanel(this);
		JScrollPane scrollPane = new JScrollPane(panel,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.showProduct(product);
		System.out.println(this.getSize().getWidth() + " " + this.getSize().getHeight());
		scrollPane.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		scrollPane.setViewportBorder(
                BorderFactory.createLineBorder(Color.black));
		this.add(scrollPane, BorderLayout.CENTER);
		this.validate();
	}
}
