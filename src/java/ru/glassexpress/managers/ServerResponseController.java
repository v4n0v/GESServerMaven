package ru.glassexpress.managers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import ru.glassexpress.modules.db_command.DBCommand;
import ru.glassexpress.modules.select_command_factory.DBCommandFactory;
import ru.glassexpress.objects_DB.BaseObject;
import ru.glassexpress.objects_DB.Composite;
import ru.glassexpress.objects_DB.ErrorObject;
import ru.glassexpress.objects_DB.UserObject;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class ServerResponseController {

    String req;

    public synchronized String createResponse(HttpServletRequest request, UserObject user) {
        Composite compositeFromCommand;
        req = request.getQueryString();
        System.out.println("Incoming request: '"+req+"'");
        try {
            req = URLDecoder.decode(req, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("Decoded request: '"+req+"'");
        if (req!=null) {
            DBCommandFactory factory = new DBCommandFactory();

            DBCommand command = factory.createCommand(req, user);
            compositeFromCommand = command.execute();

            if (compositeFromCommand != null) {
                List<BaseObject> list = compositeFromCommand.getComponents();
                JsonArray arr = new JsonArray();

                for (BaseObject component: list){

                    arr.add( component.toJSONObject());
                }

                String s = arr.toString();
                return arr.toString();
//                return compositeFromCommand.toJSONObject().toString();

            } else {
                return createErrorResponse();
            }
        } else{
          return createErrorResponse();
        }

    }

    public synchronized String createErrorResponse(){
        Composite compositeFromCommand = new Composite();
        compositeFromCommand.addComponent(new ErrorObject("Ошибка чтения элемента из базы"));
        return compositeFromCommand.toJSONObject().toString();
    }

}