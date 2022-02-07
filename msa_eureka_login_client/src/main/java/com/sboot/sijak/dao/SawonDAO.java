package com.sboot.sijak.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sboot.sijak.vo.SawonVO;

@Mapper
public interface SawonDAO {
	public List<SawonVO> getAllInfo();
	public SawonVO getInfo(String name);
	public int insertInfo(String name, String tel);
	public int deleteInfo(String name);
	int updateInfo(String name, String tel);
}
