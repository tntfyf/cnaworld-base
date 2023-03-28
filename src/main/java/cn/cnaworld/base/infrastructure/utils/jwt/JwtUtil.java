package cn.cnaworld.base.infrastructure.utils.jwt;

import cn.cnaworld.base.domain.user.entity.SysUser;
import cn.cnaworld.base.infrastructure.utils.date.DatetimeFormatUtil;
import cn.cnaworld.framework.infrastructure.utils.code.CnaCodeUtil;
import cn.cnaworld.framework.infrastructure.utils.redis.CnaRedisUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Lucifer
 */
@Slf4j
public class JwtUtil  {
	
	private JwtUtil() {
		
	}
	
	/**
	 * 默认jwt存活时间时30分钟
	 */
	private static int EXPIRE_TIME=30;

	/**88888888
	 * 默认密钥
	 */
	private static String SECRET="abcdefghijklmnopqrstuvwxyz";

	/**
	 * 默认前缀
	 */
	private static String HEADER="Bearer";

	/**
	 * c
	 */
	private static final int MILLIS_MINUTE_TEN = 24  * 7 * 60 ;

	public static String createJwt(SysUser sysUser) {
		String jwtString;
		Assert.notNull(sysUser,"无效用户");
		String jId = CnaCodeUtil.getSimpleUuid();
		Date currentDateTime = DatetimeFormatUtil.currentDateTime();
		Date expireTime = DatetimeFormatUtil.dateTimeAdd(currentDateTime,Calendar.MINUTE,MILLIS_MINUTE_TEN);
		//签发者
		jwtString = JWT.create().withIssuer("cnaworld")
				//签发时间
				.withIssuedAt(currentDateTime)
				.withJWTId(jId)
				.withClaim("userAccount", sysUser.getUserAccount())
				.withClaim("userName", sysUser.getUserName())
				//过期时间
				.withExpiresAt(expireTime)
				.sign(Algorithm.HMAC256(SECRET));
		String jwtKey = "jwt:" + sysUser.getUserAccount() + ":" + jId;
		jwtString=HEADER+" "+jwtString;
		CnaRedisUtil.set(jwtKey,sysUser,EXPIRE_TIME,TimeUnit.MINUTES);
		return jwtString;
    }

	/**
	 * 获取请求 token
	 * @param request 请求头
	 * @return token String
	 */
	public static String getJwt(HttpServletRequest request) {
		String jwt = request.getHeader("Authorization");
		if (StringUtils.isNotEmpty(jwt) && jwt.startsWith(HEADER)) {
			jwt = jwt.replace(HEADER+" " , "");
		}else {
			return null;
		}
		return jwt;
	}

	/**
	 * 解析jwt获取用户信息
	 */
	public static SysUser decodedJwt(String jwt){
		DecodedJWT jwtObject=verifierJwt(jwt);
		String jId = jwtObject.getId();
		String userAd = jwtObject.getClaim("userAccount").asString();
		String jwtKey = "jwt:" + userAd + ":" + jId;
		SysUser sysUser=CnaRedisUtil.get(jwtKey);
		Assert.notNull(sysUser,"jwt过期或不存在"+jwt);
		refreshJwt(jwtObject, jwtKey, sysUser);
		return sysUser;
	}

	private static void refreshJwt(DecodedJWT jwtObject, String jwtKey, SysUser sysUser) {
		Date expiresAt = jwtObject.getExpiresAt();
		long expiresTime = sysUser.getExpireTime();
		long currentTime = System.currentTimeMillis();
		if(expiresTime-currentTime >= 0 && expiresTime-currentTime <= MILLIS_MINUTE_TEN) {
			Date expiresDate = DatetimeFormatUtil.dateTimeAdd(new Date(),Calendar.MINUTE,EXPIRE_TIME);
			if(expiresAt.getTime()-expiresDate.getTime()>=0) {
				sysUser.setExpireTime(expiresDate.getTime());
				CnaRedisUtil.set(jwtKey, sysUser, expiresDate.getTime(), TimeUnit.MINUTES);
			}
		}
	}

	/**
	 * 验证jwt
	 */
    private static DecodedJWT verifierJwt(String jwt){
    	try {
    		Algorithm algorithm = Algorithm.HMAC256(SECRET);
    		JWTVerifier verifier = JWT.require(algorithm)
    				.withIssuer("cnaworld")
    				.build();
    		return verifier.verify(jwt);
    	} catch (JWTVerificationException e){
    		log.error("jwt认证失败"+e.getMessage(),e);
    		throw new RuntimeException("JWT认证失败",e);
    	}
    }

	/**
	 * 删除jwt
	 */
	public static boolean removeJwt(String jwt) {
		DecodedJWT jwtObject=JWT.decode(jwt);
		String jId = jwtObject.getId();
		String userAccount = jwtObject.getClaim("userAccount").asString();
		String jwtKey = "jwt:" + userAccount + ":" + jId;
		return CnaRedisUtil.delete(jwtKey);
	}

//	public static AbstractLoginUser getLoginUser() {
//		if(!getLoginUser) {
//			throw new RuntimeException("jwt.getLoginUser 暂不支持");
//		}
//		AbstractLoginUser abstractLoginUser = AbstractAuthorizationInterceptor.threadLocal.get();
//		if (abstractLoginUser!=null) {
//			abstractLoginUser = RedisUtil.get(abstractLoginUser.getJwtKey());
//		}
//		return abstractLoginUser;
//	}
//
//	public static String getUserName() {
//		if(!getLoginUser) {
//			throw new RuntimeException("jwt.getLoginUser 暂不支持");
//		}
//
//		if (AbstractAuthorizationInterceptor.threadLocal.get()!=null){
//			return AbstractAuthorizationInterceptor.threadLocal.get().getUserName();
//		}else {
//			throw new RuntimeException("无法找到用户信息，可能是没有经过token认证");
//		}
//
//	}
//
//	public static String getUserAd() {
//
//		if(!getLoginUser) {
//			throw new RuntimeException("jwt.getLoginUser 暂不支持");
//		}
//
//		if (AbstractAuthorizationInterceptor.threadLocal.get()!=null){
//			return AbstractAuthorizationInterceptor.threadLocal.get().getUserAd();
//		}else {
//			throw new RuntimeException("无法找到用户信息，可能是没有经过token认证");
//		}
//
//	}
	
}
