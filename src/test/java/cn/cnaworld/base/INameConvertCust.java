package cn.cnaworld.base;

import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import org.jetbrains.annotations.NotNull;

/**
 * @author Lucifer
 * @date 2023/5/25
 * @since
 */
public class INameConvertCust implements INameConvert {

    private final StrategyConfig strategyConfig;

    protected INameConvertCust(StrategyConfig strategyConfig) {
        this.strategyConfig = strategyConfig;
    }

    @NotNull
    @Override
    public String entityNameConvert(@NotNull TableInfo tableInfo){
        return new DefaultNameConvert(strategyConfig).entityNameConvert(tableInfo)+"Po";
    }

    /**
     * 执行属性名称转换
     *
     * @param field 表字段对象，如果属性表字段命名不一致注意 convert 属性的设置
     * @return
     */
    @Override
    public @NotNull String propertyNameConvert(@NotNull TableField field) {
        return new DefaultNameConvert(strategyConfig).propertyNameConvert(field);
    }

}
