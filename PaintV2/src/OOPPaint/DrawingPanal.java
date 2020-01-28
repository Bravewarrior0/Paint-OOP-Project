package OOPPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawingPanal extends JPanel {
	private int xbegin = 0, ybegin = 0, xend = 0, yend = 0;
	private Color selectedColor;
	private String selectedShapeType;
	private boolean chckFill;
	private ArrayList<Shape> shapes;
	private ShapeFactory myFactory = new ShapeFactory();
	private Shape currentShape;
	Originator originator = new Originator();
	CareTaker careTaker = new CareTaker();

	public DrawingPanal() {
		selectedShapeType = "Line";
		currentShape = null;
		selectedColor = Color.black;
		chckFill = false;
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseMotionHandler);
		shapes = new ArrayList<Shape>();
	}

	public MouseListener mouseHandler = new MouseAdapter() {

		@Override
		public void mousePressed(MouseEvent e) {
			currentShape = myFactory.getShape(selectedShapeType, e.getPoint(), e.getPoint(), selectedColor, chckFill);
			repaint();

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			currentShape.setPoint2(e.getPoint());
			shapes.add(currentShape);
			originator.setState(shapes);
			originator.saveStateToMemento();
			System.out.print("added");
			currentShape = null;
			repaint();
		}
	};

	public MouseMotionListener mouseMotionHandler = new MouseMotionAdapter() {

		@Override
		public void mouseDragged(MouseEvent e) {
			currentShape.setPoint2(e.getPoint());
			repaint();
		}
	};

	public void setSelectedColor(Color color) {
		this.selectedColor = color;
	}

	public void setSelectedShapeType(String type) {
		this.selectedShapeType = type;
	}

	public void setChckFill(boolean fill) {
		this.chckFill = fill;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int counter = 0; counter < shapes.size(); counter++) {
			shapes.get(counter).draw(g);
		}
		if (currentShape != null) {
			currentShape.draw(g);
		}

	}
	public void UNDO () {
		Memento m = careTaker.undo(originator.saveStateToMemento());
        if (m !=null) {
        originator.getState();
        System.out.print("NOT");
        	repaint();
        }
	}
	
	public void REDO () {
		Memento m = careTaker.redo(originator.saveStateToMemento());
        if (m !=null) {
        	originator.setState(m.getState());
        	repaint();
        }
	}
//public void paint(Graphics g) {
//	super.paint(g);
////	int colorIndex = listColor.getSelectedIndex();
////	int shapeIndex = listShape.getSelectedIndex();
////	shapeFactory.setColor(colors[colorIndex]);
////	currentShape = shapeFactory.getShape(shapeOptions[shapeIndex]);
////	currentShape.draw(g);
//	g.setColor(selectedColor);
//	g.fillOval(Math.min(xbegin, xend), Math.min(ybegin, yend),Math.abs(xbegin-xend), Math.abs(ybegin-yend));
//////	if (fill)
//////		g.fillPolygon(new int[] { xbegin, 2 * xbegin - xend, xend }, new int[] { ybegin, yend, yend }, 3);
//////	else
//////		g.drawPolygon(new int[] { xbegin, 2 * xbegin - xend, xend }, new int[] { ybegin, yend, yend }, 3);
////	// g.fillRect(Math.min(xbegin, xend), Math.min(ybegin, yend),
////	// Math.abs(xbegin-xend), Math.abs(ybegin-yend));
//////	(xbegin, ybegin, xend, yend);
//}
}
