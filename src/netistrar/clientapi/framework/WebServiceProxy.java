package netistrar.clientapi.framework;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.google.gson.Gson;
import java.util.Map;

public class WebServiceProxy {

    private String webServiceURL;
    private Map<String, String> globalParameters;

    /**
    * Construct the proxy object with a webservice endpoint URL and optionally any global parameters
    * which will be appended to every request.
    *
    * @param String $webServiceURL
    * @param Map<String,String> $globalParameters
    */
    public WebServiceProxy(String webServiceURL, Map<String,String> globalParameters) {
        this.webServiceURL = webServiceURL;
        this.globalParameters = globalParameters;
    }


    /**
    * Implement the call method to call a proxy service
    *
    * @param String name
    * @param Map<String,Object> $params
    * @param String returnClass
    */
    public Object callMethod(String name, String httpMethod, Map<String,Object> params, Object payload, Object returnClass, Map<String, String> expectedExceptions) throws Exception {

          HttpURLConnection con = null;

		try {

			Gson gson = new Gson();


			// Construct the URL
			String urlString = this.webServiceURL + "/" + name;
			String paramString = "";

			if (params.size() > 0 || this.globalParameters.size() > 0) {

				// Encode all parameters into a single string
				ArrayList paramList = new ArrayList();

				if (params instanceof Map && params.size() > 0) {
					for (Map.Entry<String, Object> entry : params.entrySet()) {
					    String entryValue = (entry.getValue() == null ? "" : URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
						paramList.add(entry.getKey() + "=" + entryValue);
					}
				}

				if (this.globalParameters instanceof Map && this.globalParameters.size() > 0) {
					// Add the global parameters to the list as well.
					for (Map.Entry<String, String> entry : this.globalParameters.entrySet()) {
						paramList.add(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
					}
				}

				paramString = String.join("&", paramList);

				if (payload != null || httpMethod == "GET" )
					urlString += "?" + paramString;

			}


			// Connect to the webservice using POST method
			URL url = new URL(urlString);
			con = (HttpURLConnection) url.openConnection();

            if (httpMethod == "PATCH") {
				con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
				con.setRequestMethod("POST");
			} else {
				con.setRequestMethod(httpMethod);
			}

			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			con.setRequestProperty("Accept-Language", "UTF-8");

			con.setDoOutput(true);

			if (httpMethod != "GET") {

				String payloadString = null;

				if (payload != null) {
					payloadString  = URLEncoder.encode(gson.toJson(payload), "UTF-8");
				} else if (paramString.length() > 0) {
					payloadString = paramString;
				}

				if (payloadString != null) {
					OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
					wr.write(payloadString);
					wr.flush();
					wr.close();
				}
			}

			// Read the response from the service
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

			// Convert to objects using GSON before returning
			String json = content.toString();

            if (returnClass instanceof Class)
			    return gson.fromJson(json, (Class)returnClass);
            else
                return gson.fromJson(json, (Type)returnClass);

		} catch (IOException e) {

			// Read the error stream.
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

			// Convert to serialisable exception before throwing.
            Gson gson = new Gson();
            Exception exception = gson.fromJson(content.toString(), SerialisableException.class);

            if (expectedExceptions.containsKey(((SerialisableException)exception).getExceptionClass())) {
                String className = expectedExceptions.get(((SerialisableException)exception).getExceptionClass());
                exception = (Exception)gson.fromJson(content.toString(), Class.forName(className));
            }


			throw exception;
		}

    }


}