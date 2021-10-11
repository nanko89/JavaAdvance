package EqualityLogic;

public class ComparatorPerson implements java.util.Comparator<Person> {


    @Override
    public int compare(Person p1, Person p2) {
        int result = p1.getName().compareTo(p2.getName());
        if (result == 0){
            result = Integer.compare(p1.getAge(), p2.getAge());
        }
        return result;
    }
}
