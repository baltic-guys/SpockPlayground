

import groovy.json.JsonSlurper
import spock.lang.Specification

class PlaygroundSpec extends Specification {

    def 'test list' () {
        given:
        def targetList = [1,2,99]

        when:
        targetList << 67

        then:
        3 == targetList.size()
    }

    def 'advanced test list' () {
        given:
        def val = "ab"

        when:
        def list = ['1']
        list << "a${val}"

        then:
        ['1', 'aab'] == list

    }



    def 'test json' () {
        when:
        def json = new JsonSlurper().parseText('{"foo":"1"}')

        then:
        [foo:1] == json as Map
    }
}
