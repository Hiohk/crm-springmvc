package com.hkgroup.crm.workbench.mapper;

import com.hkgroup.crm.workbench.domain.ActivityRemark;

import java.util.List;

public interface ActivityRemarkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity_remark
     *
     * @mbggenerated Thu Sep 26 22:09:11 CST 2024
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity_remark
     *
     * @mbggenerated Thu Sep 26 22:09:11 CST 2024
     */
    int insert(ActivityRemark record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity_remark
     *
     * @mbggenerated Thu Sep 26 22:09:11 CST 2024
     */
    int insertSelective(ActivityRemark record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity_remark
     *
     * @mbggenerated Thu Sep 26 22:09:11 CST 2024
     */
    ActivityRemark selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity_remark
     *
     * @mbggenerated Thu Sep 26 22:09:11 CST 2024
     */
    int updateByPrimaryKeySelective(ActivityRemark record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity_remark
     *
     * @mbggenerated Thu Sep 26 22:09:11 CST 2024
     */
    int updateByPrimaryKey(ActivityRemark record);

    /**
     * 根据活动id查询活动备注
     *
     * @param activityId
     * @return
     */
    List<ActivityRemark> selectActivityRemarkForDetailByActivityId(String activityId);

    int insertActivityRemark(ActivityRemark remark);
    int deleteActivityRemarkById(String id);
    int updateActivityRemark(ActivityRemark remark);
}