package unit.com.play.service

import com.play.exception.BatmanException
import com.play.service.ArgumentSafeParserService
import spock.lang.Shared
import spock.lang.Specification

class ArgumentSafeParserServiceSpec extends Specification {

    @Shared
    def argumentSafeParser

    def setupSpec() {
        argumentSafeParser = new ArgumentSafeParserService()
    }

    def 'should return number'() {
        when:
        int result = argumentSafeParser.safeParse("99")
        then:
        noExceptionThrown()
        result == 99
    }

    def 'should return zero on incorrect input'() {
        when:
        int result = argumentSafeParser.safeParse("&d87")
        then:
        noExceptionThrown()
        result == 0
    }

    def 'should activate easter egg'() {
        when:
        argumentSafeParser.safeParse("batman")
        then:
        def ex = thrown(BatmanException.class)
        ex.message == ArgumentSafeParserService.YELLOW_UNDERLINED + "Batman" +
                ArgumentSafeParserService.RED_BOLD + " RETURN!" + ArgumentSafeParserService.RESET
    }
}
