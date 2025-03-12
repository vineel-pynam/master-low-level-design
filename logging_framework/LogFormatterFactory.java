package logging_framework;

public class LogFormatterFactory {
    
    public static LogFormattter getLogFormattter(){
        // we can pass formatter type as argument and have an if else to select & return a log formatter based on the formatter type passed.
        // more if else will lead ocp problem, in that case we can have a map<FormatterType, LogFormatter>. and addFormatter method.
        // we can seamlessly add more formatter without touching the class.
        return new SimpleLogFormatter();
    }

}
