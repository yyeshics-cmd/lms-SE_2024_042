package lms;

import lms.model.Book;
import lms.model.Member;
import lms.service.Library;

public class Main {
    public static void main(String[] args){
        Library library = new Library();

        library.addBook(new Book("Clean Code", "Robert C.Martin", "987-1234526789"));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "987-3456783424"));
        library.addBook(new Book("The Pragmatic Programmer", "Hunt & Thomas", "987-5678123425"));

        library.addMember(new Member("M001", "Yeshika Gallage"));
        library.addMember(new Member("M002", "Hamna Fathima"));

        library.listBooks();
        library.listMembers();

        try{
            library.addBook(new Book("", "Nobody", "000-0000000000"));
        }catch(IllegalArgumentException e){
            System.out.println("Rejected invalid book: " + e.getMessage());
        }
    }
}
