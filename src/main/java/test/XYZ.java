package test;

public class XYZ extends ABC {

    @Override
    public void foo(){
        System.out.println("XYZ FOO");
    }

    public void bar2(){
        this.bar();
    }
}
