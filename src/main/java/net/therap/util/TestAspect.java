package net.therap.util;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 6/5/14
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TestAspect {

    final static Logger logger = LoggerFactory.getLogger(TestAspect.class);

    long start,end,totalTime;
    @Before("execution (* net.therap.service.*.*(..))")
    public void setStart(JoinPoint joinPoint) {
        start = System.currentTimeMillis();
    }

    @After("execution (* net.therap.service.*.*(..))")
    public void setEnd(JoinPoint joinPoint) {
        end = System.currentTimeMillis();
        System.out.println("method name: "+joinPoint.getSignature().getName());
        totalTime = end - start;
        System.out.println("execution time: "+totalTime+" ms");
        logger.info("execution time: "+totalTime+" ms");
    }
}
