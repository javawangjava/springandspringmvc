package com.wang.dao.impl;

import com.wang.dao.StudentDao;

import java.util.*;

public class StudentDaoImpl implements StudentDao {

    private int[] array;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties properties;

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void myMethod() {
        System.out.println("UserDao的myMethod方法执行了:");
        System.out.println("遍历数组："+ Arrays.toString(array));
        System.out.println("遍历List:"+list);
        System.out.println("遍历Set:"+set);
        System.out.println("遍历Map:"+map);
        System.out.println("遍历Properties:"+properties);
    }
}
