package biblioteca;
public class BookAvailabilityHandler extends AprovationHandler{

    @Override
    public boolean handleRequest(Copy copy) {
        return copy.isAvailable();
    }
}