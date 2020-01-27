package OOPPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public interface Shape {
	public void draw(Graphics g);

	public void setColor(Color color);

	public Color getColor();

	public void setPoint1(Point p1);

	public void setPoint2(Point p2);
}
