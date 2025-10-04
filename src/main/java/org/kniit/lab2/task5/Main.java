package main.java.org.kniit.lab2.task5;

abstract class FileSystemComponent {
    private String name;
    private int size;
    private String path;

    public FileSystemComponent(String name, int size) {
        this.name = name;
        this.size = size;
    }
    String getName(){
        return this.name;
    }
    int getSize(){
        return this.size;
    }
    void add(FileSystemComponent component){
        this.size += component.getSize();
    }
    void remove(FileSystemComponent component){
        this.size -= component.getSize();
    }
}
//
//class File extends FileSystemComponent {
//
//}

public class Main {
}