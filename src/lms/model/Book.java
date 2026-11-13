package lms.model;

public class Book extends LibraryItem{
    private String author;

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

}
