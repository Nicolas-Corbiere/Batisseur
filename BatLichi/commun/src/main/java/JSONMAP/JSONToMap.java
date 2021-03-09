package JSONMAP;

import carte.CarteBatiment;
import carte.CarteOuvrier;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class JSONToMap extends StdDeserializer<HashMap<CarteBatiment, ArrayList<CarteOuvrier>>> {
    protected JSONToMap() {
        super(HashMap.class);
    }

    @Override
    public HashMap<CarteBatiment, ArrayList<CarteOuvrier>> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        HashMap<CarteBatiment, ArrayList<CarteOuvrier>> result = new HashMap<>();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        for (JsonNode element : node) {
            result.put(
                    jsonParser.getCodec().treeToValue(element.get("key"), CarteBatiment.class),
                    jsonParser.getCodec().treeToValue(element.get("value"), ArrayList.class)
            );
        }
        return result;
    }
}
