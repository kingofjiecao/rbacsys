package ltc.rbacsys.mapper;

import ltc.rbacsys.bean.Log;
import ltc.rbacsys.bean.dto.LogWithUserName;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogMapper {
    List<LogWithUserName> selectAllLog();
    boolean insertLog(Log log);
    List<LogWithUserName> selectLogByUserName(String type);
}
