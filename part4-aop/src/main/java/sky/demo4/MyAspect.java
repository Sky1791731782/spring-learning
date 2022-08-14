package sky.demo4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

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
     * 最终通知定义方法，方法是实现切面功能的
     * 方法定义的要求:
     * 1.公共方法，public
     * 2.没有返回值
     * 3.方法名称自定义
     * 4.没有参数，如果有应该是JoinPoint
     */

    /**
     * @author yqb
     * @After 最终通知
     *      属性:value 切入点表达式
     *      位置:在方法上面
     *  特点:
     *      1.总是会执行,有异常也会执行，相当于finally
     *      2.在方法后执行
     */
    @After(value = "execution(* *..demo4.SomeServiceImp.dosome(..))")
    public void myafter(){
        System.out.println("最终通知总是会执行，一般用来做清除工作");
    }


}
