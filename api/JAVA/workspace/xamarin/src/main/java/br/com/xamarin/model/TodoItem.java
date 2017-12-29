package br.com.xamarin.model;

import javax.persistence.Entity;

@Entity
public class TodoItem extends AbstractEntity  {

	private static final long serialVersionUID = 1L;
	
	//private static final long serialVersionUID = -6647232303706462444L;

	private String name;
	private String notes;
    private boolean done;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
    
    
}
