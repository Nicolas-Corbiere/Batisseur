package JSONMAP;

import carte.CarteBatiment;
import carte.CarteOuvrier;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MapToJSON extends StdSerializer<HashMap<CarteBatiment, ArrayList<CarteOuvrier>>>{
    protected MapToJSON( ) {
        super(Map.class, true);
    }

    @Override
    public void serialize(HashMap<CarteBatiment, ArrayList<CarteOuvrier>> carteBatimentArrayListHashMap, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        for (Map.Entry<CarteBatiment,ArrayList<CarteOuvrier>> element: carteBatimentArrayListHashMap.entrySet()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("key", element.getKey());
            jsonGenerator.writeObjectField("value", element.getValue());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
    }
}
