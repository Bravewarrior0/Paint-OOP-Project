package OOPPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends PointShape {
	public Triangle(Point p1, Point p2, Color color, boolean fill) {
		super(p1, p2, color, fill);
	}

	public Triangle() {
		super();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		if (getFilled()) {
			g.fillPolygon(new int[] { getStartX(), 2 * getStartX() - getEndX(), getEndX() },
					new int[] { getStartY(), getEndY(), getEndY() }, 3);
		} else {
			g.drawPolygon(new int[] { getStartX(), 2 * getStartX() - getEndX(), getEndX() },
					new int[] { getStartY(), getEndY(), getEndY() }, 3);
		}

	}

	@Override
	public void update(Color color) {
		this.setColor(color);
	}
}