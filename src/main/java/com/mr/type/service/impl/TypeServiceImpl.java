package com.mr.type.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.type.entity.Type;
import com.mr.type.mapper.TypeMapper;
import com.mr.type.service.TypeService;
import com.mr.util.SerializeUtils;

import redis.clients.jedis.Jedis;
@Service
public class TypeServiceImpl implements TypeService{
	
		@Autowired
		private TypeMapper typeMapper;

		@Override
		public List<Type> queryTypeList() {
			Jedis jedis=new Jedis("127.0.0.1");
			System.out.println("redis连接状态:"+jedis.ping());
			if(jedis.get("typeList")==null){
			List<Type> typeList = typeMapper.queryTypeList();
			jedis.set("typeList".getBytes(), SerializeUtils.serialize(typeList));
			}
			return (List<Type>) SerializeUtils.deSerialize(jedis.get("typeList".getBytes()));
		}

}
