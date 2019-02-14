package com.stanleyidesis.cordova.plugin;
// The native Toast API
import android.widget.Toast;
// Cordova-required packages
// import org.apache.cordova.CallbackContext;
// import org.apache.cordova.CordovaPlugin;
// import org.apache.cordova.PluginResult;
// import org.json.JSONArray;
// import org.json.JSONException;
// import org.json.JSONObject;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;
import android.content.Intent;
public class ToastyPlugin extends CordovaPlugin {
  private static final String DURATION_LONG = "long";
  // @Override
  // public boolean execute(String action, JSONArray args,
  //   final CallbackContext callbackContext) {
  //     // Verify that the user sent a 'show' action
  //     if (!action.equals("show")) {
  //       callbackContext.error("\"" + action + "\" is not a recognized action.");
  //       return false;
  //     }
  //     String message;
  //     String duration;
  //     try {
  //       JSONObject options = args.getJSONObject(0);
  //       message = options.getString("message");
  //       duration = options.getString("duration");
  //     } catch (JSONException e) {
  //       callbackContext.error("Error encountered: " + e.getMessage());
  //       return false;
  //     }
  //     // Create the toast
  //     Toast toast = Toast.makeText(cordova.getActivity(), cordova.getActivity().getPackageName(),
  //       DURATION_LONG.equals(duration) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
  //     // Display toast
  //     toast.show();
  //     // Send a positive result to the callbackContext
  //     PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);

  //     callbackContext.sendPluginResult(pluginResult);
  //     return true;
  // }

  private static CallbackContext _callbackContext;

  public static CallbackContext getCallbackContext(){
      return _callbackContext;
  }

  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
      Context context=this.cordova.getActivity().getApplicationContext();
      boolean isOk = false;
      _callbackContext = callbackContext;

      try{
          Class<?> c = Class.forName("NewActivity");
          Intent intent=new Intent(context, c);
          cordova.getActivity().startActivity(intent);
          isOk = true;
      }catch(Exception e){
          callbackContext.error(e.getMessage());
          // DO nothing for while...
      }

      return isOk;
  }

}