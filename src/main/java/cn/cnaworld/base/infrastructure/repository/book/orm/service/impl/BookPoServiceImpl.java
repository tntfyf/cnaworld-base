package cn.cnaworld.base.infrastructure.repository.book.orm.service.impl;

import cn.cnaworld.base.infrastructure.repository.book.orm.po.BookPo;
import cn.cnaworld.base.infrastructure.repository.book.orm.mapper.BookPoMapper;
import cn.cnaworld.base.infrastructure.repository.book.orm.service.IBookPoService;
import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.service.impl.CnaWorldBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lucifer
 * @since 2023-08-22
 */
@Service
public class BookPoServiceImpl extends CnaWorldBaseServiceImpl<BookPoMapper, BookPo> implements IBookPoService {

}
