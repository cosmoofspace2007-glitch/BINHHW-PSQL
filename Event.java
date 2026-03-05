package Baiseasion16;

import java.time.LocalDateTime;

public class Event
{
    private String name;
    private LocalDateTime Startdate;
    private LocalDateTime Enddate;

    public  Event(String name, LocalDateTime Startdate, LocalDateTime Enddate)
    {
        this.name = name;
        this.Startdate = Startdate;
        this.Enddate = Enddate;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDateTime getStartdate()
    {
        return Startdate;
    }
    public void setStartdate(LocalDateTime startdate)
    {
        this.Startdate = startdate;
    }

    public LocalDateTime getEnddate()
    {
        return Enddate;
    }
    public void setEnddate(LocalDateTime enddate)
    {
        this.Enddate = enddate;
    }

    @Override
    public String toString()
    {
        return "Name: " + name + ", Startdate: " + Startdate + ", Enddate: " + Enddate;
    }
}
