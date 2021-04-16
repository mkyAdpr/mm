package mm.base.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String name) throws ClassNotFoundException {
        return (T)applicationContext.getBean(name);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> type){
        return (T)applicationContext.getBean(type);
    }

}
