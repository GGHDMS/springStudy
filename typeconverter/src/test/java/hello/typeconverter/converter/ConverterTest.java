package hello.typeconverter.converter;


import hello.typeconverter.convertoer.IntegerToStringConverter;
import hello.typeconverter.convertoer.IpPortToStringConverter;
import hello.typeconverter.convertoer.StringToIntegerConverter;
import hello.typeconverter.convertoer.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ConverterTest {

    @Test
    public void StringToInteger() throws Exception{
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void IntegerToString() throws Exception{
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        assertThat(result).isEqualTo("10");

    }

    @Test
    public void stringToIpPort() throws Exception{
        StringToIpPortConverter converter = new StringToIpPortConverter();
        IpPort result = converter.convert("127.0.0.1:8080");
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080) );
    }

    @Test
    public void ipPortToString() throws Exception{
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(source);
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }
}
