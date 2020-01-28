package OOPPaint;

import java.util.ArrayList;

public class Originator {
	private ArrayList<Shape> state;

	   public void setState(ArrayList<Shape> state){
	      this.state = state;
	   }

	   public ArrayList<Shape> getState(){
	      return this.state;
	   }

	   public Memento saveStateToMemento(){
	      return new Memento(this.state);
	   }

	   public void getStateFromMemento(Memento memento){
	      this.state = memento.getState();
	   }
}
