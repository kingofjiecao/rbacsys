package ltc.rbacsys.util;

import ltc.rbacsys.annotation.Log;
import ltc.rbacsys.bean.User;
import ltc.rbacsys.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogUtils {
    @Autowired
    HttpSession session;
    @Autowired
    LogService logService;
    @Autowired
    HttpServletRequest req;

    @Pointcut("@annotation(ltc.rbacsys.annotation.Log)")
    public void pointcut() {

    }
    @Around("execution(* ltc.rbacsys.controller.LoginController.login(..))")
    public Object login(ProceedingJoinPoint pjp) {
        ltc.rbacsys.bean.Log log = new ltc.rbacsys.bean.Log();
        long startTime;
        long endTime;
        Object result;
        startTime = System.currentTimeMillis();
        try {
            result = pjp.proceed();
            log.setIsSuccess(true);
        } catch (Throwable throwable) {
            log.setIsSuccess(false);
            throw new RuntimeException(throwable);
        } finally {
            User u = (User)session.getAttribute("user");
            endTime = System.currentTimeMillis();
            double costTime = ((double)endTime - (double)startTime) / 1000;
            log.setUserId(u.getUid());
            log.setOperationType("登录");
            log.setCostTime(costTime);
            log.setOperateTime(new Date());
            saveLog(log);
        }
        return result;
    }
    @Around("execution(* ltc.rbacsys.controller.LoginController.logout(..))")
    public Object logout(ProceedingJoinPoint pjp) {
        ltc.rbacsys.bean.Log log = new ltc.rbacsys.bean.Log();
        long startTime;
        long endTime;
        Object result;
        startTime = System.currentTimeMillis();
        try {
            User u = (User)session.getAttribute("user");
            log.setUserId(u.getUid());
            result = pjp.proceed();
            log.setIsSuccess(true);
        } catch (Throwable throwable) {
            log.setIsSuccess(false);
            throw new RuntimeException(throwable);
        } finally {
            endTime = System.currentTimeMillis();
            double costTime = ((double)endTime - (double)startTime) / 1000;
            log.setOperationType("下线");
            log.setCostTime(costTime);
            log.setOperateTime(new Date());
            saveLog(log);
        }
        return result;
    }
    @Around("pointcut()")
    public Object operation(ProceedingJoinPoint pjp) {
        ltc.rbacsys.bean.Log log = new ltc.rbacsys.bean.Log();
        long startTime;
        long endTime;
        Object result = null;
        startTime = System.currentTimeMillis();
        try {
            Signature signature = pjp.getSignature();
            Method method = ((MethodSignature)signature).getMethod();
            Log logAnnotation = method.getAnnotation(Log.class);
            if (logAnnotation.value() != null) {
                log.setOperationType(logAnnotation.value());
            }
            User u = (User)session.getAttribute("user");
            log.setUserId(u.getUid());
            result = pjp.proceed();
            Boolean rs = (Boolean)req.getAttribute("status");
            if (rs != null && !rs) {
                log.setIsSuccess(false);
            } else {
                log.setIsSuccess(true);
            }
        } catch (Throwable throwable) {
            log.setIsSuccess(false);
            throwable.printStackTrace();
        } finally {
            endTime = System.currentTimeMillis();
            double costTime = ((double)endTime - (double)startTime) / 1000;
            log.setCostTime(costTime);
            log.setOperateTime(new Date());
            saveLog(log);
        }
        return result;
    }
    public void saveLog(ltc.rbacsys.bean.Log log) {
        logService.insertLog(log);
    }
}
