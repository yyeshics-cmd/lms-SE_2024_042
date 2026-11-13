package lms;

import lms.model.*;
import lms.service.Library;

public class Main {
    public static void main(String[] args){
        Library library = new Library();

        Book b1 = new Book("B001", "Clean Code", "Robert C.Martin");
        Book b2 = new Book("B002", "Effective Java", "Joshua Bloch");
        DVD d1 = new DVD("D001", "Introduction to Algorithms", 120);
        Magazine m1 = new Magazine("M001", "Software Weekly", 42);

        library.addItem(b1);
        library.addItem(b2);
        library.addItem(d1);
        library.addItem(m1);

        Student s1 = new Student("S001", "Alice");
        Staff st1 = new Staff("ST001", "Dr. Smith");

        library.addMember(s1);
        library.addMember(st1);

        library.lend(b1, s1);
        library.lend(b1, st1);
        library.lend(d1, st1);
        library.lend(m1, st1);

        library.reserveIfPossible(b1, st1);
        library.reserveIfPossible(d1, st1);

        //library.listLibraryItem();
        //library.listMembers();

        library.printAllLateFees(3);

        library.printMembersByActivity();

        library.streamIfPossible(d1);
        library.streamIfPossible(b1);

    }
}
