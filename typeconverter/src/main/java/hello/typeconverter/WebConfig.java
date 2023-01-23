package hello.typeconverter;

import hello.typeconverter.convertoer.IntegerToStringConverter;
import hello.typeconverter.convertoer.IpPortToStringConverter;
import hello.typeconverter.convertoer.StringToIntegerConverter;
import hello.typeconverter.convertoer.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //주석처리 우선순위 컨버터가 포맷터 보다 높음
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        //추가
        registry.addFormatter(new MyNumberFormatter());
    }
}
