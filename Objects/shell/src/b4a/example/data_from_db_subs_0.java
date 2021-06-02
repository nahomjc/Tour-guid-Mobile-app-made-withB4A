package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class data_from_db_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"data_from_db\")";
Debug.ShouldStop(536870912);
data_from_db.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("data_from_db")),data_from_db.mostCurrent.activityBA);
 BA.debugLineNum = 32;BA.debugLine="Activity.Color = 0xFFFAFAFA";
Debug.ShouldStop(-2147483648);
data_from_db.mostCurrent._activity.runVoidMethod ("setColor",BA.numberCast(int.class, 0xfffafafa));
 BA.debugLineNum = 34;BA.debugLine="If File.Exists(File.DirInternal, \"ahnr.db\") = Fal";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",data_from_db.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(data_from_db.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ahnr.db"))),data_from_db.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 35;BA.debugLine="File.Copy(File.DirAssets, \"ahnr.db\", File.DirInt";
Debug.ShouldStop(4);
data_from_db.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(data_from_db.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("ahnr.db")),(Object)(data_from_db.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("ahnr.db")));
 };
 BA.debugLineNum = 38;BA.debugLine="cn.Initialize(File.DirInternal, \"ahnr.db\", False)";
Debug.ShouldStop(32);
data_from_db._cn.runVoidMethod ("Initialize",(Object)(data_from_db.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("ahnr.db")),(Object)(data_from_db.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 40;BA.debugLine="h.Initializer(\"h\").Header.Build";
Debug.ShouldStop(128);
data_from_db.mostCurrent._h.runMethod(false,"Initializer",data_from_db.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("h"))).runMethod(false,"Header").runVoidMethod ("Build");
 BA.debugLineNum = 41;BA.debugLine="h.HeaderPanel.LoadLayout(\"header\")";
Debug.ShouldStop(256);
data_from_db.mostCurrent._h.runMethod(false,"getHeaderPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("header")),data_from_db.mostCurrent.activityBA);
 BA.debugLineNum = 42;BA.debugLine="h.Height=47%y";
Debug.ShouldStop(512);
data_from_db.mostCurrent._h.runMethod(true,"setHeight",data_from_db.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 47)),data_from_db.mostCurrent.activityBA));
 BA.debugLineNum = 43;BA.debugLine="h.HeaderPanel.Color=Colors.Blue";
Debug.ShouldStop(1024);
data_from_db.mostCurrent._h.runMethod(false,"getHeaderPanel").runVoidMethod ("setColor",data_from_db.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"));
 BA.debugLineNum = 44;BA.debugLine="Hitex_ParallaxImageView1.Width=100%x";
Debug.ShouldStop(2048);
data_from_db.mostCurrent._hitex_parallaximageview1.runMethod(true,"setWidth",data_from_db.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),data_from_db.mostCurrent.activityBA));
 BA.debugLineNum = 45;BA.debugLine="Hitex_ParallaxImageView1.Top=0";
Debug.ShouldStop(4096);
data_from_db.mostCurrent._hitex_parallaximageview1.runMethod(true,"setTop",BA.numberCast(int.class, 0));
 BA.debugLineNum = 46;BA.debugLine="Hitex_ParallaxImageView1.Left=0";
Debug.ShouldStop(8192);
data_from_db.mostCurrent._hitex_parallaximageview1.runMethod(true,"setLeft",BA.numberCast(int.class, 0));
 BA.debugLineNum = 47;BA.debugLine="Hitex_ParallaxImageView1.Height=h.Height";
Debug.ShouldStop(16384);
data_from_db.mostCurrent._hitex_parallaximageview1.runMethod(true,"setHeight",data_from_db.mostCurrent._h.runMethod(true,"getHeight"));
 BA.debugLineNum = 48;BA.debugLine="Hitex_ParallaxImageView1.SetParallaxStyles(Hitex";
Debug.ShouldStop(32768);
data_from_db.mostCurrent._hitex_parallaximageview1.runVoidMethod ("SetParallaxStyles",(Object)(data_from_db.mostCurrent._hitex_parallaximageview1.getField(true,"Style_VerticalAlpha")));
 BA.debugLineNum = 49;BA.debugLine="Activity.AddView(h,0,56dip,-1,100%y-56dip)";
Debug.ShouldStop(65536);
data_from_db.mostCurrent._activity.runVoidMethod ("AddView",(Object)((data_from_db.mostCurrent._h.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(data_from_db.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56)))),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),(Object)(RemoteObject.solve(new RemoteObject[] {data_from_db.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),data_from_db.mostCurrent.activityBA),data_from_db.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 56)))}, "-",1, 1)));
 BA.debugLineNum = 51;BA.debugLine="h.Gravity = Gravity.LEFT";
