package cn.cnaworld.base.infrastructure.bus;


//事件总线
public interface DomianEventBus {

    void  post(DomainEvent event);

}
