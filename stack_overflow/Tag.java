package stack_overflow;

import java.util.Random;

class Tag{
    private Integer id;
    private String content;

    Tag(String content){
        this.id = this.generateId(); 
        this.content = content;
    }

    public Integer getId(){
        return this.id;
    }

    private Integer generateId(){
        Random random = new Random();
        return (int) ((System.nanoTime() + random.nextInt(10000) ) % 10000);
    }

    public String get(){
        return this.content;
    }
}