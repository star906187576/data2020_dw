package dw.fi;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.Arrays;
import java.util.List;

public class MyInterceptor implements Interceptor {
    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {
        String s = new String(event.getBody());
//        String s = new String(event.getBody());
        if (s.contains("\"type\":\"startup\"")){
            event.getHeaders().put("type","startup");
        }else if(s.contains("\"type\":\"event\"")){
            event.getHeaders().put("type","event");
        }
        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        for (Event event : list) {
            intercept(event);
        }
        return list;
    }

    @Override
    public void close() {

    }
    public static class Builder implements Interceptor.Builder{

        public Interceptor build() {
            return new MyInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
