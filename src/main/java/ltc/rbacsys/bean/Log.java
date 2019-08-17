package ltc.rbacsys.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Log {
    private Integer logId;
    private Integer userId;
    private String operationType;
    private Double costTime;
    private Boolean isSuccess;
    private Date operateTime;
}
