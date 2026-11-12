package lms;

import lms.model.*;
import lms.service.Library;

public class Main {
    public static void main(String[] args){
        Library library = new Library();

        Book b1 = new Book("B001", "Clean Code", "Robert C.Martin");
        Book b2 = new Book("B002", "Effective Java", "Joshua Bloch");
        DVD d1 = new DVD("D001", "Introduction to Algorithms", 120);

        library.addItem(b1);
        library.addItem(b2);
        library.addItem(d1);


        Student s1 = new Student("S001", "Alice");
        Staff st1 = new Staff("ST001", "Dr. Smith");

        library.addMember(s1);
        library.addMember(st1);


        library.listLibraryItem();
        library.listMembers();
        library.printAllLateFees(3);

        library.streamIfPossible(d1);
        library.streamIfPossible(b1);

    }
}
