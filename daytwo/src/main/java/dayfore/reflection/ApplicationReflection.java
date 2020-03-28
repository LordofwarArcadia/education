package dayfore.reflection;

import java.lang.reflect.Field;

public class ApplicationReflection {

    public static void main(String[] args) throws IllegalAccessException {
        Client client = new Client();
        client.setName("Vasya");
        client.setLastName("Petrov");

        System.out.println(client.toString());

        for (Field f : client.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            f.set(client, null);
        }
        System.out.println(client);
        SomeAnnotation annotation = client.getClass().getAnnotation(SomeAnnotation.class);

    }
}

/*
        {
            [
                {
                    "name":"EUR/USD",
                    "val":1,25,
                    "type":"pair"
                },
                {
                    "name":"RSI",
                    "val":"80%",
                    "period": "15d",
                    "type":"indicator"
                }
            ]
        }

        if(jObject.type=="pair"){
            Pair pair = new Pair();
            pair.name=jObject.name;
            pair.val = jObject.val;
        }else if(jObject.type=="indicator"){
            Indicator ind = new Indicator();
            //setters
        }

        List<Class<T>> myPackageClasses = Reflection.getPackage("model").getClasses();
        for(Class<?> klass : myPackageClasses){
            if(klass.getSimpleName().toLowerString().equals(jObject.type)){
                Object t = klass.getDeclaredConstructor().newInstance();
                for(Field f: t.getClass().getDeclaredFields()){
                    for(String jsonFieldName: jObject.getFieldsNames()){
                        if(f.getName().equals(jsonFieldName)){
                            f.set(t, jObject.get(jsonFieldName));
                        }
                    }
                }
            }
        }

        class Pair {

            String name;

            Float val;

        }

        class Indicator {

            String name;

            String val;

            String period;
        }
* */