package sky.demo5;

public class SomeServiceImp implements SomeService {
    @Override
    //增加功能
    public void dosome(String s) {
        System.out.println("dosome方法调用");
    }

    @Override
    public int doother(String y) {
        System.out.println("dother方法调用");
        return 1;
    }
}
