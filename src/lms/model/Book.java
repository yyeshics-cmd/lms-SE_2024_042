package lms.model;

public class Book extends LibraryItem implements Reservable{
    private String author;
    private Member reservedBy;

    public Book(String id, String title, String author){
        super(id, title);
        setAuthor(author);
    }

    //getters
    public String getAuthor(){
        return author;
    }
    //setters
    public void setAuthor(String author){
        if(author == null || author.isBlank()){
            throw new IllegalArgumentException("Author cannot be empty");
        }
        this.author = author;
    }

    @Override
    public void reserve(Member m){
        this.reservedBy = m;
        System.out.println(getId() + ": " + getTitle() + " reserved for " + m.getName());
    }

    @Override
    public void cancelReservation() {
        this.reservedBy = null;
    }

    @Override
    public boolean isReserved() {
        return false;
    }

    @Override
    public double calculateLateFee(int daysLate){
        return daysLate * 10.0;
    }
}
