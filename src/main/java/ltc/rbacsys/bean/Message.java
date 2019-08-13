package ltc.rbacsys.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    private Integer cid;
    private String title;
    private String content;
    private Date createTime;
    private Date updateTime;
    private Integer userId;
}
