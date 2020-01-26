package OOPPaint.Decorator;

import OOPPaint.Shape;

public abstract class ShapeDecorator implements Shape {
   protected Shape decoreatedShape;
   public ShapeDecorator (Shape decoratedShape) {
	   super();
	   this.decoreatedShape = decoratedShape;
   }

}
