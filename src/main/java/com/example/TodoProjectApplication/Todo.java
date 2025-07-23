package com.example.TodoProjectApplication;

public class Todo{
	private int that;
	private boolean completed;
	private String title;
	private int userId;



	public Todo(int that, boolean completed, String title, int userId) {
		this.that = that;
		this.completed = completed;
		this.title = title;
		this.userId = userId;
	}

	public void setThat(int that){
		this.that = that;
	}

	public int getThat(){
		return that;
	}

	public void setCompleted(boolean completed){
		this.completed = completed;
	}

	public boolean isCompleted(){
		return completed;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}



	@Override
 	public String toString(){
		return 
			"Todo{" + 
			"that = '" + that + '\'' + 
			",completed = '" + completed + '\'' + 
			",title = '" + title + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}
