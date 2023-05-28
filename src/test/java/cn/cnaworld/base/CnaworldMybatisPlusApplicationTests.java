//package cn.cnaworld.base;
//
//import cn.cnaworld.base.domain.student.entity.Student;
//import cn.cnaworld.base.domain.student.service.IStudentService;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@SpringBootTest
//class CnaworldMybatisPlusApplicationTests {
//
//    @Autowired
//    private IStudentService iStudentService;
//
//    @Test
//    void getOne() {
//        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("student_name","张三");
//        queryWrapper.eq("teacher_id","0");
//        Student student = iStudentService.getOne(queryWrapper);
//        System.out.println("初始化查询："+student);
//        //删除ID为1的数据
//        iStudentService.remove(queryWrapper);
//        student = iStudentService.getOne(queryWrapper);
//        System.out.println("逻辑删除后查询："+student);
//        iStudentService.restore(queryWrapper);
//        student = iStudentService.getOne(queryWrapper);
//        System.out.println("逻辑恢复后查询："+student);
//    }
//
//    @Test
//    void byId() {
//        Student student = iStudentService.getById(1);
//        System.out.println("初始化查询："+student);
//        iStudentService.removeById(1);
//        student = iStudentService.getById(1);
//        System.out.println("逻辑删除后查询："+student);
//        iStudentService.restoreById(1);
//        student = iStudentService.getById(1);
//        System.out.println("逻辑恢复1后查询："+student);
//    }
//
//    @Test
//    void byIds() {
//        List<Student> student = iStudentService.list();
//        List<Student> student1= student;
//        System.out.println("初始化查询："+student);
//        iStudentService.removeByIds(student);
//        student = iStudentService.list();
//        System.out.println("逻辑删除后查询："+student);
//        iStudentService.restoreByIds(student1);
//        student = iStudentService.list();
//        System.out.println("逻辑恢复后查询："+student);
//    }
//
//    @Test
//    void byMap() {
//        Map<String, Object> columnMap = new HashMap<>();
//        columnMap.put("student_name","张三");
//        columnMap.put("teacher_id","0");
//        List<Student> student = iStudentService.listByMap(columnMap);
//        System.out.println("初始化查询："+student);
//        iStudentService.removeByMap(columnMap);
//        student = iStudentService.listByMap(columnMap);
//        System.out.println("逻辑删除后查询："+student);
//        iStudentService.restoreByMap(columnMap);
//        student = iStudentService.listByMap(columnMap);
//        System.out.println("逻辑恢复后查询："+student);
//    }
//
//    @Test
//    void directRemove() {
//        Student student =new Student();
//        student.setStudentName("directRemove");
//        student.setTeacherId(0L);
//        student.setDeletedDb(false);
//        iStudentService.save(student);
//
//        Student byId = iStudentService.getById(student);
//        System.out.println("初始化查询："+byId);
//        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("student_name","directRemove");
//        iStudentService.directRemove(queryWrapper);
//        byId = iStudentService.getById(student);
//        System.out.println("直接删除后查询："+byId);
//
//        student =new Student();
//        student.setStudentName("directRemove");
//        student.setTeacherId(0L);
//        student.setDeletedDb(false);
//        iStudentService.save(student);
//        byId = iStudentService.getById(student);
//        System.out.println("初始化查询："+byId);
//        iStudentService.directRemoveById(byId);
//        byId = iStudentService.getById(byId);
//        System.out.println("直接删除后查询："+byId);
//
//        student =new Student();
//        student.setStudentName("directRemove");
//        student.setTeacherId(0L);
//        student.setDeletedDb(false);
//        iStudentService.save(student);
//        student.setStudentId(null);
//        iStudentService.save(student);
//
//        queryWrapper.clear();
//        queryWrapper.eq("student_name","directRemove");
//        List<Student> list = iStudentService.list(queryWrapper);
//        System.out.println("初始化查询："+list);
//        iStudentService.directRemoveByIds(list);
//        list = iStudentService.list(queryWrapper);
//        System.out.println("直接删除后查询："+list);
//
//        student =new Student();
//        student.setStudentName("directRemove");
//        student.setTeacherId(0L);
//        student.setDeletedDb(false);
//        iStudentService.save(student);
//        byId = iStudentService.getById(student);
//        System.out.println("初始化查询："+byId);
//        Map<String, Object> columnMap = new HashMap<>();
//        columnMap.put("student_name","directRemove");
//        iStudentService.directRemoveByMap(columnMap);
//        byId = iStudentService.getById(byId);
//        System.out.println("直接删除后查询："+byId);
//    }
//
//    @Test
//    void version(){
//        Student student = iStudentService.getById(1);
//        student.setCreateByDb("xxx");
//        System.out.println("初始化查询："+student.getUpdateTimeDb());
//        iStudentService.updateById(student);
//        iStudentService.removeById(1);
//        student = iStudentService.getById(1);
//        System.out.println("逻辑删除后查询："+student);
//        iStudentService.restoreById(1);
//        student = iStudentService.getById(1);
//        System.out.println("逻辑恢复1后查询："+student.getUpdateTimeDb());
//    }
//
//    @Test
//    void update(){
//
//         //et / ew 没值的时候 我加个默认的set就行
//        Student byId = iStudentService.getById(1);
////        iStudentService.updateById(byId); //底层默认提供了乐观锁实现 但是得给MP_OPTLOCK_VERSION_ORIGINAL参数赋值
//        LocalDateTime updateTimeDb = byId.getUpdateTimeDb();
//        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.eq("student_id",1);
//        updateWrapper.eq("update_time_db",updateTimeDb);
//        iStudentService.update(byId,updateWrapper); //底层默认没提供乐观锁的实现，需要插件扩展
//
//    }
//
//}
