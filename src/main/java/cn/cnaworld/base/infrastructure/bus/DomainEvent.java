package cn.cnaworld.base.infrastructure.bus;

import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class DomainEvent extends ApplicationEvent {

    private String eventId;

    private LocalDateTime occurTime;


    public DomainEvent(Object source) {
        super(source);
        eventId = UUID.randomUUID().toString();
        occurTime = LocalDateTime.now();
    }

    public LocalDateTime getOccurTime() {
        return occurTime;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setOccurTime(LocalDateTime occurTime) {
        this.occurTime = occurTime;
    }
}
