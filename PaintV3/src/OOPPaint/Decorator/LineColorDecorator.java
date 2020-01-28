package OOPPaint.Decorator;

import java.awt.Graphics;

import OOPPaint.Shape;

public class LineColorDecorator extends ShapeDecorator  {
	protected Color color;
	public LineColorDecorator(Shape decoratedShape, Color color) {
		super(decoratedShape);
		this.color = color;
	}
	
	@Override
	public void draw(Graphics g) {
		this.decoreatedShape.draw(g);
	}
	
	@Override
	public void resize() {
		
	}
	
	@Override
	public boolean isHiden() {
		return this.decoreatedShape.isHiden();
	}

}
