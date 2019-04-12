package com.common;

import com.entity.BookrackEntity;
import com.entity.SystemPermissionEntity;
import com.entity.SystemUserEntity;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class OperatorSession {
    public static final String SESSION_ID = "GRAPE_OPERATOR_SESSION_INFO_ID";
    public static final int upTime = 2000;
    private AtomicLong updateMark = new AtomicLong(System.currentTimeMillis());
    private SystemUserEntity userInfo;
    private List<BookrackEntity> bookrack;
    private List<SystemPermissionEntity> permissions;

    public OperatorSession() {
    }

    public OperatorSession(SystemUserEntity userInfo, List<BookrackEntity> bookrack, List<SystemPermissionEntity> permissions) {
        this.userInfo = userInfo;
        this.bookrack = bookrack;
        this.permissions = permissions;
    }

    public long getUpdateTime(){
        return updateMark.get();
    }

    public boolean setUpdateTime(long ut){
        return updateMark.compareAndSet(ut,ut+upTime);
    }

    public SystemUserEntity getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(SystemUserEntity userInfo) {
        this.userInfo = userInfo;
    }

    public List<BookrackEntity> getBookrack() {
        return bookrack;
    }

    public void setBookrack(List<BookrackEntity> bookrack) {
        this.bookrack = bookrack;
    }

    public List<SystemPermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SystemPermissionEntity> permissions) {
        this.permissions = permissions;
    }
}
