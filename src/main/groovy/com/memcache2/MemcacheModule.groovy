package com.memcache2

import com.google.inject.AbstractModule
import com.google.inject.Singleton

class MemcacheModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(KeyValueHandlers)
        bind(MemcacheService).to(MemcacheServiceImpl).in(Singleton)
    }

}
