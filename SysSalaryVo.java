package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 工资发放记录对象 sys_salary
 *
 * @author Mredust
 * @date 2025-05-27
 */
public class SysSalaryVo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /**
     * id
     */
    private Long id;
    
    
    private Long userId;
    
    /**
     * 发放日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发放日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payDate;
    
    /**
     * 发放总金额
     */
    @Excel(name = "发放总金额")
    private BigDecimal total;
    
    /**
     * 状态（1已发放 0待发放）
     */
    @Excel(name = "状态", readConverterExp = "1=已发放,0=待发放")
    private Integer status;
    /**
     * 用户昵称
     */
    @Excel(name = "用户名称")
    private String nickName;
    
    /**
     * 用户邮箱
     */
    @Excel(name = "用户邮箱")
    private String email;
    private String remark;
    
    /**
     * 手机号码
     */
    @Excel(name = "手机号码", cellType = Excel.ColumnType.TEXT)
    private String phonenumber;
    
    /**
     * 用户性别
     */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;
    
    @Excel(name = "部门名称")
    private String deptName;
    
    @Override
    public String getRemark() {
        return remark;
    }
    
    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Date getPayDate() {
        return payDate;
    }
    
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
    
    public BigDecimal getTotal() {
        return total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhonenumber() {
        return phonenumber;
    }
    
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getDeptName() {
        return deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    
    @Override
    public String toString() {
        return "SysSalaryVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", payDate=" + payDate +
                ", total=" + total +
                ", status=" + status +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", sex='" + sex + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
