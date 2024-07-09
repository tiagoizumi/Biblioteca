package biblioteca;

public abstract class AprovationHandler implements Handler {
    protected Handler nextHandler;

    @Override
    public void setNextHandler(Handler nexHandler) {
        this.nextHandler = nexHandler;
    }

    public boolean handleRequest(Copy copy) {
        if (nextHandler != null) {
            return nextHandler.handleRequest(copy);
        }
        else {
            return true;
        }
    }
}
