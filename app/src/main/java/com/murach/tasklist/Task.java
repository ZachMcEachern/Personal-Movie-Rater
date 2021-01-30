package com.murach.tasklist;

public class Task {

    private long taskId;
    private long listId;
    private String nameOfMovie;
    private String stringRating;
    private String dateSeen;
    private String hidden;
    
    public static final String TRUE = "1";
    public static final String FALSE = "0";
    
    public Task() {
        nameOfMovie = "";
        stringRating = "";
        dateSeen = FALSE;
        hidden = FALSE;
    }

    public Task(int listId, String nameOfMovie, String stringRating,
                String completed, String hidden) {
        this.listId = listId;
        this.nameOfMovie = nameOfMovie;
        this.stringRating = stringRating;
        this.dateSeen = completed;
        this.hidden = hidden;
    }

    public Task(int taskId, int listId, String nameOfMovie, String stringRating,
                String completed, String hidden) {
        this.taskId = taskId;
        this.listId = listId;
        this.nameOfMovie = nameOfMovie;
        this.stringRating = stringRating;
        this.dateSeen = completed;
        this.hidden = hidden;
    }

    public long getId() {
        return taskId;
    }

    public void setId(long taskId) {
        this.taskId = taskId;
    }
    
    public long getListId() {
        return listId;
    }

    public void setListId(long listId) {
        this.listId = listId;
    }
    
    public String getNameOfMovie() {
        return nameOfMovie;
    }

    public void setNameOfMovie(String nameOfMovie) {
        this.nameOfMovie = nameOfMovie;
    }

    public String getStringRating() {
        return stringRating;
    }

    public void setStringRating(String stringRating) {
        this.stringRating = stringRating;
    }

    public String getDateSeen() {
        return dateSeen;
    }

    /*
    public long getCompletedDateMillis() {
        return Long.parseLong(dateSeen);
    }
    */

    public void setDateSeen(String dateSeen) {
        this.dateSeen = dateSeen;
    }
    
    public void setCompletedDate(long millis) {
        this.dateSeen = Long.toString(millis);
    }

    public String getHidden(){
        return hidden;
    }
    
    public void setHidden(String hidden) {
        this.hidden = hidden;    
    }    
}