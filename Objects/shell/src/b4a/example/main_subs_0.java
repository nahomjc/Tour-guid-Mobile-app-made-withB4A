package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,43);
if (RapidSub.canDelegate("activity_create")) return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="Activity.LoadLayout(\"categories\")";
Debug.ShouldStop(4096);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("categories")),main.mostCurrent.activityBA);
 BA.debugLineNum = 49;BA.debugLine="Spotlightmenu.Initialize(Me,\"Spotlightmenu\",5%y,F";
Debug.ShouldStop(65536);
main.mostCurrent._spotlightmenu.runVoidMethod ("_initialize",main.mostCurrent.activityBA,(Object)(main.getObject()),(Object)(BA.ObjectToString("Spotlightmenu")),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA))),(Object)(main.mostCurrent.__c.getField(true,"False")),(Object)(main.mostCurrent.__c.getField(true,"False")),(Object)(main.mostCurrent.__c.getField(true,"True")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), main.mostCurrent._buttoninfo.getObject()),(Object)(main.mostCurrent._activity));
 BA.debugLineNum = 50;BA.debugLine="Spotlightmenu.additem(\"taxi and train\",Colors.Bla";
Debug.ShouldStop(131072);
main.mostCurrent._spotlightmenu.runVoidMethod ("_additem",(Object)(BA.ObjectToString("taxi and train")),(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.numberCast(int.class, 15)),(Object)(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Taxi.png")))));
 BA.debugLineNum = 51;BA.debugLine="Spotlightmenu.additem(\"airlines\",Colors.Black,15,";
Debug.ShouldStop(262144);
main.mostCurrent._spotlightmenu.runVoidMethod ("_additem",(Object)(BA.ObjectToString("airlines")),(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.numberCast(int.class, 15)),(Object)(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("arf.png")))));
 BA.debugLineNum = 52;BA.debugLine="Spotlightmenu.additem(\"one day\",Colors.Black,15,L";
Debug.ShouldStop(524288);
main.mostCurrent._spotlightmenu.runVoidMethod ("_additem",(Object)(BA.ObjectToString("one day")),(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.numberCast(int.class, 15)),(Object)(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("download.jpg")))));
 BA.debugLineNum = 53;BA.debugLine="Spotlightmenu.additem(\"embassy\",Colors.Black,15,L";
