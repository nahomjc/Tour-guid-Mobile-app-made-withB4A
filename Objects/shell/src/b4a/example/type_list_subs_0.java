package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class type_list_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (type_list) ","type_list",2,type_list.mostCurrent.activityBA,type_list.mostCurrent,23);
if (RapidSub.canDelegate("activity_create")) return b4a.example.type_list.remoteMe.runUserSub(false, "type_list","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 25;BA.debugLine="Activity.Color = 0xFFFAFADF";
Debug.ShouldStop(16777216);
type_list.mostCurrent._activity.runVoidMethod ("setColor",BA.numberCast(int.class, 0xfffafadf));
 BA.debugLineNum = 27;BA.debugLine="If File.Exists(File.DirInternal, \"ahnr.db\") = Fal";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",type_list.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(type_list.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ahnr.db"))),type_list.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 28;BA.debugLine="File.Copy(File.DirAssets, \"ahnr.db\", File.DirInt";
Debug.ShouldStop(134217728);
type_list.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(type_list.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("ahnr.db")),(Object)(type_list.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ahnr.db")));
 };
 BA.debugLineNum = 32;BA.debugLine="cn.Initialize(File.DirInternal, \"ahnr.db\", False)";
Debug.ShouldStop(-2147483648);
type_list._cn.runVoidMethod ("Initialize",(Object)(type_list.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ahnr.db")),(Object)(type_list.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 34;BA.debugLine="Toolbar.Initialize(\"Toolbar\")";
Debug.ShouldStop(2);
type_list.mostCurrent._toolbar.runVoidMethod ("Initialize",type_list.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Toolbar")));
 BA.debugLineNum = 35;BA.debugLine="Activity.AddView(Toolbar,0,0,-1,56dip)";
Debug.ShouldStop(4);
type_list.mostCurrent._activity.runVoidMethod ("AddView",(Object)((type_list.mostCurrent._toolbar.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(type_list.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56)))));
 BA.debugLineNum = 36;BA.debugLine="Toolbar.Title = data.Type.ToUpperCase & \" LIST\"";
Debug.ShouldStop(8);
type_list.mostCurrent._toolbar.runMethod(false,"setTitle",BA.ObjectToCharSequence(RemoteObject.concat(type_list.mostCurrent._data._type.runMethod(true,"toUpperCase"),RemoteObject.createImmutable(" LIST"))));
 BA.debugLineNum = 37;BA.debugLine="Toolbar.Elevation=4dip";
Debug.ShouldStop(16);
type_list.mostCurrent._toolbar.runMethod(true,"setElevation",BA.numberCast(float.class, type_list.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))));
 BA.debugLineNum = 38;BA.debugLine="Toolbar.SearachView_QueryHint=\"Search by name...\"";
Debug.ShouldStop(32);
type_list.mostCurrent._toolbar.runVoidMethod ("setSearachView_QueryHint",BA.ObjectToCharSequence("Search by name..."));
 BA.debugLineNum = 41;BA.debugLine="RLV.Initializer(\"RLV\").Build";
Debug.ShouldStop(256);
type_list.mostCurrent._rlv.runMethod(false,"Initializer",type_list.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("RLV"))).runVoidMethod ("Build");
 BA.debugLineNum = 42;BA.debugLine="Activity.AddView(RLV,0,56dip,-1,100%y-56dip)";
Debug.ShouldStop(512);
type_list.mostCurrent._activity.runVoidMethod ("AddView",(Object)((type_list.mostCurrent._rlv.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(type_list.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56)))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(RemoteObject.solve(new RemoteObject[] {type_list.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),type_list.mostCurrent.activityBA),type_list.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56)))}, "-",1, 1)));
 BA.debugLineNum = 44;BA.debugLine="RLV.Gravity = Gravity.LEFT";
Debug.ShouldStop(2048);
type_list.mostCurrent._rlv.runMethod(true,"setGravity",type_list.mostCurrent.__c.getField(false,"Gravity").getField(true,"LEFT"));
 BA.debugLineNum = 45;BA.debugLine="load";
Debug.ShouldStop(4096);
_load();
 BA.debugLineNum = 46;BA.debugLine="RLV.Show(RLV.ANIMATION_ALPHAIN,1000,False)";
