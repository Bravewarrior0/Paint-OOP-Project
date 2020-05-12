package OOPPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends BoundedShape {
	public Rectangle (Point p1, Point p2, Color color, boolean fill) {
		super(p1,p2,color,fill);
	}
	public Rectangle() {
		super();
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		if(getFilled()) {
			g.fillRect(getStartX(), getStartY(), getWidth(), getHeight());
		}
		else {
			g.drawRect(getStartX(), getStartY(), getWidth(), getHeight());
		}
	}
	@Override
	public void update(Color color) {
		this.setColor(color);
	}

}