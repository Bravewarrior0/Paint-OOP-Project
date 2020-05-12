package OOPPaint;

import java.util.Stack;

public class CareTaker {
	private Stack<Memento> undoStack = new Stack<Memento>();
	private Stack<Memento> redoStack = new Stack<Memento>();

	public void add(Memento state) {
		undoStack.push(state);
		redoStack.clear();
	}

	public Memento undo(Memento state) {
		if (undoStack.isEmpty())
			return null;
		redoStack.push(state);
		return undoStack.pop();
	}

	public Memento redo(Memento state) {
		if (redoStack.isEmpty())
			return null;
		undoStack.push(state);
		return redoStack.pop();
	}
}
