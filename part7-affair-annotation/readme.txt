1.什么是事务？
    事务是一组sql语句的集合，集合中有多条sql语句
    可能是insert ，update，select，delete，我们希望这些sql语句都能成功，
    或者失败这些sql语句执行结果是一致的，作为一个整体执行
2.什么时候需要用事务
    当我的操作涉及到多个表，或者是多个SQL语句，需要保证这些语句都能成功才能完成
    我的功能，或者都失败，保证操作符合要求，例如转账

    在Java程序中，控制事务，此时事务应该放在哪里？
            service类的业务方法中。因为业务方法可能涉及多个dao方法，执行多个sql语句
3.通常使用jdbc访问数据库，还是mybatis访问数据库，怎么处理事务？
    jdbc访问数据库，处理事务: Connection con; con.commit();con.rollback();
    mybatis访问数据库:SqlSession.commit();SqlSession.rollback();
4.问题3中事务处理方式有什么不足？
    1）不同的数据库访问技术，处理事务的对象，方法不同；
      需要了解不同数据库访问技术使用事务的原理
    2）掌握多种数据库中的事务处理逻辑。
        什么时候提交事务，什么时候回滚事务
        处理事务的多种方法

      总结:多种数据库的访问技术，有不同的事务处理机制，对象，方法
5.怎么解决不足？
    spring提供一种处理事务的统一模型，能使用统一的步骤方式，来完成
    多种不同的数据库的访问技术的事务处理，
    使用spring的事务处理机制，可以完成mybatis访问数据库的事务处理
    使用spring的事务处理机制，可以完成hibernate访问数据库的事务处理
    ......
6.处理事务需要怎么做，做什么
    spring处理事务的模型使用步骤是固定的，把事务使用的信息提供给spring就可以了
    1）事务内部提交，回滚事务，使用的事务管理器对象，代替你完成commit，rollback
        事务管理器是一个接口和众多实现类
        接口:PlatformTransactionManager，定义了事务的重要方法
            commit，rollback
        实现类spring把每一种数据库访问技术对应的事务处理类都创建好了

        怎么使用:你需要告诉spring你用的是那种数据库访问技术，怎么告诉spring呢?
                声明数据库访问技术对应的事务管理器实现类，在spring配置文件中使用<bean>声明
                例如:要使用mybatis访问数据库，你应该在配置文件中
                <bean id="xxx" class="....DataSourceTransactionManager">
    2)你的业务方法需要什么样的事务?说明需要事务的类型。
        说明方法需用的事务
            1) 事务的隔离级别(常量):
                READ UNCOMMITTED:读未提交。未解决任何并发问题。
                READ_COMMITTED:读已提交。解决脏读，存在不可重复读与幻读，Oracle默认级别。
                REPEATABLE_READ:可重复读。解决脏读、不可重复读，存在幻读，mysql默认级别。
                SERIALIZABLE:串行化。不存在并发问题。
            2)事务的超时时间: 表示一个方法最长的执行时间，如果方法执行时，
                           超过了这个时间，事务就回滚，单位是秒，整数值，默认是-1
            3)事务的传播行为（*）：用来控制业务方法是不是有事务，是什么事务?
                7个传播行为，表示你的业务方法调用时，事务在方法之间是如何使用的
                    PROPAGATION_REQUIRED
                    PROPAGATION_REQUIRES_NEW
                    PROPAGATION_SUPPORTS
            4)提交事务，回滚事务的时机
                当业务方法执行成功，没有异常抛出，当方法执行完毕，spring在方法执行后提交事务。
                当业务方法抛出运行时异常，spring执行回滚，调用事务管理器的rollback
                当业务方法抛出非运行时异常，主要是受查异常，提交事务
                受查异常:写代码时必须处理的异常

    总结spring事务:
        1.管理事务的是事务管理器和他的实现类
        2.spring的事务是一个统一模型
            1）指定要使用的事务管理器实现类，使用<bean>
            2）指定那些类哪些方法需要加入事务功能
            3）指定事务需要的隔离级别，传播行为，超时
    spring中提供的事务处理方案:
        1.适合中小项目使用，注解方案
            spring框架自己用aop实现给业务方法增加事务的功能，。使用@Transactional注解增加事务
            放在public方法上面，表示当前方法具有事务，可以给注解的属性赋值表示具体的隔离级别
            传播行为，异常信息等

            使用@Transactional注解的步骤:
                1）声明事务管理器对象
                    <bean id="xx" class="DataSourceTransactionManager">
                2）开启事务的注解驱动，告诉spring框架，我要使用注解的方式去管理事务。
                    然后spring就会通过aop的机制，创建@Transactional所在的类代理对象，给方法加入事务的功能
                    spring给业务方法加入事务:
                        在业务方法执行前，开启事务，执行后提交或者回滚事务使用的是aop的环绕通知
                        @Around("你要增加事务功能的业务方法的名称")
                        Object myAround(){
                            开启事务，spring开启
                            try{
                                buy();
                                spring的事务管理器.commit（）;
                            }catch(Exception e){
                                spring的事务管理器.rollback（）;
                            }
                        }

                3)在方法上面加@Transactional注解
                part7-affair - annotation