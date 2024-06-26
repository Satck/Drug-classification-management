package com.nfu.drug.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
public class OutOrInInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 药品名称
     */
    private String dname;

    /**
     * 出库？入库？类型
     */
    private String type;

    /**
     * 出库数量
     */
    private Integer count;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date createTime;

    /**
     * 进货批号
     */
    @TableField("drugInNum")
    private String druginnum;


}
