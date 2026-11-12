package lms.model;

public class DVD extends LibraryItem{
    private int durationMinutes;

    public DVD(String id, String title, int durationMinutes){
        super(id, title);
        setDurationMinutes(durationMinutes);
    }
    //getters

    public int getDurationMinutes() {
        return durationMinutes;
    }
    //setters
    public void setDurationMinutes(int durationMinutes){
        if(durationMinutes <= 0){
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        this.durationMinutes = durationMinutes;
    }

    @Override
    public double calculateLateFee(int daysLate){
        return daysLate * 25.0;
    }
}
