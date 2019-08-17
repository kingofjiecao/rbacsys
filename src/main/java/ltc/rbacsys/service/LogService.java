package ltc.rbacsys.service;

import ltc.rbacsys.bean.Log;
import ltc.rbacsys.bean.dto.LogWithUserName;

import java.util.List;

public interface LogService {
    List<LogWithUserName> displayAllLog();
    boolean insertLog(Log log);
    List<LogWithUserName> searchByKeyWord(String type);
}
