package unit.com.play.service

import com.play.service.ArgumentSafeParserService
import com.play.service.SummatorService
import spock.lang.Shared
import spock.lang.Specification

class AdvancedSummatorServiceSpec extends Specification {

    @Shared
    def argumentSafeParserOldMetaclass = ArgumentSafeParserService.metaClass
    def summatorServiceOldMetaclass = SummatorService.metaClass

    @Shared
    def service = new SummatorService()

    def setupSpec() {
        mockSummatorServiceSum(service)
    }

    def 'test metaClass'() {
        given:
        def parser = ArgumentSafeParserService.newInstance()
        service.argumentSafeParserService = parser

        when:
        def resultFirst = parser.safeParse("batman")
        def resultSumFirst = service.sum("1", "2")

        then:
        resultFirst == 42
        resultSumFirst == 84

        when:
        ArgumentSafeParserService.metaClass = argumentSafeParserOldMetaclass
        SummatorService.metaClass = summatorServiceOldMetaclass

        def resultSeconds = parser.safeParse("12")
        def resultSumSecond = service.sum("1", "2")

        then:
        resultSeconds == 12
        resultSumSecond == 3
    }

    private void mockSummatorServiceSum(SummatorService service) {
        mockArgumentSafeParserService()
        SummatorService.metaClass.sum = {
            String a, String b ->
                return service.argumentSafeParserService.safeParse(a) + service.argumentSafeParserService.safeParse(b)
        }
    }

    private void mockArgumentSafeParserService() {
        ArgumentSafeParserService.metaClass.safeParse = {
            String input -> return 42
        }
    }
}
