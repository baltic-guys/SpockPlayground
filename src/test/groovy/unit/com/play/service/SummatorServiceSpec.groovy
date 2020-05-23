package unit.com.play.service

import com.play.service.ArgumentSafeParserService
import com.play.service.SummatorService
import spock.lang.Specification

class SummatorServiceSpec extends Specification {

    def 'test'() {
        given:
        def service = new SummatorService()
        service.argumentSafeParserService = new ArgumentSafeParserService()

        when:
        def result = service.sum("1", "3")

        then:
        result == 4
    }

    def 'test with mock' () {
        given:
        def service = new SummatorService()
        service.argumentSafeParserService = Mock(ArgumentSafeParserService)

        when:
        service.sum("1", "3")

        then:
        2 * service.argumentSafeParserService.safeParse("1")
        1 * service.argumentSafeParserService.safeParse("3")
    }
}
