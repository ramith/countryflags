package lk.opensource.ramithj.flags;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.ballerina.runtime.api.creators.ErrorCreator;
import io.ballerina.runtime.api.creators.ValueCreator;
import io.ballerina.runtime.api.values.BString;

public class FlagReader {

    public static Object getFlag(io.ballerina.runtime.api.values.BString countryCode) throws IOException {
        String filePath = "flags/"  + countryCode.getValue() + ".png";
        ByteArrayOutputStream result;
        try (InputStream inputStream = FlagReader.class.getClassLoader().getResourceAsStream(filePath)) {
            result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
        } catch (IOException ioe){
            throw ErrorCreator.createError(ioe);
        }
        return ValueCreator.createArrayValue(result.toByteArray());
    }
}
