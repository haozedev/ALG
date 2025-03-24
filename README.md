# ALG
算法学习


1.书写简易Spring源码，理清楚


BeanFactory:
    生产bean，提供获取bean的方法 getBean方法
    生产bean的话，是不是得解析我们的注解@Service，一个bean可能是单例的，也可能是多例的

BeanDefinition bean定义。String scope(单例singleton，多例prototype)
class clazz(object.class)代表当前bean属于哪个class 他就是生产bean的原料

ApplicationContext:容器(上下文)。他要主导 BeanDefinition的生成，把 BeanDefinition”传递”
(注册，beanDefinition注册,beanDefinitionRegister(方法:registerBeanDefinition))
给 BeanFactory 生成bean。getBean方法不是Applicationcontext里边的方法吗?
是的，这个getbean方法如果你倒一倒源码的话，你会发现，他是最终调用的 BeanFactory 的getBean
