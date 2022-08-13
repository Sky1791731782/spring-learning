package sky.demo2;

public class SomeServiceImp implements SomeService {
    @Override
    //增加功能
    public void dosome(String s) {
        System.out.println("dosome方法调用");
    }

    @Override
    public Student doother() {
        System.out.println("dother方法调用");
        return new Student("张天爱",25);
    }
}
