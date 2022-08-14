package sky.demo5;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

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
     * @PointCut:定义和管理切入点，如果项目中有多个切入点表达式是重复的，
     *              可以复用的，可以使用@PointCut
     *     属性: value 切入点表达式
     *     位置:自定义方法上面
     *     特点:
     *          当使用@PointCut定义在一个方法的上面，此时这个方法的名称就是切入点表达式的别名
     *          在其他的通知中可以使用这个方法名称，代替切入点表达式
     */
    @Pointcut(value = "execution(* *..demo5.SomeServiceImp.dosome(..))")
    private void mpt(){

    }
    @After(value = "mpt()")
    public void myafter(){
        System.out.println("最终通知总是会执行，一般用来做清除工作");
    }
    @Before(value = "mpt()")
    public void mybefore(){
        System.out.println("时间: "+new Date());
        System.out.println("mybefore");
    }

}
