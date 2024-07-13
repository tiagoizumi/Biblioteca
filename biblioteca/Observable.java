package biblioteca;
import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer o) {
        observers.add(o); // Adiciona um observer a lista de observers
    }

    public void detach(Observer o) {
        observers.remove(o); // Remove um observer da lista de observers
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) { // Notifica todos os observers
            observer.update(message);
        }
    }

    public void bookStatusChanged(Copy copy) {
        notifyObservers(copy.getTitle() + " is now available");
    }
}