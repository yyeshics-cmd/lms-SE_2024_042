package lms.model;

public class LibraryItem {
    private String id;
    private String title;
    private boolean isBorrowed;

    public LibraryItem(String id, String title){
        setId(id);
        setTitle(title);
        this.isBorrowed = false;
    }

    //getters
    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public boolean isBorrowed(){
        return isBorrowed;
    }

    //setters
    public void setId(String id){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ID cannot be empty");
        }
        this.id = id;
    }
    public void setTitle(String title){
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public void setBorrowed(boolean borrowed){
        this.isBorrowed = borrowed;
    }

    public double calculateLateFee(int daysLate){
        return daysLate * 10.0;
    }

    public String toString(){
        return getClass().getSimpleName() + "{ID = '" + id + "', Title = '" + title + "', Borrowed = " + isBorrowed + "}";
    }

}
