package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class one_day_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (one_day) ","one_day",8,one_day.mostCurrent.activityBA,one_day.mostCurrent,19);
if (RapidSub.canDelegate("activity_create")) return b4a.example.one_day.remoteMe.runUserSub(false, "one_day","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 19;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"QR\")";
Debug.ShouldStop(2097152);
one_day.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("QR")),one_day.mostCurrent.activityBA);
 BA.debugLineNum = 23;BA.debugLine="WebView1.LoadUrl(\"https://www.google.com/maps/pla";
Debug.ShouldStop(4194304);
one_day.mostCurrent._webview1.runVoidMethod ("LoadUrl",(Object)(RemoteObject.createImmutable("https://www.google.com/maps/place/Megenagna/@9.0204692,38.8002142,17z/data=!3m1!4b1!4m5!3m4!1s0x164b855cd643a691:0x5ce3922436b4f99a!8m2!3d9.0204692!4d38.8024029")));
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (one_day) ","one_day",8,one_day.mostCurrent.activityBA,one_day.mostCurrent,40);
if (RapidSub.canDelegate("activity_pause")) return b4a.example.one_day.remoteMe.runUserSub(false, "one_day","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (one_day) ","one_day",8,one_day.mostCurrent.activityBA,one_day.mostCurrent,31);
if (RapidSub.canDelegate("activity_resume")) return b4a.example.one_day.remoteMe.runUserSub(false, "one_day","activity_resume");
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private WebView1 As WebView";
one_day.mostCurrent._webview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}