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
@Table(name = "t_result_commit")
public class ResultCommit {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 比例尺
     */
    @Column(name = "plotting_scale")
    private String plottingScale;

    /**
     * 新图号
     */
    @Column(name = "new_figure")
    private String newFigure;

    /**
     * 旧图号
     */
    @Column(name = "old_figure")
    private String oldFigure;

    /**
     * 图名
     */
    private String figure;

    /**
     * 介质类型
     */
    @Column(name = "medium_type")
    private String mediumType;

    /**
     * 成果日期
     */
    @Column(name = "result_date")
    private Date resultDate;

    /**
     * 数据格式
     */
    @Column(name = "data_format")
    private String dataFormat;

    /**
     * 成果名称
     */
    private String name;

    /**
     * 生产日期
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 高程基准
     */
    @Column(name = "height_datum")
    private Integer heightDatum;

    /**
     * 备注说明
     */
    private String memo;

    /**
     * 关联项目编号
     */
    @Column(name = "ref_id")
    private Long refId;

    /**
     * 中央子午线
     */
    private String meridian;

    /**
     * 坐标系
     */
    private String coordinate;

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
     * 获取比例尺
     *
     * @return plotting_scale - 比例尺
     */
    public String getPlottingScale() {
        return plottingScale;
    }

    /**
     * 设置比例尺
     *
     * @param plottingScale 比例尺
     */
    public void setPlottingScale(String plottingScale) {
        this.plottingScale = plottingScale == null ? null : plottingScale.trim();
    }

    /**
     * 获取新图号
     *
     * @return new_figure - 新图号
     */
    public String getNewFigure() {
        return newFigure;
    }

    /**
     * 设置新图号
     *
     * @param newFigure 新图号
     */
    public void setNewFigure(String newFigure) {
        this.newFigure = newFigure == null ? null : newFigure.trim();
    }

    /**
     * 获取旧图号
     *
     * @return old_figure - 旧图号
     */
    public String getOldFigure() {
        return oldFigure;
    }

    /**
     * 设置旧图号
     *
     * @param oldFigure 旧图号
     */
    public void setOldFigure(String oldFigure) {
        this.oldFigure = oldFigure == null ? null : oldFigure.trim();
    }

    /**
     * 获取图名
     *
     * @return figure - 图名
     */
    public String getFigure() {
        return figure;
    }

    /**
     * 设置图名
     *
     * @param figure 图名
     */
    public void setFigure(String figure) {
        this.figure = figure == null ? null : figure.trim();
    }

    /**
     * 获取介质类型
     *
     * @return medium_type - 介质类型
     */
    public String getMediumType() {
        return mediumType;
    }

    /**
     * 设置介质类型
     *
     * @param mediumType 介质类型
     */
    public void setMediumType(String mediumType) {
        this.mediumType = mediumType == null ? null : mediumType.trim();
    }

    /**
     * 获取成果日期
     *
     * @return result_date - 成果日期
     */
    public Date getResultDate() {
        return resultDate;
    }

    /**
     * 设置成果日期
     *
     * @param resultDate 成果日期
     */
    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    /**
     * 获取数据格式
     *
     * @return data_format - 数据格式
     */
    public String getDataFormat() {
        return dataFormat;
    }

    /**
     * 设置数据格式
     *
     * @param dataFormat 数据格式
     */
    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat == null ? null : dataFormat.trim();
    }

    /**
     * 获取成果名称
     *
     * @return name - 成果名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置成果名称
     *
     * @param name 成果名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取生产日期
     *
     * @return create_date - 生产日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置生产日期
     *
     * @param createDate 生产日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取高程基准
     *
     * @return height_datum - 高程基准
     */
    public Integer getHeightDatum() {
        return heightDatum;
    }

    /**
     * 设置高程基准
     *
     * @param heightDatum 高程基准
     */
    public void setHeightDatum(Integer heightDatum) {
        this.heightDatum = heightDatum;
    }

    /**
     * 获取备注说明
     *
     * @return memo - 备注说明
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注说明
     *
     * @param memo 备注说明
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取关联项目编号
     *
     * @return ref_id - 关联项目编号
     */
    public Long getRefId() {
        return refId;
    }

    /**
     * 设置关联项目编号
     *
     * @param refId 关联项目编号
     */
    public void setRefId(Long refId) {
        this.refId = refId;
    }

    /**
     * 获取中央子午线
     *
     * @return meridian - 中央子午线
     */
    public String getMeridian() {
        return meridian;
    }

    /**
     * 设置中央子午线
     *
     * @param meridian 中央子午线
     */
    public void setMeridian(String meridian) {
        this.meridian = meridian == null ? null : meridian.trim();
    }

    /**
     * 获取坐标系
     *
     * @return coordinate - 坐标系
     */
    public String getCoordinate() {
        return coordinate;
    }

    /**
     * 设置坐标系
     *
     * @param coordinate 坐标系
     */
    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate == null ? null : coordinate.trim();
    }
}