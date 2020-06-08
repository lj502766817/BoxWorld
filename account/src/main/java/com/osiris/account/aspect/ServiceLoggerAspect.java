package com.osiris.account.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 服务日志切面
 *
 * @author : 李佳
 */
@Component
@Aspect
public class ServiceLoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLoggerAspect.class);

    private static final String POINT_CUT_1 = "execution(public * com.osiris.account.service.Impl..*.*(..))";

    @Pointcut(POINT_CUT_1)
    public void pointCut1(){}

    @Before(value = "pointCut1()")
    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("【前置通知】the method 【" + methodName + "】 execution with " + Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "pointCut1()" , returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("【返回通知】the method 【" + methodName + "】 ends with 【" + result + "】");
    }


}
