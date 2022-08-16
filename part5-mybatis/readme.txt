把mybatis和spring集成在一起，像一个框架一样使用
使用的技术是:ioc
    为什么ioc能把mybatis集成在一起像一个框架一样使用？
        是因为ioc能创建对象，可以把mybatis中的对象交给spring统一创建
        开发人员从spring中获取对象，开发人员不用同时面对多个框架了，就面对spring框架
        降低了开发难度

mybatis使用步骤:
    1.定义dao接口，StudentDao
    2.定义mapper文件，StudentDao.xml
    3.定义mybatis的主配置文件  mybatis.xml
    4.创建dao的代理对象 StudentDao dao = SqlSession.getMapper(StudentDao.class);
    List<Student> students = dao.selectstudents();

    要使用dao对象需要使用getMapper()方法
    使用getMapper方法的条件
        1.获取SqlSession对象 需要使用SqlSessionFactory的openSession方法
        2.创建SqlSessionFactory对象，通过读取mybatis的主配置文件就能创建SqlSessionFactory对象

        需要SqlSessionFactory，使用Factory就能获取SqlSession,有SqlSession就有dao，
        目的就是获取dao对象   Factory创建需要读取主配置文件
    主配置文件:
        1.数据库信息
            使用独立创建的连接池替代mybatis自带的连接池，把连接池类也交给spring创建
        2.mapper文件的位置
    综上我们需要spring创建以下对象:
            1.独立的连接池对象，使用阿里的druid连接池
            2.SqlSessionfactory对象
            3.创建dao对象

