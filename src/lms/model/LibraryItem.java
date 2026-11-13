package lms.model;

public abstract class LibraryItem implements Loanable{
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

    @Override
    public void loan(Member member){
        if(isBorrowed){
            System.out.println(title + " is already on loan.");
        }else if(member.getBorrowedCount() >= member.getMaxBorrowedLimit()){
            System.out.println(member.getName() + " has reached the maximum borrow limit.");
        }else{
            isBorrowed = true;
            member.incrementBorrowedCount();
            System.out.println(title + " loaned to " + member.getName());
        }
    }

    public void returnItem(){
        if(isBorrowed){
            isBorrowed = false;
            System.out.println(title + " returned.");
        }else{
            System.out.println(title + " was not on loan.");
        }
    }

    public abstract double calculateLateFee(int daysLate);

    public String toString(){
        return getClass().getSimpleName() + "{ID = '" + id + "', Title = '" + title + "', Borrowed = " + isBorrowed + "}";
    }

}
