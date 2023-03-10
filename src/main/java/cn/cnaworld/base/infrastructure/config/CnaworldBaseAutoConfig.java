package cn.cnaworld.base.infrastructure.config;

import cn.cnaworld.base.infrastructure.config.knife4j.ConflictHandlingCfg;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 支持生效的@Configuration
 * 支持生效的Properties
 * @author Lucifer
 * @date 2023/3/11
 * @since 1.0.0
 */
@Configuration
@Import(value = {ConflictHandlingCfg.class})
public class CnaworldBaseAutoConfig {}

