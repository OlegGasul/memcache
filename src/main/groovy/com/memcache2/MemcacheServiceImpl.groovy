package com.memcache2

import java.util.concurrent.ConcurrentHashMap

class MemcacheServiceImpl implements MemcacheService {

    private ConcurrentHashMap data = new ConcurrentHashMap()
    private ConcurrentHashMap<String, Set<String>> tokensCache = new ConcurrentHashMap()

    @Override
    void setValue(String key, String value) {
        if (!key) {
            throw new IllegalArgumentException("Setting null key")
        }

        data[key] = value
        addToIndex(key, value)
    }

    @Override
    String getValue(String key) {
        try {
            data[key]
        } catch (Exception ex) {
            null
        }
    }

    @Override
    Set<String> search(String value) {
        if (!value) {
            throw new IllegalArgumentException("Searching null key")
        }

        def resultKeys = [] as Set
        def tokensToSearch = value.split(" ").toList().unique()

        for (String token : tokensToSearch) {
            def tokenKeys = tokensCache[token]
            if (!tokenKeys) {
                return Collections.emptySet()
            }

            if (resultKeys.empty) {
                resultKeys = tokensCache[token]
            } else {
                resultKeys = resultKeys.intersect(tokenKeys)
                if (resultKeys.empty) {
                    return Collections.emptySet()
                }
            }
        }

        resultKeys
    }

    private void addToIndex(String key, String value) {
        def tokens = value.split(" ").toList().unique()

        tokens.each { token ->
            def keys = tokensCache[token]
            if (!keys) {
                keys = ConcurrentHashMap.newKeySet()
                tokensCache[token] = keys
            }

            keys.add(key)
        }
    }
}
