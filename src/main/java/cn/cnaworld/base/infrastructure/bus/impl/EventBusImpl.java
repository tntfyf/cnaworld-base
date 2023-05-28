package cn.cnaworld.base.infrastructure.bus.impl;

import cn.cnaworld.base.infrastructure.bus.DomainEvent;
import cn.cnaworld.base.infrastructure.bus.DomianEventBus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class EventBusImpl implements ApplicationContextAware, DomianEventBus {

//  @Autowired
//  private ApplicationEventPublisher eventBus;

    //  private AnnotationConfigApplicationContext context;
    private ConfigurableApplicationContext applicationContext;




    @PostConstruct
    private void init() {

    }

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    private static final Logger LOGGER = LoggerFactory.getLogger(EventBusImpl.class);

    @Override
    public void post(DomainEvent event) {
        applicationContext.publishEvent(event);
        try {
            String message = objectMapper.writeValueAsString(event);
        } catch (Exception e) {
            LOGGER.error("error when store event", e);
        }

    }



    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }



}