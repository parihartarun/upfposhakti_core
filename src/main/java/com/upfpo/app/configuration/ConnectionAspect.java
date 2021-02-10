package com.upfpo.app.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Aspect //means that this is an Aspect,which means it can intercept the method calling process.
@Configuration
public class ConnectionAspect {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DataSource ds;

    @Before("execution(* com.upfpo.app.repository.*.*(..))")
    public void logBeforeConnection(JoinPoint jp) throws Throwable {
        logDataSourceInfos("Before", jp);
    }

    @After("execution(* com.upfpo.app.repository.*.*(..)) ")
    public void logAfterConnection(JoinPoint jp) throws Throwable {
        logDataSourceInfos("After", jp);
    }

    public void logDataSourceInfos(final String time, final JoinPoint jp) {
        String methodName = "";
        methodName += jp.getTarget().getClass().getName();
        methodName += ":";
        methodName += jp.getSignature().getName();

       if(ds instanceof com.zaxxer.hikari.HikariDataSource) {

            com.zaxxer.hikari.HikariDataSource hikariDs = (com.zaxxer.hikari.HikariDataSource)ds;
            logger.info(methodName);
            logger.info("other props: {}",hikariDs.getDataSourceProperties());
        }
    }
}
