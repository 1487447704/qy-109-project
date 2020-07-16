package com.aaa.three.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "t_mapping_project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class MappingProject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 项目类型
     */
    @Column(name = "project_type")
    private String projectType;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 项目金额（万元）
     */
    @Column(name = "project_amount")
    private Double projectAmount;

    /**
     * 项目负责人
     */
    @Column(name = "project_leader")
    private String projectLeader;

    /**
     * 开工日期
     */
    @Column(name = "start_date")
    private String startDate;

    /**
     * 完工日期
     */
    @Column(name = "end_date")
    private String endDate;

    /**
     * 完成工期
     */
    @Column(name = "complete_time")
    private String completeTime;

    /**
     * 验收机构
     */
    @Column(name = "acceptance_department")
    private String acceptanceDepartment;

    /**
     * 验收报告文号
     */
    @Column(name = "acceptance_report")
    private String acceptanceReport;

    /**
     * 任务来源
     */
    @Column(name = "task_source")
    private String taskSource;

    /**
     * 项目面积（km²）
     */
    @Column(name = "project_area")
    private Double projectArea;

    /**
     * 比例尺（开本，册）
     */
    private String scale;

    /**
     * 图幅数量（线路里程）
     */
    @Column(name = "sheet_number")
    private String sheetNumber;

    /**
     * 颁奖单位
     */
    @Column(name = "awards_department")
    private String awardsDepartment;

    /**
     * 获奖类型等级
     */
    @Column(name = "prize_level")
    private String prizeLevel;

    /**
     * 项目质量认可
     */
    @Column(name = "project_quality_approval")
    private String projectQualityApproval;

    /**
     * 获奖时间
     */
    @Column(name = "winning_time")
    private String winningTime;

    /**
     * 验收时间
     */
    @Column(name = "acceptance_time")
    private String acceptanceTime;

    /**
     * 基本内容
     */
    @Column(name = "basic_content")
    private String basicContent;

    /**
     * 履约情况
     */
    @Column(name = "credit_status")
    private String creditStatus;

    /**
     * 向测绘主管部门汇交成果情况
     */
    @Column(name = "submit_status")
    private String submitStatus;

    /**
     * 单位用户编号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 进度（百分比）
     */
    private Integer schedule;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 更改时间
     */
    @Column(name = "modify_time")
    private String modifyTime;

    /**
     * 备注
     */
    private String memo;

    /**
     * 项目进行状态 2:未完成 3:已完成
     */
    private Integer status;

    /**
     * 项目审核结果 0:通过 1:未通过 2:已提交 3:未提交
     */
    @Column(name = "audit_status")
    private Integer auditStatus;

    /**
     * 项目成果汇交状态 0:通过 1:未通过 2:已提交 3:未提交
     */
    @Column(name = "results_status")
    private Integer resultsStatus;

    /**
     * 中央子午线
     */
    private String meridian;

    /**
     * 坐标系
     */
    @Column(name = "coordinate_system")
    private String coordinateSystem;

    /**
     * 管理级别
     */
    @Column(name = "management_level")
    private String managementLevel;

    /**
     * 资金来源
     */
    @Column(name = "funding_source")
    private String fundingSource;

    /**
     * 
委托单位
     */
    @Column(name = "entrust_unit")
    private String entrustUnit;

    /**
     * 
承建单位
     */
    @Column(name = "accept_unit")
    private String acceptUnit;

    /**
     * 手机号码
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 固定
电话
     */
    private String phone;

    /**
     * 项目所在地
     */
    private String address;

    /**
     * 项目中心点
     */
    @Column(name = "center_point")
    private String centerPoint;

    /**
     * 同步状态 0：已同步 1：未同步
     */
    @Column(name = "synchronization_status")
    private Integer synchronizationStatus;

    /**
     * 合同上传时间
     */
    @Column(name = "contract_time")
    private String contractTime;

    /**
     * 坐标
     */
    private String coordinate;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取项目类型
     *
     * @return project_type - 项目类型
     */
    public String getProjectType() {
        return projectType;
    }

    /**
     * 设置项目类型
     *
     * @param projectType 项目类型
     */
    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    /**
     * 获取项目名称
     *
     * @return project_name - 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * 获取项目金额（万元）
     *
     * @return project_amount - 项目金额（万元）
     */
    public Double getProjectAmount() {
        return projectAmount;
    }

    /**
     * 设置项目金额（万元）
     *
     * @param projectAmount 项目金额（万元）
     */
    public void setProjectAmount(Double projectAmount) {
        this.projectAmount = projectAmount;
    }

    /**
     * 获取项目负责人
     *
     * @return project_leader - 项目负责人
     */
    public String getProjectLeader() {
        return projectLeader;
    }

    /**
     * 设置项目负责人
     *
     * @param projectLeader 项目负责人
     */
    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader == null ? null : projectLeader.trim();
    }

    /**
     * 获取开工日期
     *
     * @return start_date - 开工日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 设置开工日期
     *
     * @param startDate 开工日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    /**
     * 获取完工日期
     *
     * @return end_date - 完工日期
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 设置完工日期
     *
     * @param endDate 完工日期
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    /**
     * 获取完成工期
     *
     * @return complete_time - 完成工期
     */
    public String getCompleteTime() {
        return completeTime;
    }

    /**
     * 设置完成工期
     *
     * @param completeTime 完成工期
     */
    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime == null ? null : completeTime.trim();
    }

    /**
     * 获取验收机构
     *
     * @return acceptance_department - 验收机构
     */
    public String getAcceptanceDepartment() {
        return acceptanceDepartment;
    }

    /**
     * 设置验收机构
     *
     * @param acceptanceDepartment 验收机构
     */
    public void setAcceptanceDepartment(String acceptanceDepartment) {
        this.acceptanceDepartment = acceptanceDepartment == null ? null : acceptanceDepartment.trim();
    }

    /**
     * 获取验收报告文号
     *
     * @return acceptance_report - 验收报告文号
     */
    public String getAcceptanceReport() {
        return acceptanceReport;
    }

    /**
     * 设置验收报告文号
     *
     * @param acceptanceReport 验收报告文号
     */
    public void setAcceptanceReport(String acceptanceReport) {
        this.acceptanceReport = acceptanceReport == null ? null : acceptanceReport.trim();
    }

    /**
     * 获取任务来源
     *
     * @return task_source - 任务来源
     */
    public String getTaskSource() {
        return taskSource;
    }

    /**
     * 设置任务来源
     *
     * @param taskSource 任务来源
     */
    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource == null ? null : taskSource.trim();
    }

    /**
     * 获取项目面积（km²）
     *
     * @return project_area - 项目面积（km²）
     */
    public Double getProjectArea() {
        return projectArea;
    }

    /**
     * 设置项目面积（km²）
     *
     * @param projectArea 项目面积（km²）
     */
    public void setProjectArea(Double projectArea) {
        this.projectArea = projectArea;
    }

    /**
     * 获取比例尺（开本，册）
     *
     * @return scale - 比例尺（开本，册）
     */
    public String getScale() {
        return scale;
    }

    /**
     * 设置比例尺（开本，册）
     *
     * @param scale 比例尺（开本，册）
     */
    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    /**
     * 获取图幅数量（线路里程）
     *
     * @return sheet_number - 图幅数量（线路里程）
     */
    public String getSheetNumber() {
        return sheetNumber;
    }

    /**
     * 设置图幅数量（线路里程）
     *
     * @param sheetNumber 图幅数量（线路里程）
     */
    public void setSheetNumber(String sheetNumber) {
        this.sheetNumber = sheetNumber == null ? null : sheetNumber.trim();
    }

    /**
     * 获取颁奖单位
     *
     * @return awards_department - 颁奖单位
     */
    public String getAwardsDepartment() {
        return awardsDepartment;
    }

    /**
     * 设置颁奖单位
     *
     * @param awardsDepartment 颁奖单位
     */
    public void setAwardsDepartment(String awardsDepartment) {
        this.awardsDepartment = awardsDepartment == null ? null : awardsDepartment.trim();
    }

    /**
     * 获取获奖类型等级
     *
     * @return prize_level - 获奖类型等级
     */
    public String getPrizeLevel() {
        return prizeLevel;
    }

    /**
     * 设置获奖类型等级
     *
     * @param prizeLevel 获奖类型等级
     */
    public void setPrizeLevel(String prizeLevel) {
        this.prizeLevel = prizeLevel == null ? null : prizeLevel.trim();
    }

    /**
     * 获取项目质量认可
     *
     * @return project_quality_approval - 项目质量认可
     */
    public String getProjectQualityApproval() {
        return projectQualityApproval;
    }

    /**
     * 设置项目质量认可
     *
     * @param projectQualityApproval 项目质量认可
     */
    public void setProjectQualityApproval(String projectQualityApproval) {
        this.projectQualityApproval = projectQualityApproval == null ? null : projectQualityApproval.trim();
    }

    /**
     * 获取获奖时间
     *
     * @return winning_time - 获奖时间
     */
    public String getWinningTime() {
        return winningTime;
    }

    /**
     * 设置获奖时间
     *
     * @param winningTime 获奖时间
     */
    public void setWinningTime(String winningTime) {
        this.winningTime = winningTime == null ? null : winningTime.trim();
    }

    /**
     * 获取验收时间
     *
     * @return acceptance_time - 验收时间
     */
    public String getAcceptanceTime() {
        return acceptanceTime;
    }

    /**
     * 设置验收时间
     *
     * @param acceptanceTime 验收时间
     */
    public void setAcceptanceTime(String acceptanceTime) {
        this.acceptanceTime = acceptanceTime == null ? null : acceptanceTime.trim();
    }

    /**
     * 获取基本内容
     *
     * @return basic_content - 基本内容
     */
    public String getBasicContent() {
        return basicContent;
    }

    /**
     * 设置基本内容
     *
     * @param basicContent 基本内容
     */
    public void setBasicContent(String basicContent) {
        this.basicContent = basicContent == null ? null : basicContent.trim();
    }

    /**
     * 获取履约情况
     *
     * @return credit_status - 履约情况
     */
    public String getCreditStatus() {
        return creditStatus;
    }

    /**
     * 设置履约情况
     *
     * @param creditStatus 履约情况
     */
    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus == null ? null : creditStatus.trim();
    }

    /**
     * 获取向测绘主管部门汇交成果情况
     *
     * @return submit_status - 向测绘主管部门汇交成果情况
     */
    public String getSubmitStatus() {
        return submitStatus;
    }

    /**
     * 设置向测绘主管部门汇交成果情况
     *
     * @param submitStatus 向测绘主管部门汇交成果情况
     */
    public void setSubmitStatus(String submitStatus) {
        this.submitStatus = submitStatus == null ? null : submitStatus.trim();
    }

    /**
     * 获取单位用户编号
     *
     * @return user_id - 单位用户编号
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置单位用户编号
     *
     * @param userId 单位用户编号
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取进度（百分比）
     *
     * @return schedule - 进度（百分比）
     */
    public Integer getSchedule() {
        return schedule;
    }

    /**
     * 设置进度（百分比）
     *
     * @param schedule 进度（百分比）
     */
    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * 获取更改时间
     *
     * @return modify_time - 更改时间
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置更改时间
     *
     * @param modifyTime 更改时间
     */
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
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

    /**
     * 获取项目进行状态 2:未完成 3:已完成
     *
     * @return status - 项目进行状态 2:未完成 3:已完成
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置项目进行状态 2:未完成 3:已完成
     *
     * @param status 项目进行状态 2:未完成 3:已完成
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取项目审核结果 0:通过 1:未通过 2:已提交 3:未提交
     *
     * @return audit_status - 项目审核结果 0:通过 1:未通过 2:已提交 3:未提交
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置项目审核结果 0:通过 1:未通过 2:已提交 3:未提交
     *
     * @param auditStatus 项目审核结果 0:通过 1:未通过 2:已提交 3:未提交
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取项目成果汇交状态 0:通过 1:未通过 2:已提交 3:未提交
     *
     * @return results_status - 项目成果汇交状态 0:通过 1:未通过 2:已提交 3:未提交
     */
    public Integer getResultsStatus() {
        return resultsStatus;
    }

    /**
     * 设置项目成果汇交状态 0:通过 1:未通过 2:已提交 3:未提交
     *
     * @param resultsStatus 项目成果汇交状态 0:通过 1:未通过 2:已提交 3:未提交
     */
    public void setResultsStatus(Integer resultsStatus) {
        this.resultsStatus = resultsStatus;
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
     * @return coordinate_system - 坐标系
     */
    public String getCoordinateSystem() {
        return coordinateSystem;
    }

    /**
     * 设置坐标系
     *
     * @param coordinateSystem 坐标系
     */
    public void setCoordinateSystem(String coordinateSystem) {
        this.coordinateSystem = coordinateSystem == null ? null : coordinateSystem.trim();
    }

    /**
     * 获取管理级别
     *
     * @return management_level - 管理级别
     */
    public String getManagementLevel() {
        return managementLevel;
    }

    /**
     * 设置管理级别
     *
     * @param managementLevel 管理级别
     */
    public void setManagementLevel(String managementLevel) {
        this.managementLevel = managementLevel == null ? null : managementLevel.trim();
    }

    /**
     * 获取资金来源
     *
     * @return funding_source - 资金来源
     */
    public String getFundingSource() {
        return fundingSource;
    }

    /**
     * 设置资金来源
     *
     * @param fundingSource 资金来源
     */
    public void setFundingSource(String fundingSource) {
        this.fundingSource = fundingSource == null ? null : fundingSource.trim();
    }

    /**
     * 获取
委托单位
     *
     * @return entrust_unit - 
委托单位
     */
    public String getEntrustUnit() {
        return entrustUnit;
    }

    /**
     * 设置
委托单位
     *
     * @param entrustUnit 
委托单位
     */
    public void setEntrustUnit(String entrustUnit) {
        this.entrustUnit = entrustUnit == null ? null : entrustUnit.trim();
    }

    /**
     * 获取
承建单位
     *
     * @return accept_unit - 
承建单位
     */
    public String getAcceptUnit() {
        return acceptUnit;
    }

    /**
     * 设置
承建单位
     *
     * @param acceptUnit 
承建单位
     */
    public void setAcceptUnit(String acceptUnit) {
        this.acceptUnit = acceptUnit == null ? null : acceptUnit.trim();
    }

    /**
     * 获取手机号码
     *
     * @return mobile_phone - 手机号码
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置手机号码
     *
     * @param mobilePhone 手机号码
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * 获取固定
电话
     *
     * @return phone - 固定
电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置固定
电话
     *
     * @param phone 固定
电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取项目所在地
     *
     * @return address - 项目所在地
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置项目所在地
     *
     * @param address 项目所在地
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取项目中心点
     *
     * @return center_point - 项目中心点
     */
    public String getCenterPoint() {
        return centerPoint;
    }

    /**
     * 设置项目中心点
     *
     * @param centerPoint 项目中心点
     */
    public void setCenterPoint(String centerPoint) {
        this.centerPoint = centerPoint == null ? null : centerPoint.trim();
    }

    /**
     * 获取同步状态 0：已同步 1：未同步
     *
     * @return synchronization_status - 同步状态 0：已同步 1：未同步
     */
    public Integer getSynchronizationStatus() {
        return synchronizationStatus;
    }

    /**
     * 设置同步状态 0：已同步 1：未同步
     *
     * @param synchronizationStatus 同步状态 0：已同步 1：未同步
     */
    public void setSynchronizationStatus(Integer synchronizationStatus) {
        this.synchronizationStatus = synchronizationStatus;
    }

    /**
     * 获取合同上传时间
     *
     * @return contract_time - 合同上传时间
     */
    public String getContractTime() {
        return contractTime;
    }

    /**
     * 设置合同上传时间
     *
     * @param contractTime 合同上传时间
     */
    public void setContractTime(String contractTime) {
        this.contractTime = contractTime == null ? null : contractTime.trim();
    }

    /**
     * 获取坐标
     *
     * @return coordinate - 坐标
     */
    public String getCoordinate() {
        return coordinate;
    }

    /**
     * 设置坐标
     *
     * @param coordinate 坐标
     */
    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate == null ? null : coordinate.trim();
    }
}