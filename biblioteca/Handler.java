package biblioteca;

public interface Handler {
    public void setNextHandler(Handler nextHandler);
    public boolean handleRequest(User user, Copy copy);
}
