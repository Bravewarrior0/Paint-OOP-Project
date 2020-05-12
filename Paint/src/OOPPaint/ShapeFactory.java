package OOPPaint;

import java.awt.Color;
import java.awt.Point;

public class ShapeFactory {
//	private Color color;
//	private Point p1,p2;
//	private boolean fill;
//	public ShapeFactory() {
//		this.color=Color.black;
//		this.p1=new Point(0,0);
//		this.p2=new Point(0,0);
//		this.fill=false;
//	}
	public Shape getShape(String shapeType, Point p1, Point p2, Color color, boolean fill) {
		if (shapeType == null) {
			return new Line(p1, p2, color);
		} else if (shapeType == "Line") {
			return new Line(p1, p2, color);
		}
		if (shapeType.equalsIgnoreCase("Oval")) {
			return new Oval(p1, p2, color, fill);

		} else if (shapeType.equalsIgnoreCase("Rectangle")) {
			return new Rectangle(p1, p2, color, fill);

		} else if (shapeType.equalsIgnoreCase("Triangle")) {
			return new Triangle(p1, p2, color, fill);
		}

		return null;
	}
}
