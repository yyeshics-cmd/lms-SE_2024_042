package lms.model;

public abstract class LibraryItem{
    private String id;
    private String title;
    private boolean isBorrowed;

    public LibraryItem(String id, String title){
        setID(id);
        setTitle(title);
        isBorrowed = false;
    }

    //Getters
    public String getID(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public boolean isBorrowed(){
        return isBorrowed;
    }

    //Setter for ID
    public void setID(String id){
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("Id cannot be blank");
        }

        this.id = id;
    }

    //Setter for title
    public void setTitle(String title){
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be blank");
        }

        this.title = title;
    }

    //Borrow the item
    public void burrowItem(){
        isBorrowed = true;
    }

    //Return the item
    public void returnItem(){
        isBorrowed = false;
    }

    //Calculate late fee
    public double calculateLateFee(int daysLate){
        return daysLate * 10.0;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + "{id='" + id + "', title='" + title + "', borrowed=" + isBorrowed + "}";
    }
}