package com.stanleyidesis.cordova.plugin;
// The native Toast API
import android.widget.Toast;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;

public class ToastyPlugin extends CordovaPlugin {
  private static final String DURATION_LONG = "long";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
  }

  // @Override
  // public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
  //     Context context = cordova.getActivity().getApplicationContext();
  //     if(action.equals("new_activity")) {
  //         this.openNewActivity(context);
  //         return true;
  //     }
  //     return false;
  // }

  private void openNewActivity(Context context) {
      Intent intent = new Intent( "com.stanleyidesis.cordova.plugin.NewActivity");
      // this.cordova.getActivity().startActivity(context, intent);
      this.cordova.startActivityForResult((CordovaPlugin) this, intent, 0);
  }


  @Override
  public boolean execute(String action, JSONArray args,
    final CallbackContext callbackContext) {
      // Verify that the user sent a 'show' action
      // if (!action.equals("show")) {
      //   callbackContext.error("\"" + action + "\" is not a recognized action.");
      //   return false;
      // }
      // String message;
      // String duration;
      // try {
      //   JSONObject options = args.getJSONObject(0);
      //   message = options.getString("message");
      //   duration = options.getString("duration");
      // } catch (JSONException e) {
      //   callbackContext.error("Error encountered: " + e.getMessage());
      //   return false;
      // }
      // // Create the toast
      // Toast toast = Toast.makeText(cordova.getActivity(), cordova.getActivity().getPackageName(),
      //   DURATION_LONG.equals(duration) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
      // // Display toast
      // toast.show();
      Context context = cordova.getActivity().getApplicationContext();
      this.openNewActivity(context);
      // Send a positive result to the callbackContext
      PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);

      callbackContext.sendPluginResult(pluginResult);
      return true;
  }
}