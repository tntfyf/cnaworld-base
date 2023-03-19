package cn.cnaworld.base.infrastructure.component.exceptionhandler;

import cn.cnaworld.framework.infrastructure.common.statics.constants.HttpCodeConstant;
import cn.cnaworld.framework.infrastructure.exception.BusinessException;
import cn.cnaworld.framework.infrastructure.utils.CnaLogUtil;
import cn.cnaworld.framework.infrastructure.utils.http.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.bind.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 自定义异常处理器
 * @author Lucifer
 * @date 2023/3/10
 * @since 1.0.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * ValidationException
     */
    @ExceptionHandler({ValidationException.class, BindException.class,MethodArgumentNotValidException.class})
    public ResponseResult<String> handleValidationException(Exception e) {
    	String errorMessage = extractedErrorMessage(e);
		CnaLogUtil.error(log,errorMessage,e);
    	return ResponseResult.error(HttpCodeConstant.PRECONDITION_REQUIRED,errorMessage);
    }

	/**
	 * 业务异常
	 */
	@ExceptionHandler(BusinessException.class)
	public ResponseResult<String> handleBusinessException(BusinessException e) {
		CnaLogUtil.error(log,e.getMessage(),e);
		return ResponseResult.error(HttpCodeConstant.BUSINESS_ERROR,e.getMessage());
	}

	/**
	 * 断言校验异常
	 */
	@ExceptionHandler({IllegalStateException.class,IllegalArgumentException.class})
	public ResponseResult<String> handleSpringAssertException(Exception e) {
		CnaLogUtil.error(log,e.getMessage(),e);
		return ResponseResult.error(HttpCodeConstant.ASSERT_ERROR,e.getMessage());
	}

	@ExceptionHandler({Exception.class,RuntimeException.class})
	public ResponseResult<String> handleException(Exception e) {
		CnaLogUtil.error(log,"系统异常请联系管理员,错误信息："+e.getMessage(),e);
		return ResponseResult.error(HttpCodeConstant.ERROR,"系统异常请联系管理员,错误信息："+e.getMessage());
	}
	private static final Pattern DEFAULT_MESSAGE_PATTERN  = Pattern.compile("default message \\[(.*?)\\]");

	private String extractedErrorMessage(Exception e) {
		String errorMessage = e.getMessage();
		Matcher matcher = DEFAULT_MESSAGE_PATTERN.matcher(errorMessage);
		int i=1;
		Map<String,String> errorMsgMap=new HashMap<String,String>();
		String a="";
		while (matcher.find()){
			if(i%2==0) {
				errorMsgMap.put(a,matcher.group(1));
			}else {
				a=matcher.group(1);
			}
			i++;
		}
		
		errorMessage=errorMsgMap.toString();
		if(StringUtils.isNotBlank(errorMessage) && !"{}".equals(errorMessage)) {
			errorMessage=errorMessage.substring(1,errorMessage.length()-1);
			errorMessage=errorMessage.replace("=", ":");
		}else {
			errorMessage=e.getMessage();
		}
		return errorMessage;
	}
}