Debug.ShouldStop(8192);
type_list.mostCurrent._rlv.runVoidMethod ("Show",(Object)(type_list.mostCurrent._rlv.getField(true,"ANIMATION_ALPHAIN")),(Object)(BA.numberCast(int.class, 1000)),(Object)(type_list.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 47;BA.debugLine="Toolbar.FilterSearchForRecyclerListView(RLV)";
Debug.ShouldStop(16384);
type_list.mostCurrent._toolbar.runVoidMethod ("FilterSearchForRecyclerListView",(Object)(type_list.mostCurrent._rlv));
 BA.debugLineNum = 48;BA.debugLine="RLV.Divider.Add1(Colors.White,1dip)";
Debug.ShouldStop(32768);
type_list.mostCurrent._rlv.runMethod(false,"Divider").runVoidMethod ("Add1",(Object)(type_list.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(type_list.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Activity_Pause (type_list) ","type_list",2,type_list.mostCurrent.activityBA,type_list.mostCurrent,86);
if (RapidSub.canDelegate("activity_pause")) return b4a.example.type_list.remoteMe.runUserSub(false, "type_list","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 86;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_Resume (type_list) ","type_list",2,type_list.mostCurrent.activityBA,type_list.mostCurrent,82);
if (RapidSub.canDelegate("activity_resume")) return b4a.example.type_list.remoteMe.runUserSub(false, "type_list","activity_resume");
 BA.debugLineNum = 82;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(131072);
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
 //BA.debugLineNum = 17;BA.debugLine="Private RLV As Hitex_RecyclerListView";
type_list.mostCurrent._rlv = RemoteObject.createNew ("wir.hitex.recycler.Hitex_RecyclerListView");
 //BA.debugLineNum = 18;BA.debugLine="Private Toolbar As Hitex_SearchToolbar";
type_list.mostCurrent._toolbar = RemoteObject.createNew ("wir.hitex.recycler.Hitex_Toolbar");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _load() throws Exception{
try {
		Debug.PushSubsStack("load (type_list) ","type_list",2,type_list.mostCurrent.activityBA,type_list.mostCurrent,62);
if (RapidSub.canDelegate("load")) return b4a.example.type_list.remoteMe.runUserSub(false, "type_list","load");
RemoteObject _cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _name = RemoteObject.createImmutable("");
int _i = 0;
 BA.debugLineNum = 62;BA.debugLine="Sub load";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 64;BA.debugLine="Dim Cursor1 As Cursor";
Debug.ShouldStop(-2147483648);
_cursor1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor1", _cursor1);
 BA.debugLineNum = 65;BA.debugLine="Dim name As String";
Debug.ShouldStop(1);
_name = RemoteObject.createImmutable("");Debug.locals.put("name", _name);
 BA.debugLineNum = 67;BA.debugLine="Try";
Debug.ShouldStop(4);
try { BA.debugLineNum = 68;BA.debugLine="Cursor1 = cn.ExecQuery(\"SELECT name FROM '\"&data";
Debug.ShouldStop(8);
_cursor1.setObject(type_list._cn.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT name FROM '"),type_list.mostCurrent._data._type,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 69;BA.debugLine="For i = 0 To Cursor1.RowCount - 1";
Debug.ShouldStop(16);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_cursor1.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 70;BA.debugLine="Cursor1.Position = i";
Debug.ShouldStop(32);
_cursor1.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 71;BA.debugLine="name = Cursor1.GetString(\"name\")";
Debug.ShouldStop(64);
_name = _cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("name")));Debug.locals.put("name", _name);
 BA.debugLineNum = 72;BA.debugLine="RLV.AddTwoLines(name,\"\")";
Debug.ShouldStop(128);
type_list.mostCurrent._rlv.runVoidMethod ("AddTwoLines",(Object)(_name),(Object)(RemoteObject.createImmutable("")));
 }
}Debug.locals.put("i", _i);
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e11) {
			BA.rdebugUtils.runVoidMethod("setLastException",type_list.processBA, e11.toString()); BA.debugLineNum = 76;BA.debugLine="ToastMessageShow(\"Nothing found\",False)";
Debug.ShouldStop(2048);
type_list.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Nothing found")),(Object)(type_list.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Dim cn As SQL";
type_list._cn = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 11;BA.debugLine="Public cur As Cursor";
type_list._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _rlv_getfastscrollsectiontitle(RemoteObject _position) throws Exception{
try {
		Debug.PushSubsStack("RLV_GetFastscrollSectionTitle (type_list) ","type_list",2,type_list.mostCurrent.activityBA,type_list.mostCurrent,57);
if (RapidSub.canDelegate("rlv_getfastscrollsectiontitle")) return b4a.example.type_list.remoteMe.runUserSub(false, "type_list","rlv_getfastscrollsectiontitle", _position);
Debug.locals.put("Position", _position);
 BA.debugLineNum = 57;BA.debugLine="Sub RLV_GetFastscrollSectionTitle (Position As Int";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 58;BA.debugLine="Return Position";
Debug.ShouldStop(33554432);
if (true) return BA.NumberToString(_position);
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rlv_itemclick(RemoteObject _position,RemoteObject _title,RemoteObject _returnvalue) throws Exception{
try {
		Debug.PushSubsStack("RLV_ItemClick (type_list) ","type_list",2,type_list.mostCurrent.activityBA,type_list.mostCurrent,52);
if (RapidSub.canDelegate("rlv_itemclick")) return b4a.example.type_list.remoteMe.runUserSub(false, "type_list","rlv_itemclick", _position, _title, _returnvalue);
Debug.locals.put("Position", _position);
Debug.locals.put("Title", _title);
Debug.locals.put("ReturnValue", _returnvalue);
 BA.debugLineNum = 52;BA.debugLine="Sub RLV_ItemClick (Position As Int, Title As Strin";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="data.r = Title";
Debug.ShouldStop(1048576);
type_list.mostCurrent._data._r = _title;
 BA.debugLineNum = 54;BA.debugLine="StartActivity(data_from_db)";
Debug.ShouldStop(2097152);
type_list.mostCurrent.__c.runVoidMethod ("StartActivity",type_list.processBA,(Object)((type_list.mostCurrent._data_from_db.getObject())));
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}