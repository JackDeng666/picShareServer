package edu.gq.bbpic.common;


public class Const {

    public static final String AUTH = "authorization"; // 验证字段

    public interface ResCode {
        int SUCCEES = 1688; // 操作成功
        int FAIL = 1024; // 操作失败
        int ERROR = 2048; // 程序出错
        int NEED_ROLE = 4096; // 需要权限
//        int ILLEGAL_ARGUMENT = 8192; // 参数错误
    }
}
