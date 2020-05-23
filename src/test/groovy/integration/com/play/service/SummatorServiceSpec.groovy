package integration.com.play.service

import com.play.service.SummatorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
class SummatorServiceSpec extends Specification {

    @Autowired
    SummatorService summatorService

    def 'summator service should be in context'() {
        expect:
        summatorService != null
    }

    def 'summator service should correct calculate'() {
        when:
        int result = summatorService.sum("20", "22")
        then:
        noExceptionThrown()
        result == 42
    }
}
