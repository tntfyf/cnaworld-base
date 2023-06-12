package cn.cnaworld.base.infrastructure.utils;

import org.springframework.context.ApplicationContext;

/**
 * @author Lucifer
 */
public class SpringBeanUtil {

    private static ApplicationContext context;

    public static void set(ApplicationContext  applicationContext) {
        context = applicationContext;
    }

    /**
     * 通过字节码获取
     */
    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    /**
     * 通过BeanName获取
     */
    public static <T> T getBean(String beanName) {
        return (T) context.getBean(beanName);
    }

    /**
     * 通过beanName和字节码获取
     */
    public static <T> T getBean(String name, Class<T> beanClass) {
        return context.getBean(name, beanClass);
    }

}
