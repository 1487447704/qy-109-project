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
@Table(name = "t_mapping_unit")
public class MappingUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 单位名称
     */
    @Column(name = "unit_name")
    private String unitName;

    /**
     * 注册地址
     */
    @Column(name = "register_address")
    private String registerAddress;

    /**
     * 注册时间
     */
    @Column(name = "register_time")
    private Date registerTime;

    /**
     * 办公地址
     */
    private String oa;

    /**
     * 法人
     */
    private String corporation;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 所属行政区
     */
    @Column(name = "owned_district")
    private String ownedDistrict;

    /**
     * 注册资金(万元)
     */
    @Column(name = "register_fund")
    private Double registerFund;

    /**
     * 统一社会信用代码
     */
    @Column(name = "social_credit_code")
    private String socialCreditCode;

    /**
     * 资质等级
     */
    @Column(name = "qualification_level")
    private String qualificationLevel;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 联系方式
     */
    @Column(name = "contact_way")
    private String contactWay;

    /**
     * 单位曾用名
     */
    @Column(name = "used_name")
    private String usedName;

    /**
     * 注册地址经度
     */
    @Column(name = "register_address_lon")
    private String registerAddressLon;

    /**
     * 注册单位纬度
     */
    @Column(name = "register_address_lat")
    private String registerAddressLat;

    /**
     * 注册地址邮编
     */
    @Column(name = "register_address_postcode")
    private String registerAddressPostcode;

    /**
     * 办公地址邮编
     */
    @Column(name = "oa_postcode")
    private String oaPostcode;

    /**
     * 办公场所面积（平方米）
     */
    @Column(name = "oa_area")
    private Double oaArea;

    /**
     * 单位成立时间
     */
    @Column(name = "establish_time")
    private Date establishTime;

    /**
     * 手机号码
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 传真号码
     */
    @Column(name = "fax_num")
    private String faxNum;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 测绘人员总数
     */
    @Column(name = "surveying_num")
    private Integer surveyingNum;

    /**
     * 职工总数
     */
    @Column(name = "staff_num")
    private Integer staffNum;

    /**
     * 单位性质
     */
    @Column(name = "unit_nature")
    private String unitNature;

    /**
     * 所属行业
     */
    @Column(name = "belong_industry")
    private String belongIndustry;

    /**
     * 证书编号
     */
    @Column(name = "certificate_code")
    private String certificateCode;

    /**
     * 发证日期
     */
    @Column(name = "certificate_send_date")
    private Date certificateSendDate;

    /**
     * 公司类型
     */
    @Column(name = "company_type")
    private String companyType;

    /**
     * 股东及控股情况
     */
    @Column(name = "stock_details")
    private String stockDetails;

    /**
     * 合资形式
     */
    @Column(name = "joint_venture")
    private String jointVenture;

    /**
     * 合资企业中方控股（%）
     */
    @Column(name = "joint_ch_p")
    private Integer jointChP;

    /**
     * 合资企业批注文号
     */
    @Column(name = "joint_ratify_code")
    private String jointRatifyCode;

    /**
     * 主管部门
     */
    @Column(name = "competent_depart")
    private String competentDepart;

    /**
     * 首次取得资质等级
     */
    @Column(name = "first_qualification_level")
    private String firstQualificationLevel;

    /**
     * 首次取得资质发证日期
     */
    @Column(name = "first_qualification_date")
    private Date firstQualificationDate;

    /**
     * 申请资质前单位进行过程
     */
    @Column(name = "qualification_process")
    private String qualificationProcess;

    /**
     * 组织机构代码
     */
    @Column(name = "organization_code")
    private String organizationCode;

    /**
     * 单位直属类型
     */
    @Column(name = "unit_type")
    private String unitType;

    /**
     * 单位用户编号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 单位审核状态 0:通过 1:未通过 2:已提交 3:未提交
     */
    @Column(name = "audit_status")
    private Integer auditStatus;

    /**
     * 
单位代码
     */
    @Column(name = "unit_code")
    private String unitCode;

    /**
     * 1白名单2
黑名单3待定
     */
    @Column(name = "unit_status")
    private Integer unitStatus;

    /**
     * 同步状态 0：已同步 1：未同步
     */
    @Column(name = "synchronization_status")
    private Integer synchronizationStatus;

    /**
     * 单位分值 默认为100分 小于60分
进黑名单,大于等于100分进白名单
     */
    private Integer score;

    /**
     * 备案业务分类: 不动产测绘和联合测绘
     */
    @Column(name = "filing_business")
    private String filingBusiness;

    /**
     * 业务范围
     */
    @Column(name = "business_scope")
    private String businessScope;

    /**
     * 单位简介
     */
    @Column(name = "unit_intro")
    private String unitIntro;

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

    /**
     * 获取单位名称
     *
     * @return unit_name - 单位名称
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置单位名称
     *
     * @param unitName 单位名称
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    /**
     * 获取注册地址
     *
     * @return register_address - 注册地址
     */
    public String getRegisterAddress() {
        return registerAddress;
    }

    /**
     * 设置注册地址
     *
     * @param registerAddress 注册地址
     */
    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress == null ? null : registerAddress.trim();
    }

    /**
     * 获取注册时间
     *
     * @return register_time - 注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置注册时间
     *
     * @param registerTime 注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 获取办公地址
     *
     * @return oa - 办公地址
     */
    public String getOa() {
        return oa;
    }

    /**
     * 设置办公地址
     *
     * @param oa 办公地址
     */
    public void setOa(String oa) {
        this.oa = oa == null ? null : oa.trim();
    }

    /**
     * 获取法人
     *
     * @return corporation - 法人
     */
    public String getCorporation() {
        return corporation;
    }

    /**
     * 设置法人
     *
     * @param corporation 法人
     */
    public void setCorporation(String corporation) {
        this.corporation = corporation == null ? null : corporation.trim();
    }

    /**
     * 获取联系人
     *
     * @return linkman - 联系人
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * 设置联系人
     *
     * @param linkman 联系人
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    /**
     * 获取所属行政区
     *
     * @return owned_district - 所属行政区
     */
    public String getOwnedDistrict() {
        return ownedDistrict;
    }

    /**
     * 设置所属行政区
     *
     * @param ownedDistrict 所属行政区
     */
    public void setOwnedDistrict(String ownedDistrict) {
        this.ownedDistrict = ownedDistrict == null ? null : ownedDistrict.trim();
    }

    /**
     * 获取注册资金(万元)
     *
     * @return register_fund - 注册资金(万元)
     */
    public Double getRegisterFund() {
        return registerFund;
    }

    /**
     * 设置注册资金(万元)
     *
     * @param registerFund 注册资金(万元)
     */
    public void setRegisterFund(Double registerFund) {
        this.registerFund = registerFund;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return social_credit_code - 统一社会信用代码
     */
    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param socialCreditCode 统一社会信用代码
     */
    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode == null ? null : socialCreditCode.trim();
    }

    /**
     * 获取资质等级
     *
     * @return qualification_level - 资质等级
     */
    public String getQualificationLevel() {
        return qualificationLevel;
    }

    /**
     * 设置资质等级
     *
     * @param qualificationLevel 资质等级
     */
    public void setQualificationLevel(String qualificationLevel) {
        this.qualificationLevel = qualificationLevel == null ? null : qualificationLevel.trim();
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取联系方式
     *
     * @return contact_way - 联系方式
     */
    public String getContactWay() {
        return contactWay;
    }

    /**
     * 设置联系方式
     *
     * @param contactWay 联系方式
     */
    public void setContactWay(String contactWay) {
        this.contactWay = contactWay == null ? null : contactWay.trim();
    }

    /**
     * 获取单位曾用名
     *
     * @return used_name - 单位曾用名
     */
    public String getUsedName() {
        return usedName;
    }

    /**
     * 设置单位曾用名
     *
     * @param usedName 单位曾用名
     */
    public void setUsedName(String usedName) {
        this.usedName = usedName == null ? null : usedName.trim();
    }

    /**
     * 获取注册地址经度
     *
     * @return register_address_lon - 注册地址经度
     */
    public String getRegisterAddressLon() {
        return registerAddressLon;
    }

    /**
     * 设置注册地址经度
     *
     * @param registerAddressLon 注册地址经度
     */
    public void setRegisterAddressLon(String registerAddressLon) {
        this.registerAddressLon = registerAddressLon == null ? null : registerAddressLon.trim();
    }

    /**
     * 获取注册单位纬度
     *
     * @return register_address_lat - 注册单位纬度
     */
    public String getRegisterAddressLat() {
        return registerAddressLat;
    }

    /**
     * 设置注册单位纬度
     *
     * @param registerAddressLat 注册单位纬度
     */
    public void setRegisterAddressLat(String registerAddressLat) {
        this.registerAddressLat = registerAddressLat == null ? null : registerAddressLat.trim();
    }

    /**
     * 获取注册地址邮编
     *
     * @return register_address_postcode - 注册地址邮编
     */
    public String getRegisterAddressPostcode() {
        return registerAddressPostcode;
    }

    /**
     * 设置注册地址邮编
     *
     * @param registerAddressPostcode 注册地址邮编
     */
    public void setRegisterAddressPostcode(String registerAddressPostcode) {
        this.registerAddressPostcode = registerAddressPostcode == null ? null : registerAddressPostcode.trim();
    }

    /**
     * 获取办公地址邮编
     *
     * @return oa_postcode - 办公地址邮编
     */
    public String getOaPostcode() {
        return oaPostcode;
    }

    /**
     * 设置办公地址邮编
     *
     * @param oaPostcode 办公地址邮编
     */
    public void setOaPostcode(String oaPostcode) {
        this.oaPostcode = oaPostcode == null ? null : oaPostcode.trim();
    }

    /**
     * 获取办公场所面积（平方米）
     *
     * @return oa_area - 办公场所面积（平方米）
     */
    public Double getOaArea() {
        return oaArea;
    }

    /**
     * 设置办公场所面积（平方米）
     *
     * @param oaArea 办公场所面积（平方米）
     */
    public void setOaArea(Double oaArea) {
        this.oaArea = oaArea;
    }

    /**
     * 获取单位成立时间
     *
     * @return establish_time - 单位成立时间
     */
    public Date getEstablishTime() {
        return establishTime;
    }

    /**
     * 设置单位成立时间
     *
     * @param establishTime 单位成立时间
     */
    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
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
     * 获取传真号码
     *
     * @return fax_num - 传真号码
     */
    public String getFaxNum() {
        return faxNum;
    }

    /**
     * 设置传真号码
     *
     * @param faxNum 传真号码
     */
    public void setFaxNum(String faxNum) {
        this.faxNum = faxNum == null ? null : faxNum.trim();
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取测绘人员总数
     *
     * @return surveying_num - 测绘人员总数
     */
    public Integer getSurveyingNum() {
        return surveyingNum;
    }

    /**
     * 设置测绘人员总数
     *
     * @param surveyingNum 测绘人员总数
     */
    public void setSurveyingNum(Integer surveyingNum) {
        this.surveyingNum = surveyingNum;
    }

    /**
     * 获取职工总数
     *
     * @return staff_num - 职工总数
     */
    public Integer getStaffNum() {
        return staffNum;
    }

    /**
     * 设置职工总数
     *
     * @param staffNum 职工总数
     */
    public void setStaffNum(Integer staffNum) {
        this.staffNum = staffNum;
    }

    /**
     * 获取单位性质
     *
     * @return unit_nature - 单位性质
     */
    public String getUnitNature() {
        return unitNature;
    }

    /**
     * 设置单位性质
     *
     * @param unitNature 单位性质
     */
    public void setUnitNature(String unitNature) {
        this.unitNature = unitNature == null ? null : unitNature.trim();
    }

    /**
     * 获取所属行业
     *
     * @return belong_industry - 所属行业
     */
    public String getBelongIndustry() {
        return belongIndustry;
    }

    /**
     * 设置所属行业
     *
     * @param belongIndustry 所属行业
     */
    public void setBelongIndustry(String belongIndustry) {
        this.belongIndustry = belongIndustry == null ? null : belongIndustry.trim();
    }

    /**
     * 获取证书编号
     *
     * @return certificate_code - 证书编号
     */
    public String getCertificateCode() {
        return certificateCode;
    }

    /**
     * 设置证书编号
     *
     * @param certificateCode 证书编号
     */
    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode == null ? null : certificateCode.trim();
    }

    /**
     * 获取发证日期
     *
     * @return certificate_send_date - 发证日期
     */
    public Date getCertificateSendDate() {
        return certificateSendDate;
    }

    /**
     * 设置发证日期
     *
     * @param certificateSendDate 发证日期
     */
    public void setCertificateSendDate(Date certificateSendDate) {
        this.certificateSendDate = certificateSendDate;
    }

    /**
     * 获取公司类型
     *
     * @return company_type - 公司类型
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * 设置公司类型
     *
     * @param companyType 公司类型
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    /**
     * 获取股东及控股情况
     *
     * @return stock_details - 股东及控股情况
     */
    public String getStockDetails() {
        return stockDetails;
    }

    /**
     * 设置股东及控股情况
     *
     * @param stockDetails 股东及控股情况
     */
    public void setStockDetails(String stockDetails) {
        this.stockDetails = stockDetails == null ? null : stockDetails.trim();
    }

    /**
     * 获取合资形式
     *
     * @return joint_venture - 合资形式
     */
    public String getJointVenture() {
        return jointVenture;
    }

    /**
     * 设置合资形式
     *
     * @param jointVenture 合资形式
     */
    public void setJointVenture(String jointVenture) {
        this.jointVenture = jointVenture == null ? null : jointVenture.trim();
    }

    /**
     * 获取合资企业中方控股（%）
     *
     * @return joint_ch_p - 合资企业中方控股（%）
     */
    public Integer getJointChP() {
        return jointChP;
    }

    /**
     * 设置合资企业中方控股（%）
     *
     * @param jointChP 合资企业中方控股（%）
     */
    public void setJointChP(Integer jointChP) {
        this.jointChP = jointChP;
    }

    /**
     * 获取合资企业批注文号
     *
     * @return joint_ratify_code - 合资企业批注文号
     */
    public String getJointRatifyCode() {
        return jointRatifyCode;
    }

    /**
     * 设置合资企业批注文号
     *
     * @param jointRatifyCode 合资企业批注文号
     */
    public void setJointRatifyCode(String jointRatifyCode) {
        this.jointRatifyCode = jointRatifyCode == null ? null : jointRatifyCode.trim();
    }

    /**
     * 获取主管部门
     *
     * @return competent_depart - 主管部门
     */
    public String getCompetentDepart() {
        return competentDepart;
    }

    /**
     * 设置主管部门
     *
     * @param competentDepart 主管部门
     */
    public void setCompetentDepart(String competentDepart) {
        this.competentDepart = competentDepart == null ? null : competentDepart.trim();
    }

    /**
     * 获取首次取得资质等级
     *
     * @return first_qualification_level - 首次取得资质等级
     */
    public String getFirstQualificationLevel() {
        return firstQualificationLevel;
    }

    /**
     * 设置首次取得资质等级
     *
     * @param firstQualificationLevel 首次取得资质等级
     */
    public void setFirstQualificationLevel(String firstQualificationLevel) {
        this.firstQualificationLevel = firstQualificationLevel == null ? null : firstQualificationLevel.trim();
    }

    /**
     * 获取首次取得资质发证日期
     *
     * @return first_qualification_date - 首次取得资质发证日期
     */
    public Date getFirstQualificationDate() {
        return firstQualificationDate;
    }

    /**
     * 设置首次取得资质发证日期
     *
     * @param firstQualificationDate 首次取得资质发证日期
     */
    public void setFirstQualificationDate(Date firstQualificationDate) {
        this.firstQualificationDate = firstQualificationDate;
    }

    /**
     * 获取申请资质前单位进行过程
     *
     * @return qualification_process - 申请资质前单位进行过程
     */
    public String getQualificationProcess() {
        return qualificationProcess;
    }

    /**
     * 设置申请资质前单位进行过程
     *
     * @param qualificationProcess 申请资质前单位进行过程
     */
    public void setQualificationProcess(String qualificationProcess) {
        this.qualificationProcess = qualificationProcess == null ? null : qualificationProcess.trim();
    }

    /**
     * 获取组织机构代码
     *
     * @return organization_code - 组织机构代码
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * 设置组织机构代码
     *
     * @param organizationCode 组织机构代码
     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    /**
     * 获取单位直属类型
     *
     * @return unit_type - 单位直属类型
     */
    public String getUnitType() {
        return unitType;
    }

    /**
     * 设置单位直属类型
     *
     * @param unitType 单位直属类型
     */
    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
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
     * 获取单位审核状态 0:通过 1:未通过 2:已提交 3:未提交
     *
     * @return audit_status - 单位审核状态 0:通过 1:未通过 2:已提交 3:未提交
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置单位审核状态 0:通过 1:未通过 2:已提交 3:未提交
     *
     * @param auditStatus 单位审核状态 0:通过 1:未通过 2:已提交 3:未提交
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取
单位代码
     *
     * @return unit_code - 
单位代码
     */
    public String getUnitCode() {
        return unitCode;
    }

    /**
     * 设置
单位代码
     *
     * @param unitCode 
单位代码
     */
    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    /**
     * 获取1白名单2
黑名单3待定
     *
     * @return unit_status - 1白名单2
黑名单3待定
     */
    public Integer getUnitStatus() {
        return unitStatus;
    }

    /**
     * 设置1白名单2
黑名单3待定
     *
     * @param unitStatus 1白名单2
黑名单3待定
     */
    public void setUnitStatus(Integer unitStatus) {
        this.unitStatus = unitStatus;
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
     * 获取单位分值 默认为100分 小于60分
进黑名单,大于等于100分进白名单
     *
     * @return score - 单位分值 默认为100分 小于60分
进黑名单,大于等于100分进白名单
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置单位分值 默认为100分 小于60分
进黑名单,大于等于100分进白名单
     *
     * @param score 单位分值 默认为100分 小于60分
进黑名单,大于等于100分进白名单
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取备案业务分类: 不动产测绘和联合测绘
     *
     * @return filing_business - 备案业务分类: 不动产测绘和联合测绘
     */
    public String getFilingBusiness() {
        return filingBusiness;
    }

    /**
     * 设置备案业务分类: 不动产测绘和联合测绘
     *
     * @param filingBusiness 备案业务分类: 不动产测绘和联合测绘
     */
    public void setFilingBusiness(String filingBusiness) {
        this.filingBusiness = filingBusiness == null ? null : filingBusiness.trim();
    }

    /**
     * 获取业务范围
     *
     * @return business_scope - 业务范围
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * 设置业务范围
     *
     * @param businessScope 业务范围
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    /**
     * 获取单位简介
     *
     * @return unit_intro - 单位简介
     */
    public String getUnitIntro() {
        return unitIntro;
    }

    /**
     * 设置单位简介
     *
     * @param unitIntro 单位简介
     */
    public void setUnitIntro(String unitIntro) {
        this.unitIntro = unitIntro == null ? null : unitIntro.trim();
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