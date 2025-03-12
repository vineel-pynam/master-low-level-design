package logging_framework;
import java.util.*;

class LoggerService {
    // For multiple desitnation pass arraylist.
    // to handle concurrency -> use Concurrent hashmap, and copyonarraylist.
    // and also lock critical sections.
    private Map<LogLevel, OutputDestination> desitnationMap;
    // private OutputDestination defaultDestination;

    LoggerService(){
        this.desitnationMap = new HashMap<>();
    }
    
    // public void setDefaultDestination(OutputDestination outputDestination){
    //     this.defaultDestination = outputDestination;
    // }

    public void setOutputDetination(LogLevel logLevel, OutputDestination outputDestination){
        this.desitnationMap.put(logLevel, outputDestination);
    }

    public void unsetOutputDestination(LogLevel logLevel){
        this.desitnationMap.remove(logLevel);
    }

    public void log(LogMessage logMessage){
        OutputDestination outputDestination = this.desitnationMap.getOrDefault(logMessage.getLogLevel(), null);
        if( outputDestination == null ){
            System.out.println("[ERROR]: No destination found");
        }else{
            LogFormattter logFormattter  = LogFormatterFactory.getLogFormattter();
            outputDestination.print(logFormattter.format(logMessage));
        }
    }


}
