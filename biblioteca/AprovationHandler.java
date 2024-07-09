package biblioteca;

public abstract class AprovationHandler implements Handler {
    protected Handler nextHandler;

    @Override
    public void setNextHandler(Handler nexHandler) {
        this.nextHandler = nexHandler;
    }

    @Override
    public boolean handleRequest(User user, Copy copy) {
        if (nextHandler != null) {
            return nextHandler.handleRequest(user, copy);
        }
        else {
            return true;
        }
    }
}
