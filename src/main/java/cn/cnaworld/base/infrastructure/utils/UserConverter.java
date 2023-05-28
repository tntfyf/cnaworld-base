package cn.cnaworld.base.infrastructure.utils;

import org.springframework.cglib.core.Converter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Administrator
 * @date 2023/5/28
 * @since
 */
public class UserConverter implements Converter {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 自定义属性转换
     * @param value  源对象属性类
     * @param target 目标对象里属性对应set方法名,eg.setId
     * @param context 目标对象属性类
     * @return 转换值
     */
    @Override
    public Object convert(Object value, Class target, Object context) {
        if (value instanceof Integer) {
            return value;
        } else if (value instanceof LocalDateTime) {
            LocalDateTime date = (LocalDateTime) value;
            return dtf.format(date);
        } else if (value instanceof BigDecimal) {
            BigDecimal bd = (BigDecimal) value;
            return bd.toPlainString();
        }
        return value;
    }
}
