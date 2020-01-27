package OOPPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line extends PointShape {
	public Line(Point p1, Point p2, Color color) {
		super(p1, p2, color);
	}

	public Line() {
		super();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(getStartX(), getStartY(), getEndX(), getEndY());

	}
}
