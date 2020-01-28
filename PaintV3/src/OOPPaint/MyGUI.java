package OOPPaint;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

public class MyGUI extends JFrame {
	private boolean fill = false;
	private JList listShape, listColor;
	private JCheckBox chckbxFill;
	private JButton btnColorAll, buttonRedo, buttonUndo;
	private DrawingPanal drawing_panel;
	private String[] shapeOptions = new String[] { "Line", "Rectangle", "Triangle", "Oval" };
	private String[] colorOptions = new String[] { "Black", "Blue", "Cyan", "Gray", "Green", "Light Gray", "Magenta",
			"Orange", "Pink", "Red", "White", "Yellow" };
	private Color colors[] = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.lightGray,
			Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };
//	private Color colorArray[] = { Color.BLACK, Color.BLUE, Color.CYAN, Color.darkGray, Color.GRAY, Color.GREEN,
//			Color.lightGray, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };
	private static MyGUI mygui;

	// Singleton design pattern
	public static MyGUI getInstance() {
		if (mygui == null) {
			mygui = new MyGUI();
		}
		return mygui;
	}

	private MyGUI() {
		super("Paint"); // sets the name of GUI

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(1080, 720);

		drawing_panel = new DrawingPanal();
		drawing_panel.setBackground(Color.WHITE);
		drawing_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		// drawing_panel.setBounds(10, 72, 684, 298);
		System.out.print(this.getHeight());
		drawing_panel.setLayout(null);
		add(drawing_panel, BorderLayout.CENTER);

		JPanel padding_panal = new JPanel();
		padding_panal.setBorder(new CompoundBorder());
		FlowLayout flowLayout = (FlowLayout) padding_panal.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setAlignment(FlowLayout.LEADING);
		// padding_panal.setBounds(10, 11, 684, 50);
		add(padding_panal, BorderLayout.NORTH);

		JPanel tools_panel = new JPanel();
		padding_panal.add(tools_panel);
		tools_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tools_panel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 5));

		listShape = new JList(shapeOptions);
		listShape.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listShape.setLayoutOrientation(JList.HORIZONTAL_WRAP);

		listShape.setSelectedIndex(0);
		listShape.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listShape.setToolTipText("shapes");
		listShape.setValueIsAdjusting(true);
		listShape.setVisibleRowCount(2);
		tools_panel.add(listShape);

		chckbxFill = new JCheckBox("Fill");
		chckbxFill.setHorizontalAlignment(SwingConstants.CENTER);
		tools_panel.add(chckbxFill);

		listColor = new JList(colorOptions);
		listColor.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listColor.setVisibleRowCount(2);
		listColor.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listColor.setToolTipText("Colors");
		listColor.setSelectedIndex(0);
		listColor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tools_panel.add(listColor);

		listShape.addListSelectionListener(listShapeHandler);
		listColor.addListSelectionListener(listColorHandler);

		btnColorAll = new JButton("Color All");
		tools_panel.add(btnColorAll);
		btnColorAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawing_panel.updateAllColor();
			}
		});
		setLocationRelativeTo(null);

		chckbxFill.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					drawing_panel.setChckFill(true);
				} else {
					drawing_panel.setChckFill(false);
				}

			}
		});
		
		///// redo & undo Buttons
		buttonUndo = new JButton("undo");
		buttonRedo = new JButton("redo");
		tools_panel.add(buttonUndo);
		tools_panel.add(buttonRedo);
		
		
		buttonUndo.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            
	            	drawing_panel.undo();
	            
	         }
	      });
		buttonRedo.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 drawing_panel.redo();
	            	
	            
	         }
	      });
		
		setVisible(true);
	}

	public ListSelectionListener listColorHandler = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			int colorIndex = listColor.getSelectedIndex();
			drawing_panel.setSelectedColor(colors[colorIndex]);
		}
	};

	public ListSelectionListener listShapeHandler = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			int shapeIndex = listShape.getSelectedIndex();

			drawing_panel.setSelectedShapeType(shapeOptions[shapeIndex]);
		}
	};

}
