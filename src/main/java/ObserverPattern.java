import java.util.ArrayList;

/**
 * Created by tianhe on 2017/1/24.
 */
interface Subject{
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
interface Observer{
    void update(String name, int price);
}
interface DisplayElement{
    void display();
}

class PianYiHuoNotify implements Subject{
    private ArrayList<Observer> observers;
    private String name;
    private int price;

    PianYiHuoNotify(){
        observers = new ArrayList<Observer>();
    }
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for(Observer observer: observers){
            observer.update(name, price);
        }
    }
    public void MessageChange(){
        notifyObservers();
    }
    public void setMessage(String name, int price){
        this.name = name;
        this.price = price;
        MessageChange();
    }
}
class NotifyDisplay implements Observer, DisplayElement{
    Subject subject;
    String name;
    int price;
    NotifyDisplay(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }
    public void update(String name, int price) {
        this.name = name;
        this.price = price;
        display();
    }
    public void display() {
        System.out.println(name +":" +  price);
    }
}
public class ObserverPattern {
    public static void main(String[] args){
        PianYiHuoNotify notify = new PianYiHuoNotify();
        NotifyDisplay display = new NotifyDisplay(notify);
        notify.setMessage("巧克力", 10);
    }


}