Debug.ShouldStop(262144);
data_from_db.mostCurrent._h.runMethod(true,"setGravity",data_from_db.mostCurrent.__c.getField(false,"Gravity").getField(true,"LEFT"));
 BA.debugLineNum = 52;BA.debugLine="loa";
Debug.ShouldStop(524288);
_loa();
 BA.debugLineNum = 54;BA.debugLine="h.Show(h.ANIMATION_ALPHAIN,1000,False)";
Debug.ShouldStop(2097152);
data_from_db.mostCurrent._h.runVoidMethod ("Show",(Object)(data_from_db.mostCurrent._h.getField(true,"ANIMATION_ALPHAIN")),(Object)(BA.numberCast(int.class, 1000)),(Object)(data_from_db.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 57;BA.debugLine="h.Divider.Add1(Colors.White,1dip)";
Debug.ShouldStop(16777216);
data_from_db.mostCurrent._h.runMethod(false,"Divider").runVoidMethod ("Add1",(Object)(data_from_db.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(data_from_db.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))));
 BA.debugLineNum = 58;BA.debugLine="load";
Debug.ShouldStop(33554432);
_load();
 BA.debugLineNum = 60;BA.debugLine="image";
Debug.ShouldStop(134217728);
_image();
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Pause (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,67);
if (RapidSub.canDelegate("activity_pause")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 67;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Resume (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,63);
if (RapidSub.canDelegate("activity_resume")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","activity_resume");
 BA.debugLineNum = 63;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonback_click() throws Exception{
try {
		Debug.PushSubsStack("Buttonback_Click (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,183);
if (RapidSub.canDelegate("buttonback_click")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","buttonback_click");
 BA.debugLineNum = 183;BA.debugLine="Sub Buttonback_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 184;BA.debugLine="StartActivity(type_list)";
Debug.ShouldStop(8388608);
data_from_db.mostCurrent.__c.runVoidMethod ("StartActivity",data_from_db.processBA,(Object)((data_from_db.mostCurrent._type_list.getObject())));
 BA.debugLineNum = 185;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonhome_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonHome_Click (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,209);
if (RapidSub.canDelegate("buttonhome_click")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","buttonhome_click");
 BA.debugLineNum = 209;BA.debugLine="Sub ButtonHome_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 210;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(131072);
data_from_db.mostCurrent.__c.runVoidMethod ("StartActivity",data_from_db.processBA,(Object)((data_from_db.mostCurrent._main.getObject())));
 BA.debugLineNum = 211;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonmap_click() throws Exception{
try {
		Debug.PushSubsStack("Buttonmap_Click (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,171);
if (RapidSub.canDelegate("buttonmap_click")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","buttonmap_click");
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
 BA.debugLineNum = 171;BA.debugLine="Sub Buttonmap_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 172;BA.debugLine="Dim Cursor As Cursor";
Debug.ShouldStop(2048);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor", _cursor);
 BA.debugLineNum = 173;BA.debugLine="Cursor = cn.ExecQuery(\"SELECT map FROM '\"&data.ty";
Debug.ShouldStop(4096);
_cursor.setObject(data_from_db._cn.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT map FROM '"),data_from_db.mostCurrent._data._type,RemoteObject.createImmutable("' where name='"),data_from_db.mostCurrent._data._r,RemoteObject.createImmutable("' ")))));
 BA.debugLineNum = 174;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
Debug.ShouldStop(8192);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 175;BA.debugLine="Cursor.Position = i";
Debug.ShouldStop(16384);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 176;BA.debugLine="data.lat=Cursor.GetString(\"map\")";
Debug.ShouldStop(32768);
data_from_db.mostCurrent._data._lat = _cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("map")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 180;BA.debugLine="StartActivity(Map) 'for webview map";
Debug.ShouldStop(524288);
data_from_db.mostCurrent.__c.runVoidMethod ("StartActivity",data_from_db.processBA,(Object)((data_from_db.mostCurrent._map.getObject())));
 BA.debugLineNum = 181;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private Label1 As Label";
data_from_db.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private Label2 As Label";
data_from_db.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private Label4 As Label";
data_from_db.mostCurrent._label4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private Buttonmap As Button";
data_from_db.mostCurrent._buttonmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private ImageView1 As ImageView";
data_from_db.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private h As Hitex_RecyclerListView";
data_from_db.mostCurrent._h = RemoteObject.createNew ("wir.hitex.recycler.Hitex_RecyclerListView");
 //BA.debugLineNum = 23;BA.debugLine="Private Hitex_ParallaxImageView1 As Hitex_Paralla";
data_from_db.mostCurrent._hitex_parallaximageview1 = RemoteObject.createNew ("wir.hitex.recycler.Hitex_ParallaxImageView");
 //BA.debugLineNum = 24;BA.debugLine="Private ButtonHome As Button";
data_from_db.mostCurrent._buttonhome = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _h_itemclick(RemoteObject _position,RemoteObject _title,RemoteObject _returnvalue) throws Exception{
try {
		Debug.PushSubsStack("h_ItemClick (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,98);
if (RapidSub.canDelegate("h_itemclick")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","h_itemclick", _position, _title, _returnvalue);
RemoteObject _s = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
Debug.locals.put("Position", _position);
Debug.locals.put("Title", _title);
Debug.locals.put("ReturnValue", _returnvalue);
 BA.debugLineNum = 98;BA.debugLine="Sub h_ItemClick (Position As Int, Title As String,";
Debug.ShouldStop(2);
 BA.debugLineNum = 99;BA.debugLine="Dim s As Intent";
Debug.ShouldStop(4);
_s = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("s", _s);
 BA.debugLineNum = 100;BA.debugLine="Select ReturnValue";
Debug.ShouldStop(8);
switch (BA.switchObjectToInt(_returnvalue,RemoteObject.createImmutable((2)),RemoteObject.createImmutable((3)),RemoteObject.createImmutable((4)))) {
case 0: {
 BA.debugLineNum = 103;BA.debugLine="Dim Cursor As Cursor";
Debug.ShouldStop(64);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor", _cursor);
 BA.debugLineNum = 104;BA.debugLine="Cursor = cn.ExecQuery(\"SELECT phone FROM '\"&dat";
Debug.ShouldStop(128);
_cursor.setObject(data_from_db._cn.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT phone FROM '"),data_from_db.mostCurrent._data._type,RemoteObject.createImmutable("' where name='"),data_from_db.mostCurrent._data._r,RemoteObject.createImmutable("' ")))));
 BA.debugLineNum = 105;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
Debug.ShouldStop(256);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 106;BA.debugLine="Cursor.Position = i";
Debug.ShouldStop(512);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 107;BA.debugLine="data.lat=Cursor.GetString(\"phone\")";
Debug.ShouldStop(1024);
data_from_db.mostCurrent._data._lat = _cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("phone")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 110;BA.debugLine="s.Initialize(s.ACTION_VIEW,\"tel:+251911245434\")";
Debug.ShouldStop(8192);
_s.runVoidMethod ("Initialize",(Object)(_s.getField(true,"ACTION_VIEW")),(Object)(RemoteObject.createImmutable("tel:+251911245434")));
 BA.debugLineNum = 111;BA.debugLine="StartActivity(s)";
Debug.ShouldStop(16384);
data_from_db.mostCurrent.__c.runVoidMethod ("StartActivity",data_from_db.processBA,(Object)((_s.getObject())));
 break; }
case 1: {
 BA.debugLineNum = 115;BA.debugLine="Dim Cursor As Cursor";
Debug.ShouldStop(262144);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor", _cursor);
 BA.debugLineNum = 116;BA.debugLine="Cursor = cn.ExecQuery(\"SELECT site FROM '\"&data";
Debug.ShouldStop(524288);
_cursor.setObject(data_from_db._cn.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT site FROM '"),data_from_db.mostCurrent._data._type,RemoteObject.createImmutable("' where name='"),data_from_db.mostCurrent._data._r,RemoteObject.createImmutable("' ")))));
 BA.debugLineNum = 117;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
Debug.ShouldStop(1048576);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 118;BA.debugLine="Cursor.Position = i";
Debug.ShouldStop(2097152);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 119;BA.debugLine="data.lat=Cursor.GetString(\"site\")";
Debug.ShouldStop(4194304);
data_from_db.mostCurrent._data._lat = _cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("site")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 123;BA.debugLine="StartActivity(Map) 'webview";
Debug.ShouldStop(67108864);
data_from_db.mostCurrent.__c.runVoidMethod ("StartActivity",data_from_db.processBA,(Object)((data_from_db.mostCurrent._map.getObject())));
 break; }
case 2: {
 BA.debugLineNum = 125;BA.debugLine="Msgbox(\"\",\"ddd\")";
Debug.ShouldStop(268435456);
data_from_db.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ddd"))),data_from_db.mostCurrent.activityBA);
 break; }
}
;
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _image() throws Exception{
try {
		Debug.PushSubsStack("image (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,186);
if (RapidSub.canDelegate("image")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","image");
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _buffer = null;
int _i = 0;
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 BA.debugLineNum = 186;BA.debugLine="Sub image";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 187;BA.debugLine="Dim Cursor As Cursor";
Debug.ShouldStop(67108864);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor", _cursor);
 BA.debugLineNum = 188;BA.debugLine="Dim buffer() As Byte";
Debug.ShouldStop(134217728);
_buffer = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});Debug.locals.put("buffer", _buffer);
 BA.debugLineNum = 189;BA.debugLine="Cursor = cn.ExecQuery(\"SELECT photo FROM '\"&data.";
Debug.ShouldStop(268435456);
_cursor.setObject(data_from_db._cn.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT photo FROM '"),data_from_db.mostCurrent._data._type,RemoteObject.createImmutable("' where name='"),data_from_db.mostCurrent._data._r,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 190;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
Debug.ShouldStop(536870912);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 191;BA.debugLine="Cursor.Position = i";
Debug.ShouldStop(1073741824);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 192;BA.debugLine="buffer=Cursor.GetBlob(\"photo\")";
Debug.ShouldStop(-2147483648);
_buffer = _cursor.runMethod(false,"GetBlob",(Object)(RemoteObject.createImmutable("photo")));Debug.locals.put("buffer", _buffer);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 195;BA.debugLine="Dim in As InputStream";
Debug.ShouldStop(4);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");Debug.locals.put("in", _in);
 BA.debugLineNum = 196;BA.debugLine="in.InitializeFromBytesArray(buffer, 0, buffer.Len";
Debug.ShouldStop(8);
_in.runVoidMethod ("InitializeFromBytesArray",(Object)(_buffer),(Object)(BA.numberCast(int.class, 0)),(Object)(_buffer.getField(true,"length")));
 BA.debugLineNum = 197;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(16);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 198;BA.debugLine="bmp.Initialize2(in)";
Debug.ShouldStop(32);
_bmp.runVoidMethod ("Initialize2",(Object)((_in.getObject())));
 BA.debugLineNum = 199;BA.debugLine="Hitex_ParallaxImageView1.ImageBitmap=bmp";
Debug.ShouldStop(64);
data_from_db.mostCurrent._hitex_parallaximageview1.runMethod(false,"setImageBitmap",_bmp);
 BA.debugLineNum = 202;BA.debugLine="in.Close";
Debug.ShouldStop(512);
_in.runVoidMethod ("Close");
 BA.debugLineNum = 203;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _label1_click() throws Exception{
try {
		Debug.PushSubsStack("Label1_Click (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,145);
if (RapidSub.canDelegate("label1_click")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","label1_click");
 BA.debugLineNum = 145;BA.debugLine="Sub Label1_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 147;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _label1_longclick() throws Exception{
try {
		Debug.PushSubsStack("Label1_LongClick (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,205);
if (RapidSub.canDelegate("label1_longclick")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","label1_longclick");
 BA.debugLineNum = 205;BA.debugLine="Sub Label1_LongClick";
Debug.ShouldStop(4096);
 BA.debugLineNum = 207;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _label2_click() throws Exception{
try {
		Debug.PushSubsStack("Label2_Click (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,149);
if (RapidSub.canDelegate("label2_click")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","label2_click");
 BA.debugLineNum = 149;BA.debugLine="Sub Label2_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _label3_click() throws Exception{
try {
		Debug.PushSubsStack("Label3_Click (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,153);
if (RapidSub.canDelegate("label3_click")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","label3_click");
 BA.debugLineNum = 153;BA.debugLine="Sub Label3_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 155;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _label4_click() throws Exception{
try {
		Debug.PushSubsStack("Label4_Click (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,157);
if (RapidSub.canDelegate("label4_click")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","label4_click");
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
 BA.debugLineNum = 157;BA.debugLine="Sub Label4_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 158;BA.debugLine="Dim Cursor As Cursor";
Debug.ShouldStop(536870912);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor", _cursor);
 BA.debugLineNum = 159;BA.debugLine="Cursor = cn.ExecQuery(\"SELECT site FROM '\"&data.t";
Debug.ShouldStop(1073741824);
_cursor.setObject(data_from_db._cn.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT site FROM '"),data_from_db.mostCurrent._data._type,RemoteObject.createImmutable("' where name='"),data_from_db.mostCurrent._data._r,RemoteObject.createImmutable("' ")))));
 BA.debugLineNum = 160;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
Debug.ShouldStop(-2147483648);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 161;BA.debugLine="Cursor.Position = i";
Debug.ShouldStop(1);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 162;BA.debugLine="data.lat=Cursor.GetString(\"site\")";
Debug.ShouldStop(2);
data_from_db.mostCurrent._data._lat = _cursor.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("site")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 166;BA.debugLine="StartActivity(Map)";
Debug.ShouldStop(32);
data_from_db.mostCurrent.__c.runVoidMethod ("StartActivity",data_from_db.processBA,(Object)((data_from_db.mostCurrent._map.getObject())));
 BA.debugLineNum = 167;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loa() throws Exception{
try {
		Debug.PushSubsStack("loa (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,71);
if (RapidSub.canDelegate("loa")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","loa");
RemoteObject _cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
 BA.debugLineNum = 71;BA.debugLine="Sub loa";
Debug.ShouldStop(64);
 BA.debugLineNum = 73;BA.debugLine="Dim Cursor1 As Cursor";
Debug.ShouldStop(256);
_cursor1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor1", _cursor1);
 BA.debugLineNum = 76;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 77;BA.debugLine="Cursor1 = cn.ExecQuery(\"SELECT * FROM '\"&data.ty";
Debug.ShouldStop(4096);
_cursor1.setObject(data_from_db._cn.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM '"),data_from_db.mostCurrent._data._type,RemoteObject.createImmutable("'where name ='"),data_from_db.mostCurrent._data._r,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 78;BA.debugLine="For i = 0 To Cursor1.RowCount - 1";
Debug.ShouldStop(8192);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_cursor1.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 79;BA.debugLine="Cursor1.Position = i";
Debug.ShouldStop(16384);
_cursor1.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 82;BA.debugLine="h.AddTwoLines2(\"About\",Cursor1.GetString(\"descr";
Debug.ShouldStop(131072);
data_from_db.mostCurrent._h.runVoidMethod ("AddTwoLines2",(Object)(BA.ObjectToString("About")),(Object)(_cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("description")))),(Object)(RemoteObject.createImmutable((1))));
 BA.debugLineNum = 83;BA.debugLine="h.AddTwoLines2(\"Phone \", Cursor1.GetString(\"pho";
Debug.ShouldStop(262144);
data_from_db.mostCurrent._h.runVoidMethod ("AddTwoLines2",(Object)(BA.ObjectToString("Phone ")),(Object)(_cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("phone")))),(Object)(RemoteObject.createImmutable((2))));
 BA.debugLineNum = 84;BA.debugLine="h.AddTwoLines2(\"Website \",Cursor1.GetString(\"si";
Debug.ShouldStop(524288);
data_from_db.mostCurrent._h.runVoidMethod ("AddTwoLines2",(Object)(BA.ObjectToString("Website ")),(Object)(_cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("site")))),(Object)(RemoteObject.createImmutable((3))));
 }
}Debug.locals.put("i", _i);
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e11) {
			BA.rdebugUtils.runVoidMethod("setLastException",data_from_db.processBA, e11.toString()); BA.debugLineNum = 90;BA.debugLine="ToastMessageShow(\"Nothing found\",False)";
Debug.ShouldStop(33554432);
data_from_db.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Nothing found")),(Object)(data_from_db.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _load() throws Exception{
try {
		Debug.PushSubsStack("load (data_from_db) ","data_from_db",4,data_from_db.mostCurrent.activityBA,data_from_db.mostCurrent,133);
if (RapidSub.canDelegate("load")) return b4a.example.data_from_db.remoteMe.runUserSub(false, "data_from_db","load");
RemoteObject _cursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
 BA.debugLineNum = 133;BA.debugLine="Sub load";
Debug.ShouldStop(16);
 BA.debugLineNum = 134;BA.debugLine="Dim Cursor As Cursor";
Debug.ShouldStop(32);
_cursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor", _cursor);
 BA.debugLineNum = 136;BA.debugLine="Cursor = cn.ExecQuery(\"SELECT name,phone,descript";
Debug.ShouldStop(128);
_cursor.setObject(data_from_db._cn.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT name,phone,description,site FROM '"),data_from_db.mostCurrent._data._type,RemoteObject.createImmutable("' where name LIKE '%"),data_from_db.mostCurrent._data._r,RemoteObject.createImmutable("%'")))));
 BA.debugLineNum = 139;BA.debugLine="For i = 0 To Cursor.RowCount - 1";
Debug.ShouldStop(1024);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {_cursor.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 140;BA.debugLine="Cursor.Position = i";
Debug.ShouldStop(2048);
_cursor.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim cn As SQL";
data_from_db._cn = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 10;BA.debugLine="Public cur As Cursor";
data_from_db._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}