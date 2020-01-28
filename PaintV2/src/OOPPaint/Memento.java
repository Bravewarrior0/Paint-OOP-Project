package OOPPaint;
import java.util.*;



public class Memento {
	// MEMENTO DESIGN PATTERN IMPLEMENTATION 
	 private ArrayList<Shape> state;

	   public Memento(ArrayList<Shape> state){
	      this.state = state;
	   }

	   public ArrayList<Shape> getState(){
	      return this.state;
	   }	
}
