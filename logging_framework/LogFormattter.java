package logging_framework;

interface LogFormattter {
    String format(LogMessage logMessage);
}

class SimpleLogFormatter implements LogFormattter{
    @Override
    public String format(LogMessage logMessage){
        return "["+logMessage.getLogLevel().toString()+ "]: " + logMessage.getMessage();
    }
}
