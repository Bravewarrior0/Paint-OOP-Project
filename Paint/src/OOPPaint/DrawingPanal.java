package OOPPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawingPanal extends JPanel {
	private Color selectedColor;
	private String selectedShapeType;
	private boolean chckFill;
	private ArrayList<Shape> shapes;
	private ShapeFactory myFactory = new ShapeFactory();
	private Shape currentShape;

//	private Originator originator = new Originator();
	private CareTaker careTaker = new CareTaker();

	public DrawingPanal() {
		selectedShapeType = "Line";
		currentShape = null;
		selectedColor = Color.black;
		chckFill = false;
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseMotionHandler);
		shapes = new ArrayList<Shape>();
		careTaker.add(saveStateToMemento());
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
			if (currentShape != null) {
				addObserver(currentShape);
				careTaker.add(saveStateToMemento());
			}
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

	public void updateAllColor() {
		notifyAllObservers(selectedColor);
		careTaker.add(saveStateToMemento());
	}

// observer design pattern
	public void notifyAllObservers(Color color) {
		for (Shape observer : shapes) {
			observer.update(color);
		}
		repaint();
	}

	public void addObserver(Shape observer) {
		shapes.add(observer);
	}

	public void undo() {
		Memento m = careTaker.undo(saveStateToMemento());
		if (m != null) {
			getStateFromMemento(m);
			repaint();
		}
	}

	public void redo() {
		Memento m = careTaker.redo(saveStateToMemento());
		if (m != null) {
			getStateFromMemento(m);
			repaint();
		}
	}

	// Originator
	public void setState(ArrayList<Shape> state) {
		this.shapes = state;
	}

	public ArrayList<Shape> getState() {
		return this.shapes;
	}

	public Memento saveStateToMemento() {
		return new Memento(this.shapes);
	}

	public void getStateFromMemento(Memento memento) {
		this.shapes = memento.getState();
	}
}
