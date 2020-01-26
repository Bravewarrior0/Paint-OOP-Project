package OOPPaint;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.*;
import java.awt.event.*;

public class MyGUI extends JFrame {
	private int xbegin = 0, ybegin = 0, xend = 0, yend = 0;
	private boolean fill = false;
	private JList listShape, listColor;
	private JCheckBox chckbxFill;

	private String[] shapeOptions = new String[] { "Line", "Rectangle", "Triangle", "Oval" };
	private String[] colorOptions = new String[] { "Black", "Red", "Blue", "Green", "Gray", "Yellow" };
	private Color colors[] = { Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.GRAY, Color.YELLOW };
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

		JPanel drawing_panel = new JPanel();
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
		tools_panel.setLayout(new GridLayout(0, 3, 10, 10));

		listShape = new JList(shapeOptions);
		listShape.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listShape.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//		listShape.setModel(new AbstractListModel() {
//			String[] values = = new String[] { "Line", "Rectangle", "Triangle", "Oval" };
//
//			public int getSize() {
//				return values.length;
//			}
//
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//		});
		listShape.setSelectedIndex(0);
		listShape.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listShape.setToolTipText("shapes");
		listShape.setValueIsAdjusting(true);
		listShape.setVisibleRowCount(2);
		tools_panel.add(listShape);
//
		chckbxFill = new JCheckBox("Fill");
		chckbxFill.setHorizontalAlignment(SwingConstants.CENTER);
		tools_panel.add(chckbxFill);

		listColor = new JList(colorOptions);
		listColor.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listColor.setVisibleRowCount(2);
		listColor.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listColor.setToolTipText("Colors");
//		listColor.setModel(new AbstractListModel() {
//			String[] values = new String[] { "Black", "Red", "Blue", "Green", "Gray", "Yellow" };
//
//			public int getSize() {
//				return values.length;
//			}
//
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//		});
		listColor.setSelectedIndex(0);
		listColor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tools_panel.add(listColor);

		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseMotionHandler);
		setVisible(true);
		setLocationRelativeTo(null);
		chckbxFill.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					fill = true;
				} else {
					fill = false;
				}

			}
		});
	}

	public MouseListener mouseHandler = new MouseAdapter() {

		@Override
		public void mousePressed(MouseEvent e) {
			xbegin = xend = e.getX();
			ybegin = yend = e.getY();
			repaint();

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			xend = e.getX();
			yend = e.getY();
			repaint();
		}
	};

	public MouseMotionListener mouseMotionHandler = new MouseMotionAdapter() {

		@Override
		public void mouseDragged(MouseEvent e) {
			xend = e.getX();
			yend = e.getY();
			repaint();

		}
	};

	public void paint(Graphics g) {
		//super.paint(g);
		int index = listColor.getSelectedIndex();
		g.setColor(colors[index]);
		if (fill)
			g.fillPolygon(new int[] { xbegin, 2 * xbegin - xend, xend }, new int[] { ybegin, yend, yend }, 3);
		else
			g.drawPolygon(new int[] { xbegin, 2 * xbegin - xend, xend }, new int[] { ybegin, yend, yend }, 3);
		// g.fillRect(Math.min(xbegin, xend), Math.min(ybegin, yend),
		// Math.abs(xbegin-xend), Math.abs(ybegin-yend));
//		(xbegin, ybegin, xend, yend);
	}
}
