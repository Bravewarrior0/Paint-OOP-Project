package oopFinalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.BorderLayout;

public class MyGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyGUI window = new MyGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel drawing_panel = new JPanel();
		drawing_panel.setBackground(Color.WHITE);
		drawing_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		drawing_panel.setBounds(10, 72, 684, 298);
		frame.getContentPane().add(drawing_panel);
		drawing_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel padding_panal = new JPanel();
		padding_panal.setBorder(new CompoundBorder());
		FlowLayout flowLayout = (FlowLayout) padding_panal.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setAlignment(FlowLayout.LEADING);
		padding_panal.setBounds(10, 11, 684, 50);
		frame.getContentPane().add(padding_panal);
		
		JPanel tools_panel = new JPanel();
		padding_panal.add(tools_panel);
		tools_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tools_panel.setLayout(new GridLayout(0, 3, 10, 10));
		
		JList shapeList = new JList();
		shapeList.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		shapeList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		shapeList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Line", "Rectangle", "Triangle", "Oval"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		shapeList.setSelectedIndex(0);
		shapeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		shapeList.setToolTipText("shapes");
		shapeList.setValueIsAdjusting(true);
		shapeList.setVisibleRowCount(2);
		tools_panel.add(shapeList);
		
		JCheckBox chckbxFill = new JCheckBox("Fill");
		chckbxFill.setHorizontalAlignment(SwingConstants.CENTER);
		tools_panel.add(chckbxFill);
		
		JList colorList = new JList();
		colorList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		colorList.setVisibleRowCount(2);
		colorList.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		colorList.setToolTipText("Colors");
		colorList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Black", "Red", "Blue", "Green", "Gray", "Yellow"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		colorList.setSelectedIndex(0);
		colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tools_panel.add(colorList);
	}
}
