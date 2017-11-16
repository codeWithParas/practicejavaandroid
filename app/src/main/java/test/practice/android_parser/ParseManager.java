package test.practice.android_parser;

/**
 * Created by parasmani.sharma on 16/11/2017.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.Primitives;

import org.json.JSONObject;


/**
 * Class used to parse different json
 * hint : MainObjectResponse utosearchresultHome = ParseManager.getInstance().fromJSON(response, MainObjectResponse.class);
 *
 */
public class ParseManager
{
    private static ParseManager parseManager = null;

    public static ParseManager getInstance()
    {
        if(parseManager == null)
        {
            parseManager = new ParseManager();
        }

        return parseManager;
    }

    public <T> T fromJSON(JSONObject objJson, Class<T> classOfT)
    {
        if(objJson == null)
        {
            return null;
        }

        Gson gson = (new GsonBuilder()).create();
        try
        {
            Object object = gson.fromJson(objJson.toString(), classOfT);
            return Primitives.wrap(classOfT).cast(object);
        }
        catch (Exception e)
        {
            System.out.println("ParseManager >> fromJSON >> Error while parsing JSON : " + e.toString());
            e.printStackTrace();
        }

        return null;
    }

    public String toJSON(Object obj)
    {
        if(obj == null)
        {
            return null;
        }

        Gson gson = (new GsonBuilder()).create();
        try
        {
            return gson.toJson(obj);
        }
        catch (Exception e)
        {
            System.out.println("ParseManager >> toJSON >> Error while getting JSON from object : " + e.toString());
        }

        return null;
    }


}
