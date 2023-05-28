package cn.cnaworld.base.infrastructure.component.bus;


/**
 * 事件总线
 * @author Lucifer
 */ 
public interface DomainEventBus {

    void  post(DomainEvent event);

}
