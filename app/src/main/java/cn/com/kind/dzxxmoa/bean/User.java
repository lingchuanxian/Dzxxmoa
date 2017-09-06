package cn.com.kind.dzxxmoa.bean;


import java.io.Serializable;
/**
 * 用户
 * @author ling_cx
 * @date 2017/5/4.
 */
public class User implements Serializable{
	private Boolean MultipleIdentities;
	private String Userid;
	private String UserSignon;
	private String UserName;
	private String UserDeptId;
	private String UserDeptAllIdx;
	private String UserDeptName;
	private String UserOrgId;
	private String UserOrgAllIdx;
	private String UserOrgName;
	private int UserType;
	private String UserInfos;
	private String Areacode;
	private String FlowAreacode;
	private String CurLastLoginTime;
	public Boolean getMultipleIdentities() {
		return MultipleIdentities;
	}
	public void setMultipleIdentities(Boolean multipleIdentities) {
		MultipleIdentities = multipleIdentities;
	}
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public String getUserSignon() {
		return UserSignon;
	}
	public void setUserSignon(String userSignon) {
		UserSignon = userSignon;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserDeptId() {
		return UserDeptId;
	}
	public void setUserDeptId(String userDeptId) {
		UserDeptId = userDeptId;
	}
	public String getUserDeptAllIdx() {
		return UserDeptAllIdx;
	}
	public void setUserDeptAllIdx(String userDeptAllIdx) {
		UserDeptAllIdx = userDeptAllIdx;
	}
	public String getUserDeptName() {
		return UserDeptName;
	}
	public void setUserDeptName(String userDeptName) {
		UserDeptName = userDeptName;
	}
	public String getUserOrgId() {
		return UserOrgId;
	}
	public void setUserOrgId(String userOrgId) {
		UserOrgId = userOrgId;
	}
	public String getUserOrgAllIdx() {
		return UserOrgAllIdx;
	}
	public void setUserOrgAllIdx(String userOrgAllIdx) {
		UserOrgAllIdx = userOrgAllIdx;
	}
	public String getUserOrgName() {
		return UserOrgName;
	}
	public void setUserOrgName(String userOrgName) {
		UserOrgName = userOrgName;
	}
	public int getUserType() {
		return UserType;
	}
	public void setUserType(int userType) {
		UserType = userType;
	}
	public String getUserInfos() {
		return UserInfos;
	}
	public void setUserInfos(String userInfos) {
		UserInfos = userInfos;
	}
	public String getAreacode() {
		return Areacode;
	}
	public void setAreacode(String areacode) {
		Areacode = areacode;
	}
	public String getFlowAreacode() {
		return FlowAreacode;
	}
	public void setFlowAreacode(String flowAreacode) {
		FlowAreacode = flowAreacode;
	}
	public String getCurLastLoginTime() {
		return CurLastLoginTime;
	}
	public void setCurLastLoginTime(String curLastLoginTime) {
		CurLastLoginTime = curLastLoginTime;
	}
	public User(Boolean multipleIdentities, String userid, String userSignon,
			String userName, String userDeptId, String userDeptAllIdx,
			String userDeptName, String userOrgId, String userOrgAllIdx,
			String userOrgName, int userType, String userInfos,
			String areacode, String flowAreacode, String curLastLoginTime) {
		super();
		MultipleIdentities = multipleIdentities;
		Userid = userid;
		UserSignon = userSignon;
		UserName = userName;
		UserDeptId = userDeptId;
		UserDeptAllIdx = userDeptAllIdx;
		UserDeptName = userDeptName;
		UserOrgId = userOrgId;
		UserOrgAllIdx = userOrgAllIdx;
		UserOrgName = userOrgName;
		UserType = userType;
		UserInfos = userInfos;
		Areacode = areacode;
		FlowAreacode = flowAreacode;
		CurLastLoginTime = curLastLoginTime;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [MultipleIdentities=" + MultipleIdentities + ", Userid="
				+ Userid + ", UserSignon=" + UserSignon + ", UserName="
				+ UserName + ", UserDeptId=" + UserDeptId + ", UserDeptAllIdx="
				+ UserDeptAllIdx + ", UserDeptName=" + UserDeptName
				+ ", UserOrgId=" + UserOrgId + ", UserOrgAllIdx="
				+ UserOrgAllIdx + ", UserOrgName=" + UserOrgName
				+ ", UserType=" + UserType + ", UserInfos=" + UserInfos
				+ ", Areacode=" + Areacode + ", FlowAreacode=" + FlowAreacode
				+ ", CurLastLoginTime=" + CurLastLoginTime + "]";
	}
	
	
}
