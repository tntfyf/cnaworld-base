//package cn.cnaworld.base;
//
//import cn.cnaworld.base.domain.student.model.dto.StudentWithTeacherlistDto;
//import cn.cnaworld.framework.infrastructure.common.statics.enums.RestFulBaseType;
//import cn.cnaworld.framework.infrastructure.common.statics.enums.RestFulEntityType;
//import cn.cnaworld.framework.infrastructure.utils.http.netty.CnaNettyHttpClientUtil;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@SpringBootTest
//class CnaworldNettyClientApplicationTests {
//
//    @Test
//    void nettyClient() {
//        Map<String,Object> paramsMap = new HashMap<>();
//        Map<String,String> headerMap = new HashMap<>();
//        StudentWithTeacherlistDto studentWithTeacherlistDto = new StudentWithTeacherlistDto();
//        studentWithTeacherlistDto.setStudentId(0L);
//        studentWithTeacherlistDto.setStudentName("张三");
//        studentWithTeacherlistDto.setTeacherId(0L);
//        //可发送GET、DELETE请求默认为GET
//        String result = CnaNettyHttpClientUtil.send("http://127.0.0.1:8080/student/list");
//        //全参发送方式
//        result = CnaNettyHttpClientUtil.send("http://127.0.0.1:8080/student/list",paramsMap,headerMap,RestFulBaseType.GET);
//        //可发送POST、PUT、PATCH请求默认为POST
//        result = CnaNettyHttpClientUtil.sendEntity("http://127.0.0.1:8080/student/StudentAndTeacherlist",studentWithTeacherlistDto);
//        //全参发送方式
//        result = CnaNettyHttpClientUtil.sendEntity("http://127.0.0.1:8080/student/StudentAndTeacherlist",studentWithTeacherlistDto,paramsMap,headerMap,RestFulEntityType.POST);
//    }
//
//}
