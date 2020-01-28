package OOPPaint.Decorator;

import java.awt.Graphics;

import OOPPaint.Shape;

public class LineStyleDecorator extends ShapeDecorator {
	protected LineStyle style;
	public LineStyleDecorator(Shape decoratedShape, LineStyle style) {
		super(decoratedShape);
		this.style = style;
	}
	
	@Override
	public void draw (Graphics g) {
		this.decoreatedShape.draw(g);
	}
	
	@Override
	public void resize(){
		this.decoreatedShape.resize();
	}
	
	@Override
	public boolean isHiden() {
		return this.decoreatedShape.isHiden();
	}
}
