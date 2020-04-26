package com.sakura.usermanage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 李七夜 on 2020/4/26 17:30
 */
@Data
@Builder
@Alias("role")
@AllArgsConstructor
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 角色编码
	 */
	private String rolecode;

	/**
	 * 角色名称
	 */
	private String rolename;

	/**
	 * 创建者
	 */
	private Long createdby;

	/**
	 * 创建时间
	 */
	private Date creationdate;

	/**
	 * 修改者
	 */
	private Long modifyby;

	/**
	 * 修改时间
	 */
	private Date modifydate;
}