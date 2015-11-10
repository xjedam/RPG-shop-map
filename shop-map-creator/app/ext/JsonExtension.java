package ext;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.gson.JsonParser;
import models.JsonModel;
import models.Shop;
import org.apache.commons.lang.StringEscapeUtils;
import play.db.jpa.Model;
import play.templates.JavaExtensions;

import java.util.List;

public class JsonExtension extends JavaExtensions {
    private static Function<JsonModel, String> jsonFunc = new Function<JsonModel, String>() {
        @Override
        public String apply(JsonModel input) {
            return input.toJson();
        }
    };

    public static String toJson(List<JsonModel> models) {
        String result = "[";
        result += Joiner.on(",").join(Lists.transform(models, jsonFunc));
        result += "]";

        return result;
    }

    public static String toJson(JsonModel model) {
        return model.toJson();
    }

    public static String unescapeHtml(String str) {
        System.out.println(StringEscapeUtils.unescapeHtml(str));
        return StringEscapeUtils.unescapeHtml(str);
    }
}
