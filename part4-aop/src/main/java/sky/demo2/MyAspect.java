package sky.demo2;

import org.aspectj.lang.annotation.AfterReturning;
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
     * 后置通知方法定义的要求:
     * 1.公共方法，public
     * 2.方法没有返回值
     * 3.方法名称自定义
     * 4.方法有参数
     */

    /**
     * @author yqb
     * @Before:后置通知注解
     * 1.属性value，是切入点表达式，表示切面的功能执行位置
     * 2.returning 自定义的变量，表示目标方法的返回值，必须和通知方法的形参名一样
     * 位置，方法定义上面
     * 特点:
     *      1.在目标法之后执行
     *      2.能获取目标方法的返回值，可以根据返回值做不同的处理功能
     *      3.可以修改返回值
     */
//    @Before(value = "execution(* *..demo2.SomeServiceImp.do*(..))")
    public void myTime(){
        //切面功能代码
        System.out.println("前置通知，切面功能: 目标方法之前执行时间是："+new Date());
    }
    @AfterReturning(value = "execution(* *..demo2.SomeServiceImp.doother())"
            ,returning = "o")
    public void myafter(Object o){
        Student student = (Student) o;
        if(student.getAge()==25)
            System.out.println("张天爱");
        System.out.println("事务提交~~");
    }

}
