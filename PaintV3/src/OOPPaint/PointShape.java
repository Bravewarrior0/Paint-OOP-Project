package OOPPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class PointShape implements Shape, Cloneable {
	private Point p1, p2;
	private Color color;
	private boolean fill;

	public PointShape() {
		this.p1 = new Point(0, 0);
		this.p2 = new Point(0, 0);
		this.color = Color.black;
		this.fill = false;
	}

	public PointShape(Point p1, Point p2, Color color, boolean fill) {
		this.p1 = p1;
		this.p2 = p2;
		this.color = color;
		this.fill = fill;
	}

	public PointShape(Point p1, Point p2, Color color) {
		this.p1 = p1;
		this.p2 = p2;
		this.color = color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setPoint1(Point p1) {
		this.p1 = p1;
	}

	public void setPoint2(Point p2) {
		this.p2 = p2;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public int getStartX() {
		return p1.x;
	}

	public int getStartY() {
		return p1.y;
	}
	public int getEndX() {
		return p2.x;
	}

	public int getEndY() {
		return p2.y;
	}

	public Color getColor() {
		return color;
	}

	public boolean getFilled() {
		return fill;
	}
    // Using Prototype design pattern
    public Object clone() {
        Shape clone = null;

        try {
            clone = (Shape) super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
	abstract public void draw(Graphics g);

}
