package lms.model;

public class Member{
    private String memberId;
    private String name;
    private int borrowedCount;
    private int maxBorrowLimit;

    public Member(String memberId, String name, int maxBorrowLimit){
        setMemberID(memberId);
        setName(name);
        this.maxBorrowLimit = maxBorrowLimit;
        this.borrowedCount = 0;
    }

    //Getters
    public String getMemberID(){
        return memberId;
    }
    public String getName(){
        return name;
    }
    public int getBorrowedCount() {
        return borrowedCount;
    }
    public int getMaxBorrowLimit() {
        return maxBorrowLimit;
    }

    //Setters
    public void setMemberID(String memberID) {
        if(memberId == null || memberId.isBlank()){
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.memberId = memberId;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
    }

    public void setBorrowedCount(int count){
        if(count < 0){
            throw new IllegalArgumentException("Borrowed count cannot be negative");
        }
        this.borrowedCount = count;
    }

    public void incrementBorrowedCount(){
        setBorrowedCount(this.borrowedCount +1);
    }

    public String toString(){
        return getClass().getSimpleName() + "id='" + memberId + "', name='" + name + "', borrowedCount=" + borrowedCount + ", limit=" + maxBorrowLimit + "}";
    }

}