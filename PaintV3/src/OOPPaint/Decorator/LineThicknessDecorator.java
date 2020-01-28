package OOPPaint.Decorator;

import java.awt.Graphics;

import OOPPaint.Shape;

public class LineThicknessDecorator extends ShapeDecorator {
	protected double thickness;
	public LineThicknessDecorator(Shape decoratedShape, double thickness) {
		super(decoratedShape);
		this.thickness = thickness;
	}
	@Override
	public void draw(Graphics g) {
		this.decoreatedShape.draw(g);
		
	}
	
	@Override
	public void resize() {
		this.decoreatedShape.resize();
	}
	
	@Override
	public boolean isHiden() {
		return this.decoreatedShape.isHiden();
	}
	

}
