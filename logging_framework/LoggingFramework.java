package logging_framework;

class LoggingFramework {
    public static void main(String[] args) {
        LoggerService loggerService = new LoggerService();

        loggerService.setOutputDetination(LogLevel.INFO, new Console("terminal-console"));
        loggerService.setOutputDetination(LogLevel.ERROR, new Database("error-logs-db"));
        loggerService.setOutputDetination(LogLevel.DEBUG, new File("Debug-log-file.txt"));

        loggerService.log(new LogMessage(LogLevel.DEBUG, "Hello, I am vineel"));
        loggerService.log(new LogMessage(LogLevel.ERROR, "Hello, I am vineel"));
        loggerService.log(new LogMessage(LogLevel.INFO, "Hello, I am vineel"));
        loggerService.log(new LogMessage(LogLevel.FATAL, "Hello, I am vineel"));
    }
}
