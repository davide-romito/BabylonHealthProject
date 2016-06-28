package it.davideromito.crawler.converter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for JSONConverter
 */
public class JSONConverterTest {
    TestClass tc;

    @Before
    public void setUp() throws Exception {
        tc = new TestClass();
        tc.setField1("value1");
        tc.setField2("value2");
        tc.setField3("value3");
    }

    @Test
    public void toJSON() throws Exception {
        String resultString = JSONConverter.toJSON(tc);
        String expectedString = "{\"field1\":\"value1\",\"field2\":\"value2\",\"field3\":\"value3\"}";
        assertEquals(expectedString, resultString);
    }

    private class TestClass{
        private String field1;
        private String field2;
        private String field3;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }
    }
}