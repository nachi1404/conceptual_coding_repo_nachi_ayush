import java.util.*;
import java.util.Vector;
class Event
{
    int eventno;
    String name;
    String date;
    String time;
    String venue;
    String additional;
    public Event()
    {
        name = date = time = venue = additional = null;
    }
}
class Techno_rush extends Event
{
    private int ct;
    private Vector<Event> event;
    public Techno_rush()
    {
        ct = 0;
        event = new Vector<Event>();
    }
    public void add_event()
    {
        Scanner sc = new Scanner(System.in);
        Event obj = new Event();
        System.out.println("Enter name of event: ");
        obj.name = sc.nextLine();
        System.out.println("Enter date of event: ");
        obj.date = sc.nextLine();
        System.out.println("Enter Venue of event: ");
        obj.venue = sc.nextLine();
        System.out.println("Enter time of the event: ");
        obj.time = sc.nextLine();
        System.out.println("Enter any additional information: ");
        obj.additional = sc.nextLine();
        obj.eventno = ++ct;
        event.add(obj);
    }
    public void display()
    {
        for(Event e: event)
        {
            System.out.println();
            System.out.println("Event number = "+e.eventno);
            System.out.println("Name = "+e.name);
            System.out.println("Date = "+e.date);
            System.out.println("Event Venue = "+e.venue);
            System.out.println("Additional Information = "+e.additional);
        }
    }
    public void display_event_for_changes()
    {
        for(Event e: event)
        {
            System.out.println();
            System.out.println("Event number = "+e.eventno);
            System.out.println("Name = "+e.name);
        }
    }
    public void modify()
    {
        Scanner sc = new Scanner(System.in);
        display_event_for_changes();
        System.out.println("Enter event number: ");
        int i = sc.nextInt();
        sc.nextLine();
        Event obj = event.get(i-1);
        System.out.println("Enter the details to be changed: ");
        String s = sc.nextLine().toLowerCase().trim();
        switch(s)
        {
            case "name":
                System.out.println("Enter new name: ");
                obj.name = sc.nextLine().trim().toUpperCase();
                break;
            case "date":
                System.out.println("Enter new date: ");
                obj.date = sc.nextLine().trim().toUpperCase();
                break;
            case "venue":
                System.out.println("Enter new venue: ");
                obj.venue = sc.nextLine().trim().toUpperCase();
                break;
            case "time":
                System.out.println("Enter new time: ");
                obj.time = sc.nextLine().trim().toUpperCase();
                break;
            case "additional":
                System.out.println("Enter new additional information: ");
                obj.additional = sc.nextLine().trim().toUpperCase();
                break;
            default:
                System.out.println("Invalid input, try again");
                break;
        }
        event.add(obj);
    }
    public void delete()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select event from the following: ");
        display_event_for_changes();
        System.out.println("Enter the event number: ");
        int i = sc.nextInt();
        event.remove(i-1);
    }
    public static void main(String[] args) 
    {
        System.out.println("***This is a Event Management Program");
        Scanner sc = new Scanner(System.in);
        Techno_rush trush = new Techno_rush();
        while(true) 
        {
            
            System.out.println("Please select from below options:-");
            System.out.println("1.Add Event");
            System.out.println("2.Display Event Detail");
            System.out.println("3.Modify Event Information");
            System.out.println("4.Delete Event");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) 
            {
                case 1:
                    trush.add_event();
                    break;
                case 2:
                    trush.display();
                    break;
                case 3:
                    trush.modify();
                    break;
                case 4:
                    trush.delete();
                    break;
                default:
                    System.out.println("Invalid input!!!, please try again");
                    break;
            }
        }
    }
}
