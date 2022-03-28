package com.alg;

import java.util.List;

/**
 * @author lingfeng
 * @create 2021/11/28 11:05
 * 假设给定部门树作为输入，结构如下:
 * public class Department{
 * private Long id;
 * private String name;
 * private List<Department>children;
 *}
 * 给定部门名称，找到所有该名称的部门id例如:输入:
 * 1,学校
 * 2一年级3二年级4三年级
 * 5语文6数学7语文 8英语
 * 9数学一组
 * 查询“语文”，则输出[5,7]
 */
public class tanmaFace02 {

}

class Department{
 private Long id;
 private String name;
 private List<Department> children;
}
