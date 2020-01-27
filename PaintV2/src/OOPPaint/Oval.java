package OOPPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends BoundedShape {
	
	public Oval (Point p1, Point p2, Color color, boolean fill) {
		super(p1,p2,color,fill);
	}
	public Oval() {
		super();
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		if(getFilled()) {
			g.fillOval(getStartX(), getStartY(), getWidth(), getHeight());
		}
		else {
			g.drawOval(getStartX(), getStartY(), getWidth(), getHeight());
		}
	}
}
