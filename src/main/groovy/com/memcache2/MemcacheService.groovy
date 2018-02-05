package com.memcache2

interface MemcacheService {

    void setValue(String key, String value)
    String getValue(String key)
    Set<String> search(String value)

}