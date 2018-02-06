package com.mr.util;
import redis.clients.jedis.Jedis;
public class RedisUtil {
		public static final Jedis jedis=new Jedis("localhost");
		static{
		}
		public static void setObject(String key,Object value){
			jedis.set(key.getBytes(), SerializeUtils.serialize(value));
		}
		public static Object getObject(String key){
			byte[] bs = jedis.get(key.getBytes());
			Object object=null;
			if(bs!=null){
				object = SerializeUtils.deSerialize(bs);
			}
			return object;
		}
		public static void setObjectLife(String key,Integer time){
			jedis.expire(key, time*60);
		}

}
