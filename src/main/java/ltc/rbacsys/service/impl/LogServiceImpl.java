package ltc.rbacsys.service.impl;

import ltc.rbacsys.bean.Log;
import ltc.rbacsys.bean.dto.LogWithUserName;
import ltc.rbacsys.mapper.LogMapper;
import ltc.rbacsys.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;
    @Override
    public List<LogWithUserName> displayAllLog() {
        return logMapper.selectAllLog();
    }

    @Override
    public boolean insertLog(Log log) {
        return logMapper.insertLog(log);
    }

    @Override
    public List<LogWithUserName> searchByKeyWord(String type) {
        return logMapper.selectLogByUserName(type);
    }
}
