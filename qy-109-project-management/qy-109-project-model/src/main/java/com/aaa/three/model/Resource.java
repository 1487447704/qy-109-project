package com.aaa.three.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "t_resource")
public class Resource {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源大小
     */
    private Long size;

    /**
     * 资源路径
     */
    private String path;

    /**
     * 资源文件类型
     */
    private String type;

    /**
     * 资源后缀名
     */
    @Column(name = "ext_name")
    private String extName;

    /**
     * 文件业务类型
     */
    @Column(name = "ref_biz_type")
    private String refBizType;

    /**
     * 文件关联编号
     */
    @Column(name = "ref_biz_id")
    private Long refBizId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 备注
     */
    private String memo;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取资源名称
     *
     * @return name - 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源名称
     *
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取资源大小
     *
     * @return size - 资源大小
     */
    public Long getSize() {
        return size;
    }

    /**
     * 设置资源大小
     *
     * @param size 资源大小
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * 获取资源路径
     *
     * @return path - 资源路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置资源路径
     *
     * @param path 资源路径
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 获取资源文件类型
     *
     * @return type - 资源文件类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置资源文件类型
     *
     * @param type 资源文件类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取资源后缀名
     *
     * @return ext_name - 资源后缀名
     */
    public String getExtName() {
        return extName;
    }

    /**
     * 设置资源后缀名
     *
     * @param extName 资源后缀名
     */
    public void setExtName(String extName) {
        this.extName = extName == null ? null : extName.trim();
    }

    /**
     * 获取文件业务类型
     *
     * @return ref_biz_type - 文件业务类型
     */
    public String getRefBizType() {
        return refBizType;
    }

    /**
     * 设置文件业务类型
     *
     * @param refBizType 文件业务类型
     */
    public void setRefBizType(String refBizType) {
        this.refBizType = refBizType == null ? null : refBizType.trim();
    }

    /**
     * 获取文件关联编号
     *
     * @return ref_biz_id - 文件关联编号
     */
    public Long getRefBizId() {
        return refBizId;
    }

    /**
     * 设置文件关联编号
     *
     * @param refBizId 文件关联编号
     */
    public void setRefBizId(Long refBizId) {
        this.refBizId = refBizId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}