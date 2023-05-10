/*
 * This Spock specification was generated by the Gradle 'init' task.
 */
package measurements

import spock.lang.Specification

class MeasurementTest extends Specification {
    def "It can set and get the name"() {
        setup:
        Measurement m = new Measurement();

        when:
        m.setName("name");

        then:
        m.getName() == "name";
    }

    def "It can set and get the value"() {
        setup:
        Measurement m = new Measurement();

        when:
        m.setName("name");

        then:
        m.getName() == "name";
    }

    def "It can set and get the weight"() {
        setup:
        Measurement m = new Measurement();

        when:
        m.setName("name");

        then:
        m.getName() == "name";
    }

    def "It can accept just a value and weight"() {

    }

    def "It can accept a name, value, and weight in constructor"() {
        
    }
}
