package studentCoursesMgmt.util;

public interface Subject {
    void registerObserver(Observer observer, Filter filter);
    void notifyObservers(int BNumber, String firstName);
}
