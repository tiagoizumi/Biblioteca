package biblioteca;

public interface Handler {
    public void setNextHandler(Handler nextHandler);
    public boolean handleRequest(Copy copy);
}
