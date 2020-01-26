package OOPPaint;

import java.awt.Graphics;

public class Oval implements Shape {
	
	@Override
	public void draw(Graphics g) {

	}
	
	public void resize() {
		System.out.print("OVAL");
	}
	
	public boolean isHiden() {
		return false;
	}
}
