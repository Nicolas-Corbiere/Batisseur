package logger;

public class SimpleLogger {

    public boolean afficheTrace;

    public boolean isAfficheTrace() {
        return afficheTrace;
    }

    public SimpleLogger(boolean afficheTrace){
        this.afficheTrace = afficheTrace;
    }

    public void afficheMessage(String msg) {
        System.out.println(msg);
    }

    public void afficheMessageErreur(String msg) {
        System.out.println(ColorConsole.RED + msg);
    }
}
