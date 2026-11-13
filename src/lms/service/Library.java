package lms.service;

import lms.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private final List<LibraryItem> items = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    public void addItem(LibraryItem item){
        items.add(item);
        System.out.println("Added via addItem(LibraryItem): " + item.getTitle());
    }
    public void addItem(Book book){
        items.add(book);
        System.out.println("Added via addItem(Book): " + book.getTitle());
    }
    public void addItem(DVD dvd){
        items.add(dvd);
        System.out.println("Added via addItem(DVD): " + dvd.getTitle());
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void lend(Loanable thing, Member member){
        thing.loan(member);
    }

    public void reserveIfPossible(LibraryItem item, Member member){
        if(item instanceof Reservable r){
            r.reserve(member);
        }else{
            System.out.println(item.getTitle() + " cannot be reserved.");
        }
    }

    //getters
    public List<LibraryItem> getLibraryItem(){
        return items;
    }
    public List<Member> getMembers(){
        return members;
    }

    public void listLibraryItem(){
        System.out.println("--- Library Items in the library ---");
        for(LibraryItem item : items){
            System.out.println(item);
        }
    }

    public void listMembers(){
        System.out.println("--- Registered members ---");
        for(Member member : members){
            System.out.println(member);
        }
    }

    public void printAllLateFees(int daysLate){
        System.out.println("--- Late fees if " + daysLate + " day(s) late ---");
        for(LibraryItem item : items){
            System.out.println(item.getTitle() + ": " + item.calculateLateFee(daysLate));
        }
    }

    public void printMemberByActivity(){
        List<Member> sortedMembers = new ArrayList<>(members);
        Collections.sort(sortedMembers);
        for(Member m : sortedMembers){
            System.out.println(m.getName() + " (" + m.getBorrowedCount() + " borrowed)");
        }
    }

    public void streamIfPossible(LibraryItem item){
        if(item instanceof DVD dvd){
            System.out.println("Streaming \"" + dvd.getTitle() + "\" (" + dvd.getDurationMinutes() + " min)...");
        }else{
            System.out.println(item.getTitle() + " cannot be streamed - it isn't a DVD.");
        }
    }
}
