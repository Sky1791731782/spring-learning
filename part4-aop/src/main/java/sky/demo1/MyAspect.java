package sky.demo1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

@Aspect
/*
    @Aspect:aspectJ框架中的注解
        作用:表示当前类是切面类
        位置:类定义的上面
*/

public class MyAspect {
    /**
     * @author yqb
     * 定义方法，方法是实现切面功能的
     * 方法定义的要求:
     * 1.公共方法，public
     * 2.方法没有返回值
     * 3.方法名称自定义
     * 4.方法可以有参数也可以没有参数
     *  如果有参数，参数不是自定义的，有几个参数类型可以使用
     */

    /**
     * @author yqb
     * @Before:前置通知注解
     * 属性value，是切入点表达式，表示切面的功能执行位置
     * 位置 : 方法上面
     * 特点:
     *      1.在目标方法之前执行
     *      2.不会改变目标方法的执行结果
     *      3.不会影响目标方法执行
     */
//    @Before(value = "execution(public void sky.demo1.SomeServiceImp.dosome())")
//    @Before(value = "execution(void *..SomeServiceImp.dosome())")
//    @Before(value = "execution(* *..SomeServiceImp.dosome(..))")
    @Before(value = "execution(* do*(..))")
    public void myTime(){
        //切面功能代码
        System.out.println("前置通知，切面功能: 目标方法之前执行时间是："+new Date());
    }


}
