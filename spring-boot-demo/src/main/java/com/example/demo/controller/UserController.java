package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@RestController
@RequestMapping(value="/demo")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	/** 
	   * 根据邮件去查找 
	   * 
	   * @param email 
	   * @return 
	   */
	  @RequestMapping(value = "/findUserByEmail") 
	  public Object getUserByEmail(String email) { 
	    System.out.println("email:" + email); 
	    User user = userDao.findByEmail(email); 
	    if (null == user) { 
	      return "暂无数据"; 
	    } else { 
	      return user; 
	    } 
	  
	  } 
	  
	  /** 
	   * 获取所有的用户信息 
	   * 
	   * @return 
	   */
	  @RequestMapping(value = "/getall") 
	  public Object getAllUser() { 
	    List<User> list = (List<User>) userDao.findAll(); 
	    if (null == list || list.size() == 0) { 
	      return "暂无数据"; 
	    } else { 
	      return list; 
	    } 
	  
	  } 
	  
	  
	  /** 
	   * 添加用户 
	   * 
	   * @param id 
	   * @param email 
	   * @param name 
	   * @return 
	   */
	  @RequestMapping(value = "/adduser") 
	  public Object addUser(String id, String email, String name) { 
	    System.out.println("email:" + email); 
	  
	    int tempId = Integer.parseInt(id); 
	    System.out.println("tempId:" + tempId + "email:" + email + "name:" + name); 
	  
	    User tempUser = new User();
	    tempUser = new User(); 
	    tempUser.setId(tempId); 
	    tempUser.setEmail(email); 
	    tempUser.setName(name); 
	    User resultUser = userDao.save(tempUser); 
	    if (null == resultUser) { 
	      return "新增用户失败"; 
	    } else { 
	      return "新增用户:" + resultUser.getName(); 
	    } 
	  
	  } 
	  
	  // 条件查询 
	  
	  /** 
	   * 获取姓名和邮箱是指定内容的用户 
	   * 
	   * @return 
	   */
	  @RequestMapping(value = "/getUser1") 
	  public Object getUser(String email, String name) { 
	    List<User> userList = userDao.findByNameAndEmail(name, email); 
	    if (null != userList && userList.size() != 0) { 
	      return userList; 
	    } else { 
	      return "没找到符合要求的用户"; 
	    } 
	  
	  } 
	  
	  /** 
	   * 获取姓名和邮箱是指定内容的用户并排序 
	   * 
	   * @return 
	   */
	  @RequestMapping(value = "/getUser2") 
	  public Object getUser2(String email, String name) { 
	    List<User> userList = userDao.findByNameAndEmailOrderByIdDesc(name, email); 
	    if (null != userList && userList.size() != 0) { 
	      return userList; 
	    } else { 
	      return "没找到符合要求的用户"; 
	    } 
	  
	  } 
	  
	  /** 
	   * 获取姓名和邮箱是指定内容的用户并排序,前两个 
	   * 
	   * @return 
	   */
	  @RequestMapping(value = "/getUser3") 
	  public Object getUser3(String email, String name) { 
	    List<User> userList = userDao.findTop2ByNameAndEmailOrderByIdDesc(name, email); 
	    if (null != userList && userList.size() != 0) { 
	      return userList; 
	    } else { 
	      return "没找到符合要求的用户"; 
	    } 
	  
	  } 
	  
	  /** 
	   * 分页获取邮箱为指定内容的数据 
	   * 
	   * @return 
	   */
	  @RequestMapping(value = "/getUser4") 
	  public Object getUser4(String email, int page) { 
	    // page 属于下标 从0开始 0代表是第一页 
	    List<User> userList = userDao.findByEmail(email, new PageRequest(page, 2)); 
	    if (null != userList && userList.size() != 0) { 
	      return userList; 
	    } else { 
	      return "没找到符合要求的用户"; 
	    } 
	  
	  } 
}
