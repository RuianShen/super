package com.entity;

public class SystemPermissionEntity {
    /**
     * 权限自增id
     */
    private Integer permissionId;

    /**
     * 权限代码
     */
    private String permissionCode;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限类型（0菜单权限  1功能权限）
     */
    private String permissionType;

    /**
     * 备注
     */
    private String permissionMark;

    /**
     *
     * @mbg.generated 2018-11-26
     */
    public SystemPermissionEntity(Integer permissionId, String permissionCode, String permissionName, String permissionType, String permissionMark) {
        this.permissionId = permissionId;
        this.permissionCode = permissionCode;
        this.permissionName = permissionName;
        this.permissionType = permissionType;
        this.permissionMark = permissionMark;
    }

    /**
     *
     * @mbg.generated 2018-11-26
     */
    public SystemPermissionEntity() {
        super();
    }

    /**
     * 权限自增id
     * @return permission_id 权限自增id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * 权限自增id
     * @param permissionId 权限自增id
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 权限代码
     * @return permission_code 权限代码
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * 权限代码
     * @param permissionCode 权限代码
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    /**
     * 权限名称
     * @return permission_name 权限名称
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 权限名称
     * @param permissionName 权限名称
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * 权限类型（0菜单权限  1功能权限）
     * @return permission_type 权限类型（0菜单权限  1功能权限）
     */
    public String getPermissionType() {
        return permissionType;
    }

    /**
     * 权限类型（0菜单权限  1功能权限）
     * @param permissionType 权限类型（0菜单权限  1功能权限）
     */
    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType == null ? null : permissionType.trim();
    }

    /**
     * 备注
     * @return permission_mark 备注
     */
    public String getPermissionMark() {
        return permissionMark;
    }

    /**
     * 备注
     * @param permissionMark 备注
     */
    public void setPermissionMark(String permissionMark) {
        this.permissionMark = permissionMark == null ? null : permissionMark.trim();
    }
}