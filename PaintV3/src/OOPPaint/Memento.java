package OOPPaint;

import java.util.ArrayList;


//MEMENTO DESIGN PATTERN IMPLEMENTATION 
public class Memento {

	private ArrayList<Shape> state;

	public Memento(ArrayList<Shape> newState) {
		this.state = newState;
		
        // Deep copy
        this.state = new ArrayList<Shape>();
        for (Shape shape : newState) {
            state.add((Shape) shape.clone());
        }
	}

	public ArrayList<Shape> getState() {
		return this.state;
	}
}
