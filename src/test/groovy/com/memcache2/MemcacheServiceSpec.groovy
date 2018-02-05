package com.memcache2

import spock.lang.Specification
import spock.lang.Unroll

class MemcacheServiceSpec extends Specification {

    MemcacheService memcacheService

    def setup() {
        memcacheService = new MemcacheServiceImpl()
    }

    @Unroll
    def "should set and retrieve data by key"() {
        given:
            memcacheService.setValue('key', 'Search on a string of tokens')

        expect:
            memcacheService.getValue(key) == result

        where:
            key    | result
            'key'  | 'Search on a string of tokens'
            'key2' | null
    }

    @Unroll
    def "should return keys of documents which contain tokens"() {
        given:
            memcacheService.setValue('key1', 'Search on a string of tokens')
            memcacheService.setValue('key2', 'Search on a string of tokens to return keys of all documents that contain all tokens in the set')

        expect:
            memcacheService.search(searchString) == result

        where:
            searchString           | result
            'Search on'            | ['key1', 'key2'] as Set
            'Search on to return'  | ['key2'] as Set
            'nonexistent'          | [] as Set
            'Search nonexistent'   | [] as Set
    }

}
