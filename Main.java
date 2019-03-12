package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Example example=new Example();
        example.arrayTestException();
        System.out.println("Hi");*/
        SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy-mm-dd");
        Date date1 = null;
        try {
            date1 = dateformat3.parse("1974-10-10");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Person osoba=new Person("The","Man","830416/9313",date1);
        Database database=new Database();
        //database.insertNewPerson(osoba);
        Person p = database.selectPersonByLastName("Krivy");
        System.out.println(p.getFname()+" "+p.getLname()+" "+p.getDob());

        List<Person> persons = database.getAllMens();
        System.out.println("List of mens:");
        for(Person person : persons){
            System.out.println(person.getFname()+" "+person.getLname()+" "+person.getDob());
        }
    }
    public int add(int a, int b){
        return a+b;
    }
}