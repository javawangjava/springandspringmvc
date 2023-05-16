package com.wang.dao;

/*
 * SQL语句中设置参数  见MyBatis中的参数传递
 * Mybatis 接口方法中参数是多个时，使用 @Param("参数名称") 标记每一个参数，在映射配置文件中就需要使用 #{参数名称} 进行占位 ， 使用麻烦
 *
 * ${}拼字符串
 * #{}PreparedStatement 参数占位符？
 */
// 数据层DAO的用来操作是数据库
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountDao {

    // 转出,转入都是更新数据库的money值
    // 转出
    @Update("update tb_account set money=money-#{money} where name=#{name} ")
    void outMoney(@Param("name") String name, @Param("money") Double money);

    // 转入
    @Update("update tb_account set money=money+#{money} where name=#{name} ")
    void inMoney(@Param("name") String name, @Param("money") Double money);

}
