package com.example.OrgEhcacheSpringboot.component;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomCacheEventLogger implements CacheEventListener<Object,Object>{

	@Override
	public void onEvent(CacheEvent<? extends Object, ? extends Object> event) {
		// TODO Auto-generated method stub
		
	}

}
