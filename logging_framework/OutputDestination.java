package logging_framework;

interface OutputDestination {
    void print(String message);
}

class File implements OutputDestination{
    private String name;
    File(String name){
        this.name = name;
    }

    @Override
    public void print(String message){
        System.out.println("[FILE]: " + this.name);
        System.out.println(message);
        System.out.println();
    }
}

class Database implements OutputDestination{
    private String name;
    Database(String name){
        this.name = name;
    }

    @Override
    public void print(String message){
        System.out.println("[DATABASE]: " + this.name);
        System.out.println(message);
        System.out.println();
    }
}

class Console implements OutputDestination{
    private String name;

    Console(String name){
        this.name = name;
    }

    @Override
    public void print(String message){
        System.out.println("[CONSOLE]: " + this.name);
        System.out.println(message);
        System.out.println();
    }
}