package studentCoursesMgmt.util;

import java.util.ArrayList;
import java.util.List;

public class Node implements Subject, Observer{
    int bNumber;
    String firstName;
    Node left;
    Node right;

    // List of observers along with their corresponding filters
    private List<Pair<Observer, Filter>> observers = new ArrayList<>();

    public Node(int bNumber, String firstName) {
        this.bNumber = bNumber;
        this.firstName = firstName;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "BNumber: " + bNumber + ", FirstName: " + firstName;
    }

    public int getBNumber() {
        return bNumber;
    }


    public Node getLeft() {
        return left;
    }

    public String getFirstName() {
        return firstName;
    }

    public Node getRight() {
        return right;
    }

   @Override
    public void registerObserver(Observer observer, Filter filter) {
        observers.add(new Pair<>(observer, filter));
    }

    @Override
    public void notifyObservers(int BNumber, String firstName) {
        for (Pair<Observer, Filter> pair : observers) {
            Observer observer = pair.getKey();
            Filter filter = pair.getValue();
            if (filter.check(BNumber)) {
                observer.update(BNumber, firstName);
            }
        }
    }


    @Override
    public void update(int BNumber, String firstName) {
        this.setbNumber(BNumber);
    }

    public void setbNumber(int bNumber) {
        this.bNumber = bNumber;
    }
}