Debug.ShouldStop(1048576);
main.mostCurrent._spotlightmenu.runVoidMethod ("_additem",(Object)(BA.ObjectToString("embassy")),(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.numberCast(int.class, 15)),(Object)(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("embassy cate2.jpg")))));
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,86);
if (RapidSub.canDelegate("activity_keypress")) return b4a.example.main.remoteMe.runUserSub(false, "main","activity_keypress", _keycode);
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 86;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="Select KeyCode";
Debug.ShouldStop(4194304);
switch (BA.switchObjectToInt(_keycode,main.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK"))) {
case 0: {
 BA.debugLineNum = 89;BA.debugLine="If Spotlightmenu.isOpen Then Spotlightmenu.dism";
Debug.ShouldStop(16777216);
if (main.mostCurrent._spotlightmenu.runMethod(true,"_isopen").<Boolean>get().booleanValue()) { 
main.mostCurrent._spotlightmenu.runVoidMethod ("_dismiss");}
else {
main.mostCurrent._activity.runVoidMethod ("Finish");};
 BA.debugLineNum = 90;BA.debugLine="Return True";
Debug.ShouldStop(33554432);
if (true) return main.mostCurrent.__c.getField(true,"True");
 break; }
}
;
 BA.debugLineNum = 92;BA.debugLine="Return False";
Debug.ShouldStop(134217728);
if (true) return main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,63);
if (RapidSub.canDelegate("activity_pause")) return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 63;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,58);
if (RapidSub.canDelegate("activity_resume")) return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttoncinema_click() throws Exception{
try {
		Debug.PushSubsStack("Buttoncinema_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,107);
if (RapidSub.canDelegate("buttoncinema_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","buttoncinema_click");
 BA.debugLineNum = 107;BA.debugLine="Sub Buttoncinema_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 108;BA.debugLine="data.type=\"cinema\"";
Debug.ShouldStop(2048);
main.mostCurrent._data._type = BA.ObjectToString("cinema");
 BA.debugLineNum = 109;BA.debugLine="StartActivity(type_list)";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._type_list.getObject())));
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttoncurrency_click() throws Exception{
try {
		Debug.PushSubsStack("Buttoncurrency_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,132);
if (RapidSub.canDelegate("buttoncurrency_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","buttoncurrency_click");
 BA.debugLineNum = 132;BA.debugLine="Sub Buttoncurrency_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 134;BA.debugLine="data.Type=\"currency\"";
Debug.ShouldStop(32);
main.mostCurrent._data._type = BA.ObjectToString("currency");
 BA.debugLineNum = 135;BA.debugLine="StartActivity(currency)";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._currency.getObject())));
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonhospital_click() throws Exception{
try {
		Debug.PushSubsStack("Buttonhospital_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,102);
if (RapidSub.canDelegate("buttonhospital_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","buttonhospital_click");
 BA.debugLineNum = 102;BA.debugLine="Sub Buttonhospital_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="data.type=\"hospital\"";
Debug.ShouldStop(64);
main.mostCurrent._data._type = BA.ObjectToString("hospital");
 BA.debugLineNum = 104;BA.debugLine="StartActivity(type_list)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._type_list.getObject())));
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonhotel_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonHotel_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,97);
if (RapidSub.canDelegate("buttonhotel_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","buttonhotel_click");
 BA.debugLineNum = 97;BA.debugLine="Sub ButtonHotel_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 98;BA.debugLine="data.type=\"hotel\"";
Debug.ShouldStop(2);
main.mostCurrent._data._type = BA.ObjectToString("hotel");
 BA.debugLineNum = 99;BA.debugLine="StartActivity(type_list)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._type_list.getObject())));
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttoninfo_click() throws Exception{
try {
		Debug.PushSubsStack("Buttoninfo_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,139);
if (RapidSub.canDelegate("buttoninfo_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","buttoninfo_click");
 BA.debugLineNum = 139;BA.debugLine="Sub Buttoninfo_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 140;BA.debugLine="Spotlightmenu.show";
Debug.ShouldStop(2048);
main.mostCurrent._spotlightmenu.runVoidMethod ("_show");
 BA.debugLineNum = 141;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonmall_click() throws Exception{
try {
		Debug.PushSubsStack("Buttonmall_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,127);
if (RapidSub.canDelegate("buttonmall_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","buttonmall_click");
 BA.debugLineNum = 127;BA.debugLine="Sub Buttonmall_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 128;BA.debugLine="data.Type=\"mall\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._data._type = BA.ObjectToString("mall");
 BA.debugLineNum = 129;BA.debugLine="StartActivity(type_list)";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._type_list.getObject())));
 BA.debugLineNum = 130;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonnearby_click() throws Exception{
try {
		Debug.PushSubsStack("Buttonnearby_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,148);
if (RapidSub.canDelegate("buttonnearby_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","buttonnearby_click");
 BA.debugLineNum = 148;BA.debugLine="Sub Buttonnearby_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 149;BA.debugLine="StartActivity(one_day)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._one_day.getObject())));
 BA.debugLineNum = 150;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonqr_click() throws Exception{
try {
		Debug.PushSubsStack("ButtonQR_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,143);
if (RapidSub.canDelegate("buttonqr_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","buttonqr_click");
 BA.debugLineNum = 143;BA.debugLine="Sub ButtonQR_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 144;BA.debugLine="StartActivity(about_us)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._about_us.getObject())));
 BA.debugLineNum = 146;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonrestaurants_click() throws Exception{
try {
		Debug.PushSubsStack("Buttonrestaurants_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,117);
if (RapidSub.canDelegate("buttonrestaurants_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","buttonrestaurants_click");
 BA.debugLineNum = 117;BA.debugLine="Sub Buttonrestaurants_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 118;BA.debugLine="data.type=\"restaurants\"";
Debug.ShouldStop(2097152);
main.mostCurrent._data._type = BA.ObjectToString("restaurants");
 BA.debugLineNum = 119;BA.debugLine="StartActivity(type_list)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._type_list.getObject())));
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonschool_click() throws Exception{
try {
		Debug.PushSubsStack("Buttonschool_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,122);
if (RapidSub.canDelegate("buttonschool_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","buttonschool_click");
 BA.debugLineNum = 122;BA.debugLine="Sub Buttonschool_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 123;BA.debugLine="data.type=\"school\"";
Debug.ShouldStop(67108864);
main.mostCurrent._data._type = BA.ObjectToString("school");
 BA.debugLineNum = 124;BA.debugLine="StartActivity(type_list)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._type_list.getObject())));
 BA.debugLineNum = 125;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonsupermarket_click() throws Exception{
try {
		Debug.PushSubsStack("Buttonsupermarket_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,112);
if (RapidSub.canDelegate("buttonsupermarket_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","buttonsupermarket_click");
 BA.debugLineNum = 112;BA.debugLine="Sub Buttonsupermarket_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="data.type=\"supermarket\"";
Debug.ShouldStop(65536);
main.mostCurrent._data._type = BA.ObjectToString("supermarket");
 BA.debugLineNum = 114;BA.debugLine="StartActivity(type_list)";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._type_list.getObject())));
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Private ButtonHotel As Button";
main.mostCurrent._buttonhotel = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private Buttonhospital As Button";
main.mostCurrent._buttonhospital = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private Buttoncinema As Button";
main.mostCurrent._buttoncinema = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private Buttonsupermarket As Button";
main.mostCurrent._buttonsupermarket = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private Buttonrestaurants As Button";
main.mostCurrent._buttonrestaurants = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private Buttonschool As Button";
main.mostCurrent._buttonschool = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private Buttonmall As Button";
main.mostCurrent._buttonmall = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private Buttoncurrency As Button";
main.mostCurrent._buttoncurrency = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private Spotlightmenu As SpotLight";
main.mostCurrent._spotlightmenu = RemoteObject.createNew ("b4a.example.spotlight");
 //BA.debugLineNum = 38;BA.debugLine="Private Buttoninfo As Button";
main.mostCurrent._buttoninfo = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private ButtonQR As Button";
main.mostCurrent._buttonqr = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private Buttonnearby As Button";
main.mostCurrent._buttonnearby = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
type_list_subs_0._process_globals();
data_subs_0._process_globals();
data_from_db_subs_0._process_globals();
map_subs_0._process_globals();
currency_subs_0._process_globals();
embassy_subs_0._process_globals();
one_day_subs_0._process_globals();
about_us_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
type_list.myClass = BA.getDeviceClass ("b4a.example.type_list");
data.myClass = BA.getDeviceClass ("b4a.example.data");
data_from_db.myClass = BA.getDeviceClass ("b4a.example.data_from_db");
map.myClass = BA.getDeviceClass ("b4a.example.map");
currency.myClass = BA.getDeviceClass ("b4a.example.currency");
embassy.myClass = BA.getDeviceClass ("b4a.example.embassy");
one_day.myClass = BA.getDeviceClass ("b4a.example.one_day");
about_us.myClass = BA.getDeviceClass ("b4a.example.about_us");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="Public cur As Cursor";
main._cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _spotlightmenu_click(RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("Spotlightmenu_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,66);
if (RapidSub.canDelegate("spotlightmenu_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","spotlightmenu_click", _index);
Debug.locals.put("index", _index);
 BA.debugLineNum = 66;BA.debugLine="Sub Spotlightmenu_Click(index As Int)";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="Select index";
Debug.ShouldStop(4);
switch (BA.switchObjectToInt(_index,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 69;BA.debugLine="data.Type=\"taxi\"";
Debug.ShouldStop(16);
main.mostCurrent._data._type = BA.ObjectToString("taxi");
 BA.debugLineNum = 70;BA.debugLine="StartActivity(type_list)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._type_list.getObject())));
 break; }
case 1: {
 BA.debugLineNum = 72;BA.debugLine="data.Type=\"airlines\"";
Debug.ShouldStop(128);
main.mostCurrent._data._type = BA.ObjectToString("airlines");
 BA.debugLineNum = 73;BA.debugLine="StartActivity(type_list)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._type_list.getObject())));
 break; }
case 2: {
 BA.debugLineNum = 75;BA.debugLine="data.Type=\"one_day\"";
Debug.ShouldStop(1024);
main.mostCurrent._data._type = BA.ObjectToString("one_day");
 BA.debugLineNum = 76;BA.debugLine="StartActivity(type_list)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._type_list.getObject())));
 break; }
case 3: {
 BA.debugLineNum = 78;BA.debugLine="data.Type=\"embassy\"";
Debug.ShouldStop(8192);
main.mostCurrent._data._type = BA.ObjectToString("embassy");
 BA.debugLineNum = 79;BA.debugLine="StartActivity(Map)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._map.getObject())));
 BA.debugLineNum = 80;BA.debugLine="ToastMessageShow(\"to open you have to opne the";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("to open you have to opne the internet...")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 break; }
}
;
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}