package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class map_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (map) ","map",5,map.mostCurrent.activityBA,map.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) return b4a.example.map.remoteMe.runUserSub(false, "map","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"map\")";
Debug.ShouldStop(16777216);
map.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("map")),map.mostCurrent.activityBA);
 BA.debugLineNum = 26;BA.debugLine="If File.Exists(File.DirInternal, \"ahnr.db\") = Fal";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",map.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(map.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ahnr.db"))),map.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 27;BA.debugLine="File.Copy(File.DirAssets, \"ahnr.db\", File.DirInt";
Debug.ShouldStop(67108864);
map.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(map.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("ahnr.db")),(Object)(map.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ahnr.db")));
 };
 BA.debugLineNum = 29;BA.debugLine="cn.Initialize(File.DirInternal, \"ahnr.db\", False)";
Debug.ShouldStop(268435456);
map._cn.runVoidMethod ("Initialize",(Object)(map.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ahnr.db")),(Object)(map.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 30;BA.debugLine="show";
Debug.ShouldStop(536870912);
_show();
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (map) ","map",5,map.mostCurrent.activityBA,map.mostCurrent,39);
if (RapidSub.canDelegate("activity_pause")) return b4a.example.map.remoteMe.runUserSub(false, "map","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 39;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("Activity_Resume (map) ","map",5,map.mostCurrent.activityBA,map.mostCurrent,35);
if (RapidSub.canDelegate("activity_resume")) return b4a.example.map.remoteMe.runUserSub(false, "map","activity_resume");
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4);
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private WebView1 As WebView";
map.mostCurrent._webview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Dim cn As SQL";
map._cn = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 11;BA.debugLine="Public cur As Cursor";
map._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _show() throws Exception{
try {
		Debug.PushSubsStack("show (map) ","map",5,map.mostCurrent.activityBA,map.mostCurrent,42);
if (RapidSub.canDelegate("show")) return b4a.example.map.remoteMe.runUserSub(false, "map","show");
 BA.debugLineNum = 42;BA.debugLine="Sub show";
Debug.ShouldStop(512);
 BA.debugLineNum = 44;BA.debugLine="WebView1.LoadUrl(data.lat)";
Debug.ShouldStop(2048);
map.mostCurrent._webview1.runVoidMethod ("LoadUrl",(Object)(map.mostCurrent._data._lat));
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}