package cn.cnaworld.base.infrastructure.component.bus.impl;

import cn.cnaworld.base.infrastructure.component.bus.DomainEvent;
import cn.cnaworld.base.infrastructure.component.bus.DomainEventBus;
import cn.cnaworld.framework.infrastructure.utils.log.CnaLogUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;


/**
 * @author Lucifer
 */
@Slf4j
public class EventBusImpl implements ApplicationContextAware, DomainEventBus {

    private ConfigurableApplicationContext applicationContext;

    @PostConstruct
    private void init() {

    }

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);


    @Override
    public void post(DomainEvent event) {
        applicationContext.publishEvent(event);
        try {
            String message = objectMapper.writeValueAsString(event);
        } catch (Exception e) {
            CnaLogUtil.error(log,"error when store event", e);
        }

    }

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }



}