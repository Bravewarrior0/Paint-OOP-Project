package OOPPaint.Decorator;

import java.awt.Graphics;

import OOPPaint.Shape;

public class FillColorDecorator extends ShapeDecorator {
	protected Color color;

	public FillColorDecorator(Shape decoratedShape, Color color) {
		super(decoratedShape);
		this.color = color;
	}

	@Override
	public void draw(Graphics g) {

	}

	@Override
	public void resize() {
	}
	
	@Override
	public boolean isHiden() {
		return this.decoreatedShape.isHiden();
	}

}
