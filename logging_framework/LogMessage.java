package logging_framework;

class LogMessage {
    private LogLevel logLevel;
    private String message;

    public LogMessage(LogLevel logLevel, String message){
        this.logLevel = logLevel;
        this.message = message;
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }
    public String getMessage() {
        return this.message;
    }

    // public String display(){
    //     return "["+this.logLevel.toString()+"]: "  + message;
    // }
}
