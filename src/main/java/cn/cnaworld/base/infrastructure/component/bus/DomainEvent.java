package cn.cnaworld.base.infrastructure.component.bus;

import cn.cnaworld.framework.infrastructure.utils.code.CnaCodeUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Lucifer
 */
@Getter
@Setter
@ToString
public class DomainEvent extends ApplicationEvent {

    private String eventId;

    private LocalDateTime occurTime;

    public DomainEvent(Object source) {
        super(source);
        eventId = CnaCodeUtil.getSnowflakeIdString();
        occurTime = LocalDateTime.now();
    }

}
